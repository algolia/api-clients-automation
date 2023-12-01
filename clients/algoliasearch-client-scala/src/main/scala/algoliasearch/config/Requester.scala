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
}
