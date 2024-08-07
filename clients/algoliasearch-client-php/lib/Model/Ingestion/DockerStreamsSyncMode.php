<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

/**
 * DockerStreamsSyncMode Class Doc Comment.
 *
 * @category Class
 *
 * @description The strategy to use to fetch the data.
 */
class DockerStreamsSyncMode
{
    /**
     * Possible values of this enum.
     */
    public const INCREMENTAL = 'incremental';

    public const FULL_TABLE = 'fullTable';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::INCREMENTAL,
            self::FULL_TABLE,
        ];
    }
}
