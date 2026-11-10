require "algolia"

client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

object_id = "a-rule-id"

rule = Algolia::Search::Rule.new(
  object_id: object_id,
  # Set relevant consequence
  consequence: Algolia::Search::Consequence.new
)

# Set validity (optional)
rule.validity = [
  Algolia::Search::TimeRange.new(
    from: 1688774400,
    until: 1738972800
  )
]

client.save_rule("<YOUR_INDEX_NAME>", algolia_object_id, rule)
