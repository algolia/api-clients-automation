<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

$getAllAppIDConfigurations = function () {
    return [/* A list of your MCM AppID/ApiKey pairs */];
};

$playlists = [/* Your records */];

// Fetch from your own data storage and with your own code
// the list of application IDs and API keys to target each cluster
$configurations = $getAllAppIDConfigurations();

// Send the records to each cluster
foreach ($configurations as [$appID, $apiKey]) {
    try {
        $client = SearchClient::create($appID, $apiKey);

        $client->saveObjects(
            '<YOUR_INDEX_NAME>',
            $playlists,
        );
    } catch (Exception $e) {
        echo $e->getMessage().PHP_EOL;
    }
}
