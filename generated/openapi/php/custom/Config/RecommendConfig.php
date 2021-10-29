<?php

namespace NewApiClient\Client\Config;

use OpenAPI\Client\Configuration;

class RecommendConfig extends Configuration
{
    private $appId;

    private $algoliaApiKey;

    public function setAppId($appId = '')
    {
        $this->appId = $appId;
    }

    public function getAppId()
    {
        return $this->appId;
    }

    public function setAlgoliaApiKey($algoliaApiKey = '')
    {
        $this->algoliaApiKey = $algoliaApiKey;
    }

    public function getAlgoliaApiKey()
    {
        return $this->algoliaApiKey;
    }

}