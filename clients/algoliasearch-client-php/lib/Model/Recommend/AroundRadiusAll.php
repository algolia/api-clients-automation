<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Recommend;

/**
 * AroundRadiusAll Class Doc Comment.
 *
 * @category Class
 * @description Return all records with a valid &#x60;_geoloc&#x60; attribute. Don&#39;t filter by distance.
 */
class AroundRadiusAll
{
    /**
     * Possible values of this enum.
     */
    public const ALL = 'all';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::ALL,
        ];
    }
}
