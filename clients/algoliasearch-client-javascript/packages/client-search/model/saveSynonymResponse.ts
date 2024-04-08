// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type SaveSynonymResponse = {
  /**
   * Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task\'s progress with the [`task` operation](#tag/Indices/operation/getTask) and this `taskID`.
   */
  taskID: number;

  /**
   * Date and time when the object was updated, in RFC 3339 format.
   */
  updatedAt: string;

  /**
   * Unique identifier of a synonym object.
   */
  id: string;
};
