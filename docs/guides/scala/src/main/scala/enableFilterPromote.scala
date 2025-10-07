import scala.concurrent.ExecutionContext.Implicits.global

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.{Anchoring, Condition, Consequence, Rule}

def enableFilterPromote(): Unit = {
  val condition = Condition(
    pattern = Some("{facet:brand}"),
    anchoring = Some(Anchoring.Is)
  )

  val consequence = Consequence(
    filterPromotes = Some(true)
  )

  val rule = Rule(
    objectID = "rule_with_filterPromotes",
    conditions = Some(Seq(condition)),
    consequence = consequence
  )
}
