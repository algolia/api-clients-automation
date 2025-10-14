package main

import (
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"
)

func enableFilterPromote() {
	condition := search.NewCondition().
		SetPattern("{facet:brand}").
		SetAnchoring(search.ANCHORING_IS)

	rule := search.NewRule(
		"rule_with_filterPromotes",
		*search.NewConsequence().SetFilterPromotes(true),
	).SetEnabled(true).SetConditions([]search.Condition{*condition})

	fmt.Printf("Rule: %#v\n", rule)
}
