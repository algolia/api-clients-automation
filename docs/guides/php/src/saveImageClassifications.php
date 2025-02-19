<?php

use Algolia\AlgoliaSearch\Api\SearchClient;

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
