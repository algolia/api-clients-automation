// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { DockerStreamsSyncMode } from './dockerStreamsSyncMode';

export type DockerStreams = {
  /**
   * The name of the stream to fetch the data from (e.g. table name).
   */
  name: string;

  /**
   * The properties of the stream to select (e.g. column).
   */
  properties?: Array<string>;

  syncMode: DockerStreamsSyncMode;
};
