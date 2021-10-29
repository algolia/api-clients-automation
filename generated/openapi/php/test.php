<?php

require 'vendor/autoload.php';

use NewApiClient\Client\RecommendClient as NewRecommendClient;
use NewApiClient\Client\Config\RecommendConfig;
use OpenAPI\Client\Model\InlineObject;

$config = new RecommendConfig();

$appId = getenv('ALGOLIA_APPLICATION_ID_1');
$apiKey = getenv('ALGOLIA_ADMIN_KEY_1');

$config->setHost("https://{$appId}-1.algolianet.com");
$config->setAlgoliaApiKey($apiKey);
$config->setAppId($appId);

$client = new NewRecommendClient(null, $config);

$object = new InlineObject([
    'index_name' => 'recommend_test',
    'object_id' => 'B018APC4LE',
    'model' => 'bought-together',
]);

try {
    $client->getRecommendations([$object]);
} catch(\OpenAPI\Client\ApiException $e) {
    echo "API contacted!\n";
}


// Open API
//"[{"indexName":"products","model":"bought-together","objectID":"B018APC4LE","threshold":0,"maxRecommendations":0}]"
// Current Api Client
// '{"requests":[{"indexName":"products","objectID":"B018APC4LE","model":"bought-together","threshold":0}]}'