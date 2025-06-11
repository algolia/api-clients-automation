<?php

require '../../../clients/algoliasearch-client-php/vendor/autoload.php';

// Gets the vars from local environment
$dotenv = Dotenv\Dotenv::createImmutable('../..');
$dotenv->load();
$env = $_ENV;

return $env;
