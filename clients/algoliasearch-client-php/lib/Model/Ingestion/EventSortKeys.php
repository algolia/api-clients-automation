<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

/**
 * EventSortKeys Class Doc Comment.
 *
 * @category Class
 *
 * @description Used to sort the Event list endpoint.
 */
class EventSortKeys
{
    /**
     * Possible values of this enum.
     */
    public const STATUS = 'status';

    public const TYPE = 'type';

    public const PUBLISHED_AT = 'publishedAt';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::STATUS,
            self::TYPE,
            self::PUBLISHED_AT,
        ];
    }
}
