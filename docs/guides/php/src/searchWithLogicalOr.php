<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\OptionalWords;
use Algolia\AlgoliaSearch\Model\Search\SearchParamsObject;

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

$query = 'the query';

$optionalWords = new OptionalWords();
$optionalWords[] = $query;

$searchParams = (new SearchParamsObject())
    ->setQuery($query)
    ->setOptionalWords($optionalWords)
;

$client->searchSingleIndex(
    '<YOUR_INDEX_NAME>',
    $searchParams,
);
