<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

$config = SearchConfig::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');
$config->setDefaultHeaders(['X-Algolia-UserToken' => 'test-user-123']);
$client = SearchClient::createWithConfig($config);
echo $client->getClientConfig()->getDefaultHeaders();
