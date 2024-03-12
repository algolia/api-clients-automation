<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

/**
 * MatchLevel Class Doc Comment.
 *
 * @category Class
 * @description Whether the whole query string matches or only a part.
 */
class MatchLevel
{
    /**
     * Possible values of this enum.
     */
    public const NONE = 'none';

    public const PARTIAL = 'partial';

    public const FULL = 'full';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::NONE,
            self::PARTIAL,
            self::FULL,
        ];
    }
}
