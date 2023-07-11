<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Monitoring;

/**
 * Metric Class Doc Comment
 *
 * @category Class
 * @package Algolia\AlgoliaSearch
 */
class Metric
{
    /**
     * Possible values of this enum
     */
    const AVG_BUILD_TIME = 'avg_build_time';

    const SSD_USAGE = 'ssd_usage';

    const RAM_SEARCH_USAGE = 'ram_search_usage';

    const RAM_INDEXING_USAGE = 'ram_indexing_usage';

    const CPU_USAGE = 'cpu_usage';

    const STAR = '*';

    /**
     * Gets allowable values of the enum
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::AVG_BUILD_TIME,
            self::SSD_USAGE,
            self::RAM_SEARCH_USAGE,
            self::RAM_INDEXING_USAGE,
            self::CPU_USAGE,
            self::STAR,
        ];
    }
}
