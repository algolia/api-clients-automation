<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Configuration\TransformationOptions;

// Set transformationOptions with your transformation region to use the `WithTransformation` helper methods.
// Replace 'us' with 'eu' if your Algolia application uses the Europe analytics region.
$config = SearchConfig::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');
$config->setTransformationOptions(new TransformationOptions('us'));
$client = SearchClient::createWithConfig($config);

// Save records, transforming them through the Push connector
$client->saveObjectsWithTransformation(
    '<YOUR_INDEX_NAME>',
    [
        ['objectID' => '1',
            'name' => 'Adam',
        ],

        ['objectID' => '2',
            'name' => 'Benoit',
        ],
    ],
    true,
);

echo 'Done!';
