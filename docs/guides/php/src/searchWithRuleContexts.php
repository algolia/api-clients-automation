<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

$getPlatformTag = function (): string {
    // Implement your logic here
    return '';
};

try {
    $client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

    // get the buyer account information
    $platformTag = $getPlatformTag();
    $searchParams = [
        'query' => '<YOUR_SEARCH_QUERY>',
        'ruleContexts' => [$platformTag],
    ];

    $client->searchSingleIndex(
        '<YOUR_INDEX_NAME>',
        $searchParams,
    );
} catch (Exception $e) {
    echo $e->getMessage().PHP_EOL;
}
