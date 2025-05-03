<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\SearchParamsObject;

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

/*
'94.228.178.246' should be replaced with your user's IP address.
Depending on your stack there are multiple ways to get this information.
*/
$ip = '94.228.178.246';
$query = 'query';

$searchParams = (new SearchParamsObject())
    ->setQuery($query)
    ->setAnalytics(true)
;

$client->searchSingleIndex(
    '<YOUR_INDEX_NAME>',
    $searchParams,
    [
        'headers' => [
            'X-Forwarded-For' => $ip,
        ],
    ]
);
