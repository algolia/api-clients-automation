<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

/**
 * Anchoring Class Doc Comment.
 *
 * @category Class
 * @description Which part of the search query the pattern should match:  - &#x60;startsWith&#x60;. The pattern must match the begginning of the query. - &#x60;endsWith&#x60;. The pattern must match the end of the query. - &#x60;is&#x60;. The pattern must match the query exactly. - &#x60;contains&#x60;. The pattern must match anywhere in the query.  Empty queries are only allowed as pattern with &#x60;anchoring: is&#x60;.
 */
class Anchoring
{
    /**
     * Possible values of this enum.
     */
    public const IS = 'is';

    public const STARTS_WITH = 'startsWith';

    public const ENDS_WITH = 'endsWith';

    public const CONTAINS = 'contains';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::IS,
            self::STARTS_WITH,
            self::ENDS_WITH,
            self::CONTAINS,
        ];
    }
}
