// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { Pagination } from './pagination';
import type { TaskV1 } from './taskV1';

/**
 * Configured tasks and pagination information.
 */
export type ListTasksResponseV1 = {
  tasks: Array<TaskV1>;

  pagination: Pagination;
};
