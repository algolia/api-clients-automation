<?php

$env = require_once '../loadEnv.php';

use Algolia\AlgoliaSearch\Api\AgentStudioClient;

$client = AgentStudioClient::create(
    $env['ALGOLIA_APPLICATION_ID'],
    $env['ALGOLIA_ADMIN_KEY']
);

$response = $client->listAgents();

echo 'List of agents:' . PHP_EOL;
foreach ($response['agents'] as $agent) {
    echo '- ' . $agent['name'] . ' (ID: ' . $agent['id'] . ')' . PHP_EOL;
}
