<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

/**
 * DictionaryEntryType Class Doc Comment.
 *
 * @category Class
 *
 * @description Whether a dictionary entry is provided by Algolia (standard), or has been added by you (custom).
 */
class DictionaryEntryType
{
    /**
     * Possible values of this enum.
     */
    public const CUSTOM = 'custom';

    public const STANDARD = 'standard';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::CUSTOM,
            self::STANDARD,
        ];
    }
}
