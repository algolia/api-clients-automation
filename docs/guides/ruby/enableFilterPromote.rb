condition = Algolia::Search::Condition.new(
  anchoring: Algolia::Search::Anchoring::IS,
  pattern: "{facet:brand}"
)

consequence = Algolia::Search::Consequence.new(
  filter_promotes: true
)

rule = Algolia::Search::Rule.new(
  enabled: true,
  object_id: "rule_with_filterPromotes",
  conditions: [condition],
  consequence: consequence
)
