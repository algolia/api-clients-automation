<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\SearchParamsObject;

$getGoogleAnalyticsUserIdFromBrowserCookie = function (string $cookieName): string {
    // Implement your logic here
    return '';
};

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

$userToken = $getGoogleAnalyticsUserIdFromBrowserCookie('_ga');
$searchParams = (new SearchParamsObject())
    ->setQuery('<YOUR_SEARCH_QUERY>')
    ->setUserToken($userToken)
;

$client->searchSingleIndex(
    '<YOUR_INDEX_NAME>',
    $searchParams,
);

/** @var null|string $loggedInUser */
$loggedInUser = null;

$searchParams->setUserToken($loggedInUser ?? $userToken);

$client->searchSingleIndex(
    '<YOUR_INDEX_NAME>',
    $searchParams,
);
