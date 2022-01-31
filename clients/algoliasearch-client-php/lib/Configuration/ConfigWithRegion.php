<?php

namespace Algolia\AlgoliaSearch\Configuration;

use Algolia\AlgoliaSearch\Exceptions\AlgoliaException;

abstract class ConfigWithRegion extends Configuration
{
    protected static $allowedRegions = [
        'us',
        'de',
    ];

    public static function create($appId = null, $apiKey = null, $region = null)
    {
        if ($region !== null && !in_array($region, self::$allowedRegions, true)) {
            throw new AlgoliaException('Specified region is not allowed.');
        }

        $config = [
            'appId' => null !== $appId ? $appId : getenv('ALGOLIA_APP_ID'),
            'apiKey' => null !== $apiKey ? $apiKey : getenv('ALGOLIA_API_KEY'),
            'region' => null !== $region ? $region : 'us',
        ];

        return new static($config);
    }

    public function setRegion($region)
    {
        if (!in_array($region, self::$allowedRegions, true)) {
            throw new AlgoliaException('Specified region is not allowed.');
        }

        $this->config['region'] = $region;

        return $this;
    }

    public function getRegion()
    {
        return $this->config['region'];
    }
}
