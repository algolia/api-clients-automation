<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

/**
 * OnDemandTriggerType Class Doc Comment.
 *
 * @category Class
 * @description A task which is manually executed via the run task endpoint.
 */
class OnDemandTriggerType
{
    /**
     * Possible values of this enum.
     */
    public const ON_DEMAND = 'onDemand';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::ON_DEMAND,
        ];
    }
}
