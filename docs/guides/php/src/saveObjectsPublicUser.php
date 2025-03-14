<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

$playlists = [/* Your records */];

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

$client->saveObjects(
    '<YOUR_INDEX_NAME>',
    $playlists,
    false,
    1000,
    [
        'headers' => [
            'X-Algolia-User-ID' => '*',
        ],
    ]
);
