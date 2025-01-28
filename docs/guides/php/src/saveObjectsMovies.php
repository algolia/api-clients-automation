<?php
require(__DIR__."/vendor/autoload.php");
use Algolia\AlgoliaSearch\Api\SearchClient;

// Fetch sample dataset
$url = "https://dashboard.algolia.com/api/1/sample_datasets?type=movie";
$response = file_get_contents($url);
$movies = json_decode($response, true);

// Connect and authenticate with your Algolia app
$client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

// Save records in Algolia index
$client->saveObjects(
  "<YOUR_INDEX_NAME>",

  movies
)

print('Done!');