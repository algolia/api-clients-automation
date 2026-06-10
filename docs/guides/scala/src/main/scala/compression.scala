import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions

import algoliasearch.search.SearchParamsObject

object Compression {
  def main(args: Array[String]): Unit = {
    implicit val ec: scala.concurrent.ExecutionContextExecutor = scala.concurrent.ExecutionContext.global

    // Initialize the client with gzip compression enabled
    // Compression reduces the size of request bodies sent to Algolia
    val client = SearchClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      clientOptions = ClientOptions
        .builder()
        .withCompressionType(CompressionType.Gzip)
        .build()
    )

    // Search with compressed request body
    try {
      val result = scala.concurrent.Await.result(
        client.searchSingleIndex(
          indexName = "<YOUR_INDEX_NAME>",
          searchParams = Some(
            SearchParamsObject(
              query = Some("comedy")
            )
          )
        ),
        scala.concurrent.duration.Duration(100, "sec")
      )
      println(result)
    } catch {
      case e: Exception => println(e)
    }
  }
}
