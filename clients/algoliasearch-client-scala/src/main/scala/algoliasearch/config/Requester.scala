package algoliasearch.config

/** Represents a mechanism for executing HTTP requests and deserializing responses using JSON4S. It provides methods for
  * making requests and returning the desired object representation. Implementations of this trait should ensure proper
  * resource management.
  */
trait Requester extends AutoCloseable {

  /** Executes an HTTP request and deserializes the response into a specified Scala type.
    *
    * @param httpRequest
    *   The HTTP request to be executed.
    * @param requestOptions
    *   Optional request options.
    * @tparam T
    *   The type of the returned object.
    * @return
    *   The deserialized response.
    */
  def execute[T: Manifest](
      httpRequest: HttpRequest,
      requestOptions: Option[RequestOptions]
  ): T

  /** Executes an HTTP request and returns the full HTTP response: status code, headers, raw body and deserialized data.
    *
    * The default implementation throws [[UnsupportedOperationException]]; custom requesters must override it to support
    * the `*WithHTTPInfo` method derivatives.
    *
    * @param httpRequest
    *   The HTTP request to be executed.
    * @param requestOptions
    *   Optional request options.
    * @tparam T
    *   The type of the deserialized response body.
    * @return
    *   The full HTTP response.
    */
  def executeWithHttpInfo[T: Manifest](
      httpRequest: HttpRequest,
      requestOptions: Option[RequestOptions]
  ): AlgoliaHttpResponse[T] =
    throw new UnsupportedOperationException("this Requester does not expose HTTP info")
}
