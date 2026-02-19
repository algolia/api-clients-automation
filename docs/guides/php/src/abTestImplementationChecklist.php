<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\SearchParamsObject;

$getUserToken = function (): string {
    // Implement your logic here
    return '';
};

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

// Set the searchParams and get the current user token
$searchParams = (new SearchParamsObject())
    ->setQuery('User search query')
    ->setEnableABTest(true)
;

$userToken = $getUserToken();

// Is the user token anonymous?
if (null === $userToken || '' === $userToken || 'YOUR_ANONYMOUS_USER_TOKEN' === $userToken) {
    // Disable A/B testing for this request
    $searchParams->setEnableABTest(false);
} else {
    // Set the user token to the current user token
    $searchParams->setUserToken($userToken);
}

try {
    // Perform the searchSingleIndex
    $result = $client->searchSingleIndex(
        '<YOUR_INDEX_NAME>',
        $searchParams,
    );
    // SearchSingleIndex results
    var_dump($result);
} catch (Exception $err) {
    // SearchSingleIndex errors
    error_log($err->getMessage());
}
