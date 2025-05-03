package main

import "github.com/algolia/algoliasearch-client-go/v4/algolia/search"

func useConditionlessRule() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	objectID := "a-rule-id"

	rule := search.NewRule(
		objectID,
		*search.NewConsequence( /* Set relevant consequence */ ),
	). // Set validity (optional)
		SetValidity(
			[]search.TimeRange{
				*search.NewTimeRange(1_688_774_400, 1_738_972_800),
			},
		)

	_, err = client.SaveRule(client.NewApiSaveRuleRequest(
		"<YOUR_INDEX_NAME>", objectID, rule))
	if err != nil {
		panic(err)
	}
}
