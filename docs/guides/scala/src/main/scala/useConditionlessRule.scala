import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.{Consequence, Rule, TimeRange}

def useConditionlessRule(): Future[Unit] = {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val objectID = "a-rule-id";

  val rule = Rule(
    objectID = objectID,
    consequence = Consequence(
      // Set relevant consequence
    ),
    // Set validity (optional)
    validity = Some(
      Seq(
        TimeRange(
          from = Some(1_688_774_400),
          until = Some(1_738_972_800)
        )
      )
    )
  )

  client
    .saveRule(
      indexName = "<YOUR_INDEX_NAME>",
      objectID = objectID,
      rule = rule
    )
    .map { response =>
      println(response)
    }
    .recover { case ex: Exception =>
      println(s"An error occurred: ${ex.getMessage}")
    }
}
