package main

import (
	"context"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

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
			[]search.TimeRange{{
				From:  utils.ToPtr(int64(1_688_774_400)),
				Until: utils.ToPtr(int64(1_738_972_800)),
			}},
		)

	_, err = client.SaveRule(context.Background(), "<YOUR_INDEX_NAME>", objectID, rule, nil)
	if err != nil {
		panic(err)
	}
}
