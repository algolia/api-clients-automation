package algoliasearch

case class EchoResponse(
    path: String,
    host: String,
    method: String,
    body: Option[String],
    queryParameters: Map[String, AnyRef],
    headers: Map[String, String],
    connectTimeout: Int,
    responseTimeout: Int
)
