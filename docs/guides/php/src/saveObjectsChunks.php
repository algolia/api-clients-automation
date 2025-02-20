<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

$path = dirname(__FILE__).DIRECTORY_SEPARATOR.'actors.json';

if (!file_exists($path)) {
    throw new Exception("File not found: {$path}");
}

$data = file_get_contents($path);

if (false === $data) {
    throw new Exception("Failed to read file: {$path}");
}

$records = json_decode($data, true);

if (JSON_ERROR_NONE !== json_last_error()) {
    throw new Exception('JSON decode error: '.json_last_error_msg());
}

$chunkSize = 10000;

for ($beginIndex = 0; $beginIndex < count($records); $beginIndex += $chunkSize) {
    $chunk = array_slice($records, $beginIndex, $chunkSize);

    try {
        $client->saveObjects(
            '<YOUR_INDEX_NAME>',
            $chunk,
        );
    } catch (Exception $e) {
        echo 'Error: '.$e->getMessage()."\n";
    }
}
