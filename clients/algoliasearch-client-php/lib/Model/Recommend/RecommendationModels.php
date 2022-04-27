<?php

namespace Algolia\AlgoliaSearch\Model\Recommend;

use Algolia\AlgoliaSearch\ObjectSerializer;

/**
 * RecommendationModels Class Doc Comment
 *
 * @category Class
 * @description The recommendation model to use.
 * @package Algolia\AlgoliaSearch
 */
class RecommendationModels
{
    /**
     * Possible values of this enum
     */
    public const RELATED_PRODUCTS = 'related-products';

    public const BOUGHT_TOGETHER = 'bought-together';

    /**
     * Gets allowable values of the enum
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [self::RELATED_PRODUCTS, self::BOUGHT_TOGETHER];
    }
}
