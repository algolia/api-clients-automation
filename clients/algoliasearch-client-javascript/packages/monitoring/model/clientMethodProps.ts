// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { Metric } from './metric';
import type { Period } from './period';

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
  parameters?: Record<string, any>;
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
  parameters?: Record<string, any>;
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
  parameters?: Record<string, any>;
  /**
   * Parameters to send with the custom request.
   */
  body?: Record<string, any>;
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
  parameters?: Record<string, any>;
  /**
   * Parameters to send with the custom request.
   */
  body?: Record<string, any>;
};

/**
 * Properties for the `getClusterIncidents` method.
 */
export type GetClusterIncidentsProps = {
  /**
   * Subset of clusters, separated by comma.
   */
  clusters: string;
};

/**
 * Properties for the `getClusterStatus` method.
 */
export type GetClusterStatusProps = {
  /**
   * Subset of clusters, separated by comma.
   */
  clusters: string;
};

/**
 * Properties for the `getIndexingTime` method.
 */
export type GetIndexingTimeProps = {
  /**
   * Subset of clusters, separated by comma.
   */
  clusters: string;
};

/**
 * Properties for the `getLatency` method.
 */
export type GetLatencyProps = {
  /**
   * Subset of clusters, separated by comma.
   */
  clusters: string;
};

/**
 * Properties for the `getMetrics` method.
 */
export type GetMetricsProps = {
  /**
   * Metric to report.  For more information about the individual metrics, see the response. To include all metrics, use `*` as the parameter.
   */
  metric: Metric;
  /**
   * Period over which to aggregate the metrics:  - `minute`. Aggregate the last minute. 1 data point per 10 seconds. - `hour`. Aggregate the last hour. 1 data point per minute. - `day`. Aggregate the last day. 1 data point per 10 minutes. - `week`. Aggregate the last week. 1 data point per hour. - `month`. Aggregate the last month. 1 data point per day.
   */
  period: Period;
};

/**
 * Properties for the `getReachability` method.
 */
export type GetReachabilityProps = {
  /**
   * Subset of clusters, separated by comma.
   */
  clusters: string;
};
