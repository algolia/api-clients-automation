<?php

require '../vendor/autoload.php';

use Algolia\AlgoliaSearch\Api\SearchApi;

$client = SearchApi::create(getenv('ALGOLIA_APPLICATION_ID_1'), getenv('ALGOLIA_ADMIN_KEY_1'));

var_dump($client->getDictionaryLanguages());
