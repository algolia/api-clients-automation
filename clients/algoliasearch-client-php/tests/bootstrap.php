<?php

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Http\CurlHttpClient;

/*
 * Pins the transport the test suite runs on, so installing guzzlehttp/guzzle to exercise
 * GuzzleHttpClient does not silently switch every other test onto the Guzzle transport.
 */
Algolia::setHttpClient(new CurlHttpClient());
