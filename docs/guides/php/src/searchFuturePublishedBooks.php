<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\SearchParamsObject;

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

$dateTimestamp = time();
$searchParams = (new SearchParamsObject())
    ->setQuery('<YOUR_SEARCH_QUERY>')
    ->setFilters('date_timestamp > '.$dateTimestamp)
;

$client->searchSingleIndex(
    '<YOUR_INDEX_NAME>',
    $searchParams,
);
