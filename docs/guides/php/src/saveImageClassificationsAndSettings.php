<?php

use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\IndexSettings;

$getImageLabels = function ($imageURL, $objectID, $scoreLimit) {
    // Implement your image classification logic here
    return ['objectID' => '', 'imageURL' => '', 'objects' => []];
};

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

$records = [];

$hits = $client->browseObjects('<YOUR_INDEX_NAME>');
foreach ($hits as $hit) {
    $imageURL = $hit['imageURL'];
    $records[] = $getImageLabels($imageURL, $hit['objectID'], 0.5);
}

$client->partialUpdateObjects(
    '<YOUR_INDEX_NAME>',
    $records,
    true,
);

$facets = [];
$attributes = [];

foreach ($records as $record) {
    foreach ($record['objects'] as $obj) {
        foreach ($obj as $key => $values) {
            if (is_array($values)) {
                $facets[] = "searchable(objects.{$key}.label)";
                $facets[] = "searchable(objects.{$key}.score)";
                $attributes[] = "objects.{$key}.label)";
            }
        }
    }
}

$currentSettings = $client->getSettings(
    '<YOUR_INDEX_NAME>',
);

$settings = (new IndexSettings())
    ->setSearchableAttributes(array_merge($currentSettings->searchableAttributes ?? [], $attributes))
    ->setAttributesForFaceting(array_merge($currentSettings->attributesForFaceting ?? [], $facets))
;

$client->setSettings(
    '<YOUR_INDEX_NAME>',
    $settings,
);
