// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { ActionType } from './actionType';
import type { TaskInput } from './taskInput';
import type { Trigger } from './trigger';

/**
 * The V1 task object, please use methods and types that don\'t contain the V1 suffix.
 */
export type TaskV1 = {
  /**
   * Universally unique identifier (UUID) of a task.
   */
  taskID: string;

  /**
   * Universally uniqud identifier (UUID) of a source.
   */
  sourceID: string;

  /**
   * Universally unique identifier (UUID) of a destination resource.
   */
  destinationID: string;

  trigger: Trigger;

  input?: TaskInput;

  /**
   * Whether the task is enabled.
   */
  enabled: boolean;

  /**
   * Maximum accepted percentage of failures for a task run to finish successfully.
   */
  failureThreshold?: number;

  action: ActionType;

  /**
   * Date of the last cursor in RFC 3339 format.
   */
  cursor?: string;

  /**
   * Date of creation in RFC 3339 format.
   */
  createdAt: string;

  /**
   * Date of last update in RFC 3339 format.
   */
  updatedAt?: string;
};
