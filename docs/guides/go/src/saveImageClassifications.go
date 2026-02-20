package main

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func saveImageClassifications() {
	type Image struct {
		ImageURL string           `json:"imageURL"`
		ObjectID string           `json:"objectID"`
		Objects  []map[string]any `json:"objects"`
	}

	getImageLabels := func(imageURL, objectID string, _scoreLimit float64) Image {
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
}
