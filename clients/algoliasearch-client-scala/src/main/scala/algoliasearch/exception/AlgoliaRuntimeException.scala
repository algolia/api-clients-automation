package algoliasearch.exception

/** Algolia runtime exception.
  *
  * @param message
  *   the detail message
  * @param cause
  *   the cause of the exception
  */
sealed abstract class AlgoliaRuntimeException(
    message: String = null,
    cause: Throwable = null
) extends RuntimeException(message, cause) {

  private var _correlationId: Option[String] = None

  /** The `Correlation-ID` returned by the Algolia cluster along with the failed response, when it sent one. Quote it in
    * support requests.
    */
  def correlationId: Option[String] = _correlationId

  private[algoliasearch] def withCorrelationId(id: Option[String]): this.type = {
    _correlationId = id
    this
  }

  override def getMessage: String = correlationId match {
    case Some(id) => s"${super.getMessage} (Correlation-ID: $id)"
    case None     => super.getMessage
  }
}

/** Exception thrown when an error occurs during API requests.
  *
  * @param message
  *   the detail message
  * @param cause
  *   the cause of the exception
  */
case class AlgoliaClientException(
    message: String = null,
    cause: Throwable = null
) extends AlgoliaRuntimeException(message, cause)

/** Exception thrown in case of API failure.
  *
  * @param message
  *   the detail message
  * @param cause
  *   the cause of the exception
  * @param httpErrorCode
  *   HTTP error code
  */
case class AlgoliaApiException(
    message: String = null,
    cause: Throwable = null,
    httpErrorCode: Int = -1
) extends AlgoliaRuntimeException(message, cause)

/** Exception thrown when an error occurs during API requests.
  *
  * @param message
  *   the detail message
  * @param cause
  *   the cause of the exception
  */
case class AlgoliaRequestException(
    message: String = null,
    cause: Throwable = null,
    httpErrorCode: Int = -1
) extends AlgoliaRuntimeException(message, cause)

/** Exception thrown when all hosts are unreachable. When several errors occurred, use the last one as the cause for the
  * returned exception.
  *
  * @param exceptions
  *   list of thrown exceptions
  */
case class AlgoliaRetryException(
    exceptions: List[Throwable]
) extends AlgoliaRuntimeException(
      "Error(s) while processing the retry strategy. If the error persists, please visit our help center https://alg.li/support-unreachable-hosts or reach out to the Algolia Support team: https://alg.li/support",
      exceptions.lastOption.orNull
    ) {

  /** The `Correlation-ID` of the last attempt that carried one. Attempts that timed out have no response headers, so a
    * timeout-only failure has none.
    */
  override def correlationId: Option[String] =
    exceptions.reverseIterator.collectFirst {
      case exception: AlgoliaRuntimeException if exception.correlationId.isDefined => exception.correlationId.get
    }
}

/** Exception thrown when an error occurs during the wait strategy. For example: maximum number of retry exceeded.
  *
  * @param message
  *   the detail message
  */
case class AlgoliaWaitException(
    message: String = null
) extends AlgoliaRuntimeException(message)
