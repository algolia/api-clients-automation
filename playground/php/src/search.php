<?php

require 'vendor/autoload.php';

use Algolia\AlgoliaSearch\Api\SearchApi;
use Algolia\AlgoliaSearch\Configuration;

$config = new Configuration(getenv('ALGOLIA_APPLICATION_ID_1'), getenv('ALGOLIA_ADMIN_KEY_1'));
$client = new SearchApi($config);

var_dump($client->listIndices());
