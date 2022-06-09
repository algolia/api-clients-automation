<?php

namespace Algolia\AlgoliaSearch\Configuration;

use Algolia\AlgoliaSearch\Exceptions\AlgoliaException;

abstract class ConfigWithRegion extends Configuration
{
    public static function create(
        $appId,
        $apiKey,
        $region = null,
        $allowedRegions = null
    ) {
        if (
            $region !== null &&
            $allowedRegions !== null &&
            !in_array($region, $allowedRegions, true)
        ) {
            throw new AlgoliaException('Specified region is not allowed.');
        }

        $config = [
            'appId' => $appId,
            'apiKey' => $apiKey,
            'region' => $region,
        ];

        return new static($config);
    }

    public function getRegion()
    {
        return $this->config['region'];
    }
}
