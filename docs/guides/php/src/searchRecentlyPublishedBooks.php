<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\SearchParamsObject;

try {
    $client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

    $dateTimestamp = strtotime('-1 years');
    $searchParams = (new SearchParamsObject())
        ->setQuery('<YOUR_SEARCH_QUERY>')
        ->setFilters('date_timestamp > '.$dateTimestamp)
    ;

    $client->searchSingleIndex(
        '<YOUR_INDEX_NAME>',
        $searchParams,
    );
} catch (Exception $e) {
    echo $e->getMessage().PHP_EOL;
}
