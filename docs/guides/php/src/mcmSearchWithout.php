<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\SearchParamsObject;

$getAppIDFor = function ($user) {
    return ''; // Implement your own logic here
};

$getIndexingApiKeyFor = function ($user) {
    return ''; // Implement your own logic here
};

// Fetch from your own data storage and with your own code
// the associated application ID and API key for this user
$appID = $getAppIDFor('user42');
$apiKey = $getIndexingApiKeyFor('user42');

$client = SearchClient::create($appID, $apiKey);

$searchParams = (new SearchParamsObject())
    ->setQuery('<YOUR_SEARCH_QUERY>')
    ->setFacetFilters(['user:user42', 'user:public'])
;

$client->searchSingleIndex(
    '<YOUR_INDEX_NAME>',
    $searchParams,
);
