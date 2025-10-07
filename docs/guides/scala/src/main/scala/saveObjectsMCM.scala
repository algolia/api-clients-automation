import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.config.RequestOptions

val getAllAppIDConfigurations: () => Map[String, String] = () => {
  Map( /* A map of your MCM AppID/ApiKey pairs */ )
}

val playlists: Seq[Any] = Seq( /* Your records */ )

def saveObjectsMCM(): Future[Unit] = {
  val configurations = getAllAppIDConfigurations()

  Future
    .sequence {
      configurations.map { case (appID, apiKey) =>
        val client = new SearchClient(appID, apiKey)

        client
          .saveObjects(
            indexName = "<YOUR_INDEX_NAME>",
            objects = playlists
          )
          .recover { case ex: Exception =>
            println(s"Error for appID $appID: ${ex.getMessage}")
          }
      }
    }
    .map(_ => ())
}
