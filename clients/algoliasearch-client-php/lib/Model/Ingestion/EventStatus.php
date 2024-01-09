<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

/**
 * EventStatus Class Doc Comment.
 *
 * @category Class
 */
class EventStatus
{
    /**
     * Possible values of this enum.
     */
    public const CREATED = 'created';

    public const STARTED = 'started';

    public const RETRIED = 'retried';

    public const FAILED = 'failed';

    public const SUCCEEDED = 'succeeded';

    public const CRITICAL = 'critical';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::CREATED,
            self::STARTED,
            self::RETRIED,
            self::FAILED,
            self::SUCCEEDED,
            self::CRITICAL,
        ];
    }
}
