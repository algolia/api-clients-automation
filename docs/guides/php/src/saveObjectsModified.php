<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

try {
    $client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

    $path = dirname(__FILE__).DIRECTORY_SEPARATOR.'products.json';

    if (!file_exists($path)) {
        throw new Exception("File not found: {$path}");
    }

    $data = file_get_contents($path);

    if (false === $data) {
        throw new Exception("Failed to read file: {$path}");
    }

    $products = json_decode($data, true);

    if (JSON_ERROR_NONE !== json_last_error()) {
        throw new Exception('JSON decode error: '.json_last_error_msg());
    }

    $records = array_map(function ($product) {
        $reference = $product['product_reference'];
        $suffixes = [];

        while (strlen($reference) > 1) {
            $reference = substr($reference, 1);
            $suffixes[] = $reference;
        }

        $product['product_reference_suffixes'] = $suffixes;

        return $product;
    }, $products);

    $client->saveObjects(
        '<YOUR_INDEX_NAME>',
        $records,
    );
} catch (Exception $e) {
    echo $e->getMessage().PHP_EOL;
}
