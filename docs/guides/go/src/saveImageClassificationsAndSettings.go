package main

import (
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func saveImageClassificationsAndSettings() {
	type Image struct {
		ImageURL string           `json:"imageURL"`
		ObjectID string           `json:"objectID"`
		Objects  []map[string]any `json:"objects"`
	}

	getImageLabels := func(imageURL, objectID string, scoreLimit float64) Image {
		// Implement your image classification logic here
		return Image{
			ImageURL: imageURL,
			ObjectID: objectID,
			Objects:  []map[string]any{},
		}
	}

	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	images := []Image{}

	err = client.BrowseObjects("<YOUR_INDEX_NAME>", search.BrowseParamsObject{}, search.WithAggregator(func(res any, err error) {
		if err != nil {
			panic(err)
		}

		browseRes, ok := res.(search.BrowseResponse)
		if !ok {
			panic("Invalid response")
		}

		for _, hit := range browseRes.Hits {
			props := hit.AdditionalProperties
			imageURL, _ := props["imageURL"].(string)
			images = append(images, getImageLabels(imageURL, hit.GetObjectID(), 0.5))
		}
	}))
	if err != nil {
		panic(err)
	}

	records := make([]map[string]any, len(images))
	for i, img := range images {
		records[i] = map[string]any{
			"imageURL": img.ImageURL,
			"objectID": img.ObjectID,
			"objects":  img.Objects,
		}
	}

	_, err = client.PartialUpdateObjects(
		"<YOUR_INDEX_NAME>", records, search.WithCreateIfNotExists(true))
	if err != nil {
		panic(err)
	}

	facets := []string{}
	attributes := []string{}

	for _, record := range images {
		for _, obj := range record.Objects {
			for key, values := range obj {
				if _, ok := values.([]any); ok {
					facets = append(facets,
						fmt.Sprintf("searchable(objects.%s.label)", key),
						fmt.Sprintf("searchable(objects.%s.score)", key),
					)
					attributes = append(attributes, fmt.Sprintf("objects.%s.label)", key))
				}
			}
		}
	}

	currentSettings, err := client.GetSettings(client.NewApiGetSettingsRequest(
		"<YOUR_INDEX_NAME>"))
	if err != nil {
		panic(err)
	}

	settings := search.NewIndexSettings().
		SetSearchableAttributes(append(currentSettings.SearchableAttributes, attributes...)).
		SetAttributesForFaceting(append(currentSettings.AttributesForFaceting, facets...))

	_, err = client.SetSettings(client.NewApiSetSettingsRequest(
		"<YOUR_INDEX_NAME>", settings))
	if err != nil {
		panic(err)
	}
}
