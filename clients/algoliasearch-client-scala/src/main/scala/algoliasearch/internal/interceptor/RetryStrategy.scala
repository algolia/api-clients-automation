package algoliasearch.internal.interceptor

import algoliasearch.config.CallType
import algoliasearch.exception.{
  AlgoliaApiException,
  AlgoliaClientException,
  AlgoliaRequestException,
  AlgoliaRetryException
}
import algoliasearch.internal.StatefulHost
import algoliasearch.internal.interceptor.RetryStrategy.expirationThreshold
import algoliasearch.internal.util._
import okhttp3.{Interceptor, Request, Response}

import java.io.IOException
import java.net.SocketTimeoutException
import java.time.Duration
import java.util.concurrent.TimeUnit
import scala.collection.mutable.ListBuffer

/** Interceptor that retries requests on failure.
  *
  * @param hosts
  *   list of hosts
  */
private[algoliasearch] class RetryStrategy(hosts: List[StatefulHost]) extends Interceptor {

  override def intercept(chain: Interceptor.Chain): Response = {
    val request = chain.request()
    val useReadTransporter = request.tag().asInstanceOf[UseReadTransporter.type]
    val callType =
      if (useReadTransporter != null || request.method() == "GET") CallType.Read
      else CallType.Write
    val errors = new ListBuffer[Throwable]()

    for (currentHost <- callableHosts(callType)) {
      try {
        return processRequest(chain, request, currentHost)
      } catch {
        case exception: Exception =>
          errors += exception
          handleException(currentHost, exception)
      }
    }
    throw AlgoliaRetryException(errors.toList)
  }

  private def processRequest(
      chain: Interceptor.Chain,
      request: Request,
      host: StatefulHost
  ): Response = {
    val urlBuilder = request
      .url()
      .newBuilder()
      .scheme(host.getScheme)
      .host(host.getHost)
    if (host.getPort.isDefined) {
      urlBuilder.port(host.getPort.get)
    }
    val newUrl = urlBuilder.build()

    val newRequest = request.newBuilder().url(newUrl).build()
    chain.withConnectTimeout(
      chain.connectTimeoutMillis() * (host.getRetryCount + 1),
      TimeUnit.MILLISECONDS
    )
    val response = chain.proceed(newRequest)
    handleResponse(host, response)
  }

  private def handleResponse(
      host: StatefulHost,
      response: Response
  ): Response = {
    if (response.isSuccessful) {
      host.reset()
      return response
    }

    try {
      val message =
        if (response.body() != null) response.body().string()
        else response.message()
      if (isRetryable(response)) {
        throw AlgoliaRequestException(
          message = message,
          httpErrorCode = response.code()
        )
      } else {
        throw AlgoliaApiException(
          message = message,
          httpErrorCode = response.code()
        )
      }
    } finally {
      response.close()
    }
  }

  private def isRetryable(response: Response): Boolean = {
    val statusCode = response.code()
    (statusCode < 200 || statusCode >= 300) && (statusCode < 400 || statusCode >= 500)
  }

  private def callableHosts(callType: CallType): List[StatefulHost] =
    this.synchronized {
      resetExpiredHosts()
      val hostsCallType = hosts.filter(_.getAccept.contains(callType))
      val hostsCallTypeAreUp = hostsCallType.filter(_.isUp)
      if (hostsCallTypeAreUp.isEmpty) {
        hostsCallType.foreach(_.reset())
        hostsCallType
      } else {
        hostsCallTypeAreUp
      }
    }

  private def resetExpiredHosts(): Unit = {
    val now = currentDateTime()
    hosts.foreach { host =>
      val lastUse = Duration.between(host.getLastUse, now).getSeconds
      if (!host.isUp && lastUse > expirationThreshold.getSeconds) {
        host.reset()
      }
    }
  }

  private def handleException(
      currentHost: StatefulHost,
      exception: Exception
  ): Unit = {
    exception match {
      case _: SocketTimeoutException => currentHost.hasTimedOut()
      case _: AlgoliaRequestException | _: IOException =>
        currentHost.hasFailed()
      case e: AlgoliaApiException => throw e
      case _                      => throw AlgoliaClientException(cause = exception)
    }
  }
}

object RetryStrategy {

  /** The default expiration threshold for a host. */
  val expirationThreshold: Duration = Duration.ofMinutes(5)
}
