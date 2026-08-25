<?php

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Http\CurlHttpClient;

Algolia::setHttpClient(new CurlHttpClient());
