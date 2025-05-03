<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\SearchParamsObject;

$getBuyerAccountId = function (): string {
    // Implement your logic here
    return '';
};

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

// get the buyer account information
$buyer = $getBuyerAccountId();
$searchParams = (new SearchParamsObject())
    ->setQuery('<YOUR_SEARCH_QUERY>')
    ->setRuleContexts([$buyer])
;

$client->searchSingleIndex(
    '<YOUR_INDEX_NAME>',
    $searchParams,
);
