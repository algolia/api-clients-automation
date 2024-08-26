// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { DockerRegistry } from './dockerRegistry';

export type SourceUpdateDocker = {
  registry?: DockerRegistry;

  /**
   * Docker image name.
   */
  image?: string;

  /**
   * Docker image version.
   */
  version?: string;

  /**
   * Configuration of the spec.
   */
  configuration: Record<string, unknown>;
};
