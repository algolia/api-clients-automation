// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { ActionType } from '../model/actionType';

import type { AuthenticationSortKeys } from '../model/authenticationSortKeys';
import type { AuthenticationType } from '../model/authenticationType';
import type { AuthenticationUpdate } from '../model/authenticationUpdate';

import type { DestinationSortKeys } from '../model/destinationSortKeys';
import type { DestinationType } from '../model/destinationType';
import type { DestinationUpdate } from '../model/destinationUpdate';

import type { EventSortKeys } from '../model/eventSortKeys';
import type { EventStatus } from '../model/eventStatus';
import type { EventType } from '../model/eventType';

import type { OrderKeys } from '../model/orderKeys';
import type { PlatformWithNone } from '../model/platformWithNone';
import type { PushTaskPayload } from '../model/pushTaskPayload';

import type { RunSortKeys } from '../model/runSortKeys';
import type { RunSourcePayload } from '../model/runSourcePayload';

import type { RunStatus } from '../model/runStatus';
import type { RunType } from '../model/runType';

import type { SourceSortKeys } from '../model/sourceSortKeys';
import type { SourceType } from '../model/sourceType';
import type { SourceUpdate } from '../model/sourceUpdate';

import type { TaskSortKeys } from '../model/taskSortKeys';
import type { TaskUpdate } from '../model/taskUpdate';

import type { TaskUpdateV1 } from '../model/taskUpdateV1';

import type { TransformationCreate } from '../model/transformationCreate';

import type { TransformationSortKeys } from '../model/transformationSortKeys';
import type { TransformationTry } from '../model/transformationTry';

import type { TriggerType } from '../model/triggerType';

/**
 * Properties for the `customDelete` method.
 */
export type CustomDeleteProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: { [key: string]: any };
};

/**
 * Properties for the `customGet` method.
 */
export type CustomGetProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: { [key: string]: any };
};

/**
 * Properties for the `customPost` method.
 */
export type CustomPostProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: { [key: string]: any };
  /**
   * Parameters to send with the custom request.
   */
  body?: Record<string, unknown>;
};

/**
 * Properties for the `customPut` method.
 */
export type CustomPutProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: { [key: string]: any };
  /**
   * Parameters to send with the custom request.
   */
  body?: Record<string, unknown>;
};

/**
 * Properties for the `deleteAuthentication` method.
 */
export type DeleteAuthenticationProps = {
  /**
   * Unique identifier of an authentication resource.
   */
  authenticationID: string;
};

/**
 * Properties for the `deleteDestination` method.
 */
export type DeleteDestinationProps = {
  /**
   * Unique identifier of a destination.
   */
  destinationID: string;
};

/**
 * Properties for the `deleteSource` method.
 */
export type DeleteSourceProps = {
  /**
   * Unique identifier of a source.
   */
  sourceID: string;
};

/**
 * Properties for the `deleteTask` method.
 */
export type DeleteTaskProps = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
};

/**
 * Properties for the `deleteTaskV1` method.
 */
export type DeleteTaskV1Props = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
};

/**
 * Properties for the `deleteTransformation` method.
 */
export type DeleteTransformationProps = {
  /**
   * Unique identifier of a transformation.
   */
  transformationID: string;
};

/**
 * Properties for the `disableTask` method.
 */
export type DisableTaskProps = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
};

/**
 * Properties for the `disableTaskV1` method.
 */
export type DisableTaskV1Props = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
};

/**
 * Properties for the `enableTask` method.
 */
export type EnableTaskProps = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
};

/**
 * Properties for the `enableTaskV1` method.
 */
export type EnableTaskV1Props = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
};

/**
 * Properties for the `getAuthentication` method.
 */
export type GetAuthenticationProps = {
  /**
   * Unique identifier of an authentication resource.
   */
  authenticationID: string;
};

/**
 * Properties for the `getDestination` method.
 */
export type GetDestinationProps = {
  /**
   * Unique identifier of a destination.
   */
  destinationID: string;
};

/**
 * Properties for the `getEvent` method.
 */
export type GetEventProps = {
  /**
   * Unique identifier of a task run.
   */
  runID: string;
  /**
   * Unique identifier of an event.
   */
  eventID: string;
};

/**
 * Properties for the `getRun` method.
 */
export type GetRunProps = {
  /**
   * Unique identifier of a task run.
   */
  runID: string;
};

/**
 * Properties for the `getSource` method.
 */
export type GetSourceProps = {
  /**
   * Unique identifier of a source.
   */
  sourceID: string;
};

/**
 * Properties for the `getTask` method.
 */
export type GetTaskProps = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
};

/**
 * Properties for the `getTaskV1` method.
 */
export type GetTaskV1Props = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
};

/**
 * Properties for the `getTransformation` method.
 */
export type GetTransformationProps = {
  /**
   * Unique identifier of a transformation.
   */
  transformationID: string;
};

/**
 * Properties for the `listAuthentications` method.
 */
export type ListAuthenticationsProps = {
  /**
   * Number of items per page.
   */
  itemsPerPage?: number;
  /**
   * Page number of the paginated API response.
   */
  page?: number;
  /**
   * Type of authentication resource to retrieve.
   */
  type?: Array<AuthenticationType>;
  /**
   * Ecommerce platform for which to retrieve authentications.
   */
  platform?: Array<PlatformWithNone>;
  /**
   * Property by which to sort the list of authentications.
   */
  sort?: AuthenticationSortKeys;
  /**
   * Sort order of the response, ascending or descending.
   */
  order?: OrderKeys;
};

/**
 * Properties for the `listDestinations` method.
 */
export type ListDestinationsProps = {
  /**
   * Number of items per page.
   */
  itemsPerPage?: number;
  /**
   * Page number of the paginated API response.
   */
  page?: number;
  /**
   * Destination type.
   */
  type?: Array<DestinationType>;
  /**
   * Authentication ID used by destinations.
   */
  authenticationID?: Array<string>;
  /**
   * Get the list of destinations used by a transformation.
   */
  transformationID?: string;
  /**
   * Property by which to sort the destinations.
   */
  sort?: DestinationSortKeys;
  /**
   * Sort order of the response, ascending or descending.
   */
  order?: OrderKeys;
};

/**
 * Properties for the `listEvents` method.
 */
export type ListEventsProps = {
  /**
   * Unique identifier of a task run.
   */
  runID: string;
  /**
   * Number of items per page.
   */
  itemsPerPage?: number;
  /**
   * Page number of the paginated API response.
   */
  page?: number;
  /**
   * Event status for filtering the list of task runs.
   */
  status?: Array<EventStatus>;
  /**
   * Event type for filtering the list of task runs.
   */
  type?: Array<EventType>;
  /**
   * Property by which to sort the list of task run events.
   */
  sort?: EventSortKeys;
  /**
   * Sort order of the response, ascending or descending.
   */
  order?: OrderKeys;
  /**
   * Date and time in RFC 3339 format for the earliest events to retrieve. By default, the current time minus three hours is used.
   */
  startDate?: string;
  /**
   * Date and time in RFC 3339 format for the latest events to retrieve. By default, the current time is used.
   */
  endDate?: string;
};

/**
 * Properties for the `listRuns` method.
 */
export type ListRunsProps = {
  /**
   * Number of items per page.
   */
  itemsPerPage?: number;
  /**
   * Page number of the paginated API response.
   */
  page?: number;
  /**
   * Run status for filtering the list of task runs.
   */
  status?: Array<RunStatus>;
  /**
   * Run type for filtering the list of task runs.
   */
  type?: Array<RunType>;
  /**
   * Task ID for filtering the list of task runs.
   */
  taskID?: string;
  /**
   * Property by which to sort the list of task runs.
   */
  sort?: RunSortKeys;
  /**
   * Sort order of the response, ascending or descending.
   */
  order?: OrderKeys;
  /**
   * Date in RFC 3339 format for the earliest run to retrieve. By default, the current day minus seven days is used.
   */
  startDate?: string;
  /**
   * Date in RFC 3339 format for the latest run to retrieve. By default, the current day is used.
   */
  endDate?: string;
};

/**
 * Properties for the `listSources` method.
 */
export type ListSourcesProps = {
  /**
   * Number of items per page.
   */
  itemsPerPage?: number;
  /**
   * Page number of the paginated API response.
   */
  page?: number;
  /**
   * Source type. Some sources require authentication.
   */
  type?: Array<SourceType>;
  /**
   * Authentication IDs of the sources to retrieve. \'none\' returns sources that doesn\'t have an authentication.
   */
  authenticationID?: Array<string>;
  /**
   * Property by which to sort the list of sources.
   */
  sort?: SourceSortKeys;
  /**
   * Sort order of the response, ascending or descending.
   */
  order?: OrderKeys;
};

/**
 * Properties for the `listTasks` method.
 */
export type ListTasksProps = {
  /**
   * Number of items per page.
   */
  itemsPerPage?: number;
  /**
   * Page number of the paginated API response.
   */
  page?: number;
  /**
   * Actions for filtering the list of tasks.
   */
  action?: Array<ActionType>;
  /**
   * Whether to filter the list of tasks by the `enabled` status.
   */
  enabled?: boolean;
  /**
   * Source IDs for filtering the list of tasks.
   */
  sourceID?: Array<string>;
  /**
   * Filters the tasks with the specified source type.
   */
  sourceType?: Array<SourceType>;
  /**
   * Destination IDs for filtering the list of tasks.
   */
  destinationID?: Array<string>;
  /**
   * Type of task trigger for filtering the list of tasks.
   */
  triggerType?: Array<TriggerType>;
  /**
   * Property by which to sort the list of tasks.
   */
  sort?: TaskSortKeys;
  /**
   * Sort order of the response, ascending or descending.
   */
  order?: OrderKeys;
};

/**
 * Properties for the `listTasksV1` method.
 */
export type ListTasksV1Props = {
  /**
   * Number of items per page.
   */
  itemsPerPage?: number;
  /**
   * Page number of the paginated API response.
   */
  page?: number;
  /**
   * Actions for filtering the list of tasks.
   */
  action?: Array<ActionType>;
  /**
   * Whether to filter the list of tasks by the `enabled` status.
   */
  enabled?: boolean;
  /**
   * Source IDs for filtering the list of tasks.
   */
  sourceID?: Array<string>;
  /**
   * Destination IDs for filtering the list of tasks.
   */
  destinationID?: Array<string>;
  /**
   * Type of task trigger for filtering the list of tasks.
   */
  triggerType?: Array<TriggerType>;
  /**
   * Property by which to sort the list of tasks.
   */
  sort?: TaskSortKeys;
  /**
   * Sort order of the response, ascending or descending.
   */
  order?: OrderKeys;
};

/**
 * Properties for the `listTransformations` method.
 */
export type ListTransformationsProps = {
  /**
   * Number of items per page.
   */
  itemsPerPage?: number;
  /**
   * Page number of the paginated API response.
   */
  page?: number;
  /**
   * Property by which to sort the list of transformations.
   */
  sort?: TransformationSortKeys;
  /**
   * Sort order of the response, ascending or descending.
   */
  order?: OrderKeys;
};

/**
 * Properties for the `pushTask` method.
 */
export type PushTaskProps = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
  /**
   * Request body of a Search API `batch` request that will be pushed in the Connectors pipeline.
   */
  pushTaskPayload: PushTaskPayload;
  /**
   * When provided, the push operation will be synchronous and the API will wait for the ingestion to be finished before responding.
   */
  watch?: boolean;
};

/**
 * Properties for the `runSource` method.
 */
export type RunSourceProps = {
  /**
   * Unique identifier of a source.
   */
  sourceID: string;
  /**
   *
   */
  runSourcePayload?: RunSourcePayload;
};

/**
 * Properties for the `runTask` method.
 */
export type RunTaskProps = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
};

/**
 * Properties for the `runTaskV1` method.
 */
export type RunTaskV1Props = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
};

/**
 * Properties for the `triggerDockerSourceDiscover` method.
 */
export type TriggerDockerSourceDiscoverProps = {
  /**
   * Unique identifier of a source.
   */
  sourceID: string;
};

/**
 * Properties for the `tryTransformationBeforeUpdate` method.
 */
export type TryTransformationBeforeUpdateProps = {
  /**
   * Unique identifier of a transformation.
   */
  transformationID: string;
  transformationTry: TransformationTry;
};

/**
 * Properties for the `updateAuthentication` method.
 */
export type UpdateAuthenticationProps = {
  /**
   * Unique identifier of an authentication resource.
   */
  authenticationID: string;
  authenticationUpdate: AuthenticationUpdate;
};

/**
 * Properties for the `updateDestination` method.
 */
export type UpdateDestinationProps = {
  /**
   * Unique identifier of a destination.
   */
  destinationID: string;
  destinationUpdate: DestinationUpdate;
};

/**
 * Properties for the `updateSource` method.
 */
export type UpdateSourceProps = {
  /**
   * Unique identifier of a source.
   */
  sourceID: string;
  sourceUpdate: SourceUpdate;
};

/**
 * Properties for the `updateTask` method.
 */
export type UpdateTaskProps = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
  taskUpdate: TaskUpdate;
};

/**
 * Properties for the `updateTaskV1` method.
 */
export type UpdateTaskV1Props = {
  /**
   * Unique identifier of a task.
   */
  taskID: string;
  taskUpdate: TaskUpdateV1;
};

/**
 * Properties for the `updateTransformation` method.
 */
export type UpdateTransformationProps = {
  /**
   * Unique identifier of a transformation.
   */
  transformationID: string;
  transformationCreate: TransformationCreate;
};

/**
 * Properties for the `validateSourceBeforeUpdate` method.
 */
export type ValidateSourceBeforeUpdateProps = {
  /**
   * Unique identifier of a source.
   */
  sourceID: string;
  sourceUpdate: SourceUpdate;
};
