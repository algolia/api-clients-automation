import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions

import algoliasearch.search.SearchParamsObject
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

object Compression {
  def main(args: Array[String]): Unit = {
    implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global

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
      val result = Await.result(
        client.searchSingleIndex(
          indexName = "<YOUR_INDEX_NAME>",
          searchParams = Some(
            SearchParamsObject(
              query = Some("comedy")
            )
          )
        ),
        Duration(100, "sec")
      )
      println(result)
    } catch {
      case e: Exception => println(e)
    }
  }
}
