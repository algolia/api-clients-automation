<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

/**
 * Mode Class Doc Comment.
 *
 * @category Class
 * @description Search mode the index will use to query for results.
 */
class Mode
{
    /**
     * Possible values of this enum.
     */
    public const NEURAL_SEARCH = 'neuralSearch';

    public const KEYWORD_SEARCH = 'keywordSearch';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::NEURAL_SEARCH,
            self::KEYWORD_SEARCH,
        ];
    }
}
