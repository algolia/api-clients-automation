<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

$playlists = [/* Your records */];

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

foreach ($playlists as $playlist) {
    try {
        $playlistUserID = $playlist['userID'];
        $client->saveObjects(
            '<YOUR_INDEX_NAME>',
            $playlists,
            false,
            1000,
            [
                'headers' => [
                    'X-Algolia-User-ID' => $playlistUserID,
                ],
            ]
        );
    } catch (Exception $e) {
        echo $e->getMessage().PHP_EOL;
    }
}
