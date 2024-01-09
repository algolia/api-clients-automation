<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

/**
 * DestinationSortKeys Class Doc Comment.
 *
 * @category Class
 *
 * @description Used to sort the Destination list endpoint.
 */
class DestinationSortKeys
{
    /**
     * Possible values of this enum.
     */
    public const NAME = 'name';

    public const TYPE = 'type';

    public const UPDATED_AT = 'updatedAt';

    public const CREATED_AT = 'createdAt';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::NAME,
            self::TYPE,
            self::UPDATED_AT,
            self::CREATED_AT,
        ];
    }
}
