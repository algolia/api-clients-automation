import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.config.RequestOptions

def saveObjectsPublicUser(): Future[Unit] = {
  val playlists: Seq[Any] = Seq() // Your records

  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  Await.result(
    client
      .saveObjects(
        indexName = "<YOUR_INDEX_NAME>",
        objects = playlists,
        waitForTasks = false,
        batchSize = 1000,
        requestOptions = Some(
          RequestOptions
            .builder()
            .withHeader("X-Algolia-User-ID", "*")
            .build()
        )
      )
      .map(_ => Future.unit),
    Duration(5, "sec")
  )
}
