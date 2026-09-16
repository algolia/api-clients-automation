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
import scala.concurrent.blocking

/** Interceptor that retries requests on failure.
  *
  * @param hosts
  *   list of hosts
  * @param maxRateLimitRetries
  *   how many times to wait and retry on the same host after HTTP 429
  */
private[algoliasearch] class RetryStrategy(hosts: List[StatefulHost], maxRateLimitRetries: Int = 3)
    extends Interceptor {

  override def intercept(chain: Interceptor.Chain): Response = {
    val request = chain.request()
    val useReadTransporter = request.tag().asInstanceOf[UseReadTransporter.type]
    val callType =
      if (useReadTransporter != null || request.method() == "GET") CallType.Read
      else CallType.Write
    val errors = new ListBuffer[Throwable]()
    var rateLimitRetriesLeft = maxRateLimitRetries

    for (currentHost <- callableHosts(callType)) {
      try {
        var response = processRequest(chain, request, currentHost)
        while (isRateLimited(response) && rateLimitRetriesLeft > 0) {
          rateLimitRetriesLeft -= 1
          val waitMillis = RetryStrategy.rateLimitWaitMillis(response)
          errors += rateLimitError(response)
          response.close()
          waitForRateLimit(waitMillis)
          response = processRequest(chain, request, currentHost)
        }
        return handleResponse(currentHost, response)
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
    chain.proceed(newRequest)
  }

  private def waitForRateLimit(waitMillis: Long): Unit =
    try blocking(Thread.sleep(waitMillis))
    catch {
      case exception: InterruptedException =>
        Thread.currentThread().interrupt()
        throw AlgoliaClientException(cause = exception)
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
      val message = errorMessage(response)
      val correlationId = Option(response.header(CorrelationIdHeader))
      if (isRetryable(response)) {
        throw AlgoliaRequestException(
          message = message,
          httpErrorCode = response.code()
        ).withCorrelationId(correlationId)
      } else {
        throw AlgoliaApiException(
          message = message,
          httpErrorCode = response.code()
        ).withCorrelationId(correlationId)
      }
    } finally {
      response.close()
    }
  }

  private def isRetryable(response: Response): Boolean = {
    val statusCode = response.code()
    (statusCode < 200 || statusCode >= 300) && (statusCode < 400 || statusCode >= 500)
  }

  private def isRateLimited(response: Response): Boolean =
    response.code() == RetryStrategy.RateLimitStatusCode

  private def rateLimitError(response: Response): AlgoliaApiException =
    AlgoliaApiException(message = errorMessage(response), httpErrorCode = response.code())
      .withCorrelationId(Option(response.header(CorrelationIdHeader)))

  private def errorMessage(response: Response): String =
    if (response.body() != null) response.body().string() else response.message()

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
      case e: AlgoliaApiException    => throw e
      case e: AlgoliaClientException => throw e
      case _                         => throw AlgoliaClientException(cause = exception)
    }
  }
}

object RetryStrategy {

  /** The default expiration threshold for a host. */
  val expirationThreshold: Duration = Duration.ofMinutes(5)

  private val RateLimitStatusCode = 429
  private val DefaultRateLimitWaitMillis = 1000L

  /** `Retry-After` as milliseconds. A positive whole number of seconds is honored, anything else waits 1 second, and a
    * value too large to represent waits `Long.MaxValue` milliseconds.
    */
  private def rateLimitWaitMillis(response: Response): Long =
    Option(response.header("Retry-After")).map(_.trim).filter(_.matches("\\d+")) match {
      case None => DefaultRateLimitWaitMillis
      case Some(seconds) =>
        seconds.toLongOption match {
          case Some(value) if value > 0 =>
            try Math.multiplyExact(value, 1000L)
            catch { case _: ArithmeticException => Long.MaxValue }
          case Some(_) => DefaultRateLimitWaitMillis
          case None    => Long.MaxValue
        }
    }
}
