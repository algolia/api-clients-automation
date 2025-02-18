<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

try {
    $client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

    $results = $client->browseObjects('<YOUR_INDEX_NAME>');

    $records = [];
    foreach ($results as $hit) {
        $records[] = [
            'twitterHandle' => $hit['twitterHandle'],
            'nbFollowers' => $hit['nbFollowers'],
            'isPopular' => $hit['nbFollowers'] > 1000000,
        ];
    }

    $client->saveObjects(
        '<YOUR_INDEX_NAME>',
        $records,
    );
} catch (Exception $e) {
    echo $e->getMessage().PHP_EOL;
}
