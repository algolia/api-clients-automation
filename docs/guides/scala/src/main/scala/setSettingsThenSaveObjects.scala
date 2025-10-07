import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.IndexSettings

val getAppIDFor: String => String = _ => {
  "" // Implement your own logic here
}
val getIndexingApiKeyFor: String => String = _ => {
  "" // Implement your own logic here
}

def setSettingsThenSaveObjects(): Future[Unit] = {
  val playlists: Seq[Map[String, Any]] = Seq() // Your records

  playlists.foreach { playlist =>
    // Fetch from your own data storage and with your own code
    // the associated application ID and API key for this user
    val appID = getAppIDFor(playlist("user").toString)
    val apiKey = getIndexingApiKeyFor(playlist("user").toString)

    val client = SearchClient(appID, apiKey)
    val settings = IndexSettings(
      attributesForFaceting = Some(Seq("filterOnly(user)"))
    )

    Await.result(
      client.setSettings(
        indexName = "<YOUR_INDEX_NAME>",
        indexSettings = settings
      ),
      Duration(5, "sec")
    )

    Await.result(
      client.saveObjects(
        indexName = "<YOUR_INDEX_NAME>",
        objects = playlists
      ),
      Duration(5, "sec")
    )
  }

  Future.unit
}
