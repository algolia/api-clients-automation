// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { EventStatus } from './eventStatus';
import type { EventType } from './eventType';

/**
 * An event describe a step of the task execution flow..
 */
export type Event = {
  /**
   * Universally unique identifier (UUID) of an event.
   */
  eventID: string;

  /**
   * Universally unique identifier (UUID) of a task run.
   */
  runID: string;

  status: EventStatus | null;

  type: EventType;

  /**
   * The extracted record batch size.
   */
  batchSize: number;

  data?: { [key: string]: any } | null | undefined;

  /**
   * Date of publish RFC 3339 format.
   */
  publishedAt: string;
};
