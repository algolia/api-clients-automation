<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

$labels = []; // A list of labels
$reduceLabelsToFilters = function (array $labels): array {
    // Implement your logic here
    return [];
};

try {
    $client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

    $optionalFilters = $reduceLabelsToFilters($labels);
    $searchParams = [
        'query' => '<YOUR_SEARCH_QUERY>',
        'optionalFilters' => $optionalFilters,
    ];

    $client->searchSingleIndex(
        '<YOUR_INDEX_NAME>',
        $searchParams,
    );
} catch (Exception $e) {
    echo $e->getMessage().PHP_EOL;
}
