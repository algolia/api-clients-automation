<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\Action;
use Algolia\AlgoliaSearch\Model\Search\MultipleBatchRequest;

// You need an API key with `deleteIndex`
$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

// List all indices
$indicesResponse = $client->listIndices();
$indices = $indicesResponse['items'];

// Primary indices don't have a `primary` key
$primaryIndices = array_filter($indices, function ($index) {
    return !isset($index['primary']);
});
$replicaIndices = array_filter($indices, function ($index) {
    return isset($index['primary']);
});

// Delete primary indices first
if (!empty($primaryIndices)) {
    $requests = array_map(function ($index) {
        return (new MultipleBatchRequest())
            ->setAction((new Action())::DELETE)
            ->setIndexName($index['name'])
        ;
    }, $primaryIndices);

    $client->multipleBatch(
        ['requests' => $requests,
        ],
    );
    echo "Deleted primary indices.\n";
}

// Now, delete replica indices
if (!empty($replicaIndices)) {
    $requests = array_map(function ($index) {
        return [
            'action' => 'delete',
            'indexName' => $index['name'],
        ];
    }, $replicaIndices);

    $client->multipleBatch(
        ['requests' => $requests,
        ],
    );
    echo "Deleted replica indices.\n";
}
