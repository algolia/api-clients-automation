<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

/**
 * DockerRegistry Class Doc Comment.
 *
 * @category Class
 * @description Container registry name from where to pull the image.
 */
class DockerRegistry
{
    /**
     * Possible values of this enum.
     */
    public const DOCKERHUB = 'dockerhub';

    public const GHCR = 'ghcr';

    /**
     * Gets allowable values of the enum.
     *
     * @return string[]
     */
    public static function getAllowableEnumValues()
    {
        return [
            self::DOCKERHUB,
            self::GHCR,
        ];
    }
}
