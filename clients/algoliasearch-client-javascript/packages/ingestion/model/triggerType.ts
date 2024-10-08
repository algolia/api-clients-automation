// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

/**
 * Task trigger, describing when a task should run.  - `onDemand`.   Manually trigger the task with the `/run` endpoint.  - `schedule`.   Regularly trigger the task on a `cron` schedule.  - `subscription`.   Trigger the task after an event is received, such as, a webhook.  - `streaming`.   Run the task continuously.
 */
export type TriggerType = 'onDemand' | 'schedule' | 'subscription' | 'streaming';
