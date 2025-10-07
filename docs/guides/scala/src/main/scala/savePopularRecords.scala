import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.{BrowseParamsObject, BrowseResponse}

case class Record(
    twitterHandle: String,
    nbFollowers: Int,
    isPopular: Boolean
)

def savePopularRecords(): Future[Unit] = {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  var records: Seq[Record] = Seq.empty

  client
    .browseObjects(
      "<YOUR_INDEX_NAME>",
      BrowseParamsObject(),
      aggregator = (response: BrowseResponse) => {
        records = records ++ response.hits.map { hit =>
          val props = hit.additionalProperties.getOrElse(List()).toMap

          var nbFollowers = props("nbFollowers").toString.toInt

          Record(
            twitterHandle = props("twitterHandle").toString,
            nbFollowers = nbFollowers,
            isPopular = nbFollowers > 1000000
          )
        }
      }
    )
    .flatMap { _ =>
      client.saveObjects(
        indexName = "<YOUR_INDEX_NAME>",
        objects = records
      )

      Future.unit
    }
    .recover { case ex: Exception =>
      println(s"An error occurred: ${ex.getMessage}")
    }
}
