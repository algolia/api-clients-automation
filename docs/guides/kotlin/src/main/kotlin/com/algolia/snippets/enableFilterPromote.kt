import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.transport.*
import com.algolia.client.extensions.*

import com.algolia.client.model.search.*

suspend fun enableFilterPromote() {
  val condition = Condition(
    pattern = "{facet:brand}",
    anchoring = Anchoring.Is,
  )

  val consequence = Consequence(
    filterPromotes = true,
  )

  val rule = Rule(
    objectID = "rule_with_filterPromotes",
    conditions = listOf(condition),
    consequence = consequence,
  )
}
