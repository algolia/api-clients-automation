<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\SearchParamsObject;

$getPlatformTag = function (): string {
    // Implement your logic here
    return '';
};

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

// get the buyer account information
$platformTag = $getPlatformTag();
$searchParams = (new SearchParamsObject())
    ->setQuery('<YOUR_SEARCH_QUERY>')
    ->setRuleContexts([$platformTag])
;

$client->searchSingleIndex(
    '<YOUR_INDEX_NAME>',
    $searchParams,
);
