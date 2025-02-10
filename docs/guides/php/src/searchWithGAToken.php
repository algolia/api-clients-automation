<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

$getGoogleAnalyticsUserIdFromBrowserCookie = function (string $cookieName): string {
    // Implement your logic here
    return '';
};

try {
    $client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

    $userToken = $getGoogleAnalyticsUserIdFromBrowserCookie('_ga');
    $searchParams = [
        'query' => '<YOUR_SEARCH_QUERY>',
        'userToken' => $userToken,
    ];

    $client->searchSingleIndex(
        '<YOUR_INDEX_NAME>',
        $searchParams,
    );

    /** @var null|string $loggedInUser */
    $loggedInUser = null;

    $searchParams['userToken'] = $loggedInUser ?? $userToken;

    $client->searchSingleIndex(
        '<YOUR_INDEX_NAME>',
        $searchParams,
    );
} catch (Exception $e) {
    echo $e->getMessage().PHP_EOL;
}
