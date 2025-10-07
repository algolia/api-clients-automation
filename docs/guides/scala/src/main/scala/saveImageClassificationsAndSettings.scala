import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.{BrowseParamsObject, IndexSettings}

def saveImageClassificationsAndSettings(): Future[Unit] = {
  // Retrieve labels
  def getImageLabels(imageURL: String, objectID: String, scoreLimit: Float): Image = {
    // Implement your image classification logic here
    Image(imageURL, objectID, Seq())
  }

  // API key ACL should include editSettings / addObject
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  var records: Seq[Image] = Seq.empty

  client.browseObjects(
    indexName = "<YOUR_INDEX_NAME>",
    browseParams = BrowseParamsObject(),
    aggregator = { browseResponse =>
      records = records.appendedAll(
        browseResponse.hits.map { hit =>
          val props = hit.additionalProperties.getOrElse(List()).toMap
          getImageLabels(props.get("imageURL").toString, hit.objectID, 0.5f)
        }
      )
    }
  )

  // Update records with image classifications
  client.partialUpdateObjects(
    indexName = "<YOUR_INDEX_NAME>",
    objects = records,
    createIfNotExists = true
  )

  var facets: Seq[String] = Seq.empty
  var attributes: Seq[String] = Seq.empty

  records.foreach(record => {
    record.objects.foreach(obj => {
      obj.foreach { case (key, value) =>
        if (value.isInstanceOf[scala.collection.Iterable[?]]) {
          facets = facets.appended(s"searchable(objects.${key}.label)")
          facets = facets.appended(s"searchable(objects.${key}.score)")
          attributes = attributes.appended(s"objects.${key}.label")
        }
      }
    })
  })

  val currentSettings = Await.result(
    client.getSettings(
      indexName = "<YOUR_INDEX_NAME>"
    ),
    Duration(5, "sec")
  )

  val settings = IndexSettings(
    attributesForFaceting = Some(currentSettings.attributesForFaceting.getOrElse(Seq.empty) ++ facets),
    searchableAttributes = Some(currentSettings.searchableAttributes.getOrElse(Seq.empty) ++ attributes)
  )

  client
    .setSettings(
      indexName = "<YOUR_INDEX_NAME>",
      indexSettings = settings
    )
    .map { response =>
      println(response)
    }
    .recover { case ex: Exception =>
      println(s"An error occurred: ${ex.getMessage}")
    }
}
