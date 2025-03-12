<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\OptionalFilters;
use Algolia\AlgoliaSearch\Model\Search\SearchParamsObject;

$labels = []; // A list of labels
$reduceLabelsToFilters = function (array $labels): OptionalFilters {
    // Implement your logic here
    return new OptionalFilters();
};

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

$optionalFilters = $reduceLabelsToFilters($labels);
$searchParams = (new SearchParamsObject())
    ->setQuery('<YOUR_SEARCH_QUERY>')
    ->setOptionalFilters($optionalFilters)
;

$client->searchSingleIndex(
    '<YOUR_INDEX_NAME>',
    $searchParams,
);
