import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

suspend fun useConditionlessRule() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val objectID = "a-rule-id"

  val rule =
    Rule(
      objectID = objectID,
      consequence =
        Consequence(
          // Set relevant consequence
        ),
      // Set validity (optional)
      validity = listOf(TimeRange(from = 1_688_774_400, until = 1_738_972_800)),
    )

  client.saveRule(indexName = "<YOUR_INDEX_NAME>", objectID = objectID, rule = rule)
}
