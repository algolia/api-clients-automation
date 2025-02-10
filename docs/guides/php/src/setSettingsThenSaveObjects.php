<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

$playlists = [/* Your records */];

$getAppIDFor = function ($user) {
    return ''; // Implement your own logic here
};

$getIndexingApiKeyFor = function ($user) {
    return ''; // Implement your own logic here
};

try {
    $client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

    foreach ($playlists as $playlist) {
        // Fetch from your own data storage and with your own code
        // the associated application ID and API key for this user
        $appID = $getAppIDFor($playlist['user']);
        $apiKey = $getIndexingApiKeyFor($playlist['user']);

        $client = SearchClient::create($appID, $apiKey);
        $settings = ['attributesForFaceting' => ['filterOnly(user)']];
        $client->setSettings(
            '<YOUR_INDEX_NAME>',
            $settings,
        );

        $client->saveObjects(
            '<YOUR_INDEX_NAME>',
            $playlists,
        );
    }
} catch (Exception $e) {
    echo $e->getMessage().PHP_EOL;
}
