<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Recommend;

/**
 * TaskStatus Class Doc Comment.
 *
 * @category Class
 * @description Task status, &#x60;published&#x60; if the task is completed, &#x60;notPublished&#x60; otherwise.
 */
class TaskStatus
{
    /**
     * Possible values of this enum.
     */
    public const PUBLISHED = 'published';

    public const NOT_PUBLISHED = 'notPublished';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::PUBLISHED,
            self::NOT_PUBLISHED,
        ];
    }
}
