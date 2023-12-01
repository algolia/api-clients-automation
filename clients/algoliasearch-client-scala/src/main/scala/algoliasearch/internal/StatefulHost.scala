package algoliasearch.internal

import algoliasearch.config.{CallType, Host}
import algoliasearch.internal.util.currentDateTime

import java.time.OffsetDateTime
import scala.collection.Set

private[algoliasearch] class StatefulHost(private val host: Host) {
  private var up: Boolean = true
  private var retryCount: Int = 0
  private var lastUse: OffsetDateTime = currentDateTime()

  def getHost: String = host.url

  def getScheme: String = host.scheme

  def isUp: Boolean = up

  def getRetryCount: Int = retryCount

  def incrementRetryCount(): Unit = {
    retryCount += 1
  }

  def getLastUse: OffsetDateTime = lastUse

  def getAccept: Set[CallType] = host.callTypes

  def reset(): Unit = {
    up = true
    lastUse = currentDateTime()
    retryCount = 0
  }

  def hasTimedOut(): Unit = {
    up = true
    lastUse = currentDateTime()
    retryCount += 1
  }

  def hasFailed(): Unit = {
    up = false
    lastUse = currentDateTime()
  }
}

object StatefulHost {
  def apply(host: Host): StatefulHost = new StatefulHost(host)
}
