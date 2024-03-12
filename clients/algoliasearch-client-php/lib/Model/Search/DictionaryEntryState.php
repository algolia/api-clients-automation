<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

/**
 * DictionaryEntryState Class Doc Comment.
 *
 * @category Class
 * @description Whether a dictionary entry is active.
 */
class DictionaryEntryState
{
    /**
     * Possible values of this enum.
     */
    public const ENABLED = 'enabled';

    public const DISABLED = 'disabled';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::ENABLED,
            self::DISABLED,
        ];
    }
}
