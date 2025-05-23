<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\IngestionClient;

$records = json_decode(file_get_contents('records.json') ?: '[]', true);

// use the region matching your applicationID
$client = IngestionClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

// setting `watch` to `true` will make the call synchronous
$resp = $client->pushTask(
    'YOUR_TASK_ID',
    ['action' => 'addObject',
        'records' => $records,
    ],
    true,
);

echo $resp;
