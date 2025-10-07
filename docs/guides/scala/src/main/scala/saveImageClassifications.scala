import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.BrowseParamsObject

class Image(
    val imageURL: String,
    val objectID: String,
    val objects: Seq[Map[String, Any]]
)

def saveImageClassifications(): Future[Unit] = {
  // Retrieve labels
  def getImageLabels(imageURL: String, objectID: String, scoreLimit: Float): Image = {
    // Implement your image classification logic here
    Image(imageURL, objectID, Seq())
  }

  // API key ACL should include editSettings / addObject
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val records: Seq[Image] = Seq.empty

  client.browseObjects(
    indexName = "<YOUR_INDEX_NAME>",
    browseParams = BrowseParamsObject(),
    aggregator = { browseResponse =>
      records.appendedAll(
        browseResponse.hits.map { hit =>
          val props = hit.additionalProperties.getOrElse(List()).toMap
          getImageLabels(props.get("imageURL").toString, hit.objectID, 0.5f)
        }
      )
    }
  )

  // Update records with image classifications
  client
    .partialUpdateObjects(
      indexName = "<YOUR_INDEX_NAME>",
      objects = records,
      createIfNotExists = true
    )
    .map { response =>
      println(response)
    }
    .recover { case ex: Exception =>
      println(s"An error occurred: ${ex.getMessage}")
    }
}
