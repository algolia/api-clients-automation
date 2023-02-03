// This file is generated, manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.

import type { ScheduleTriggerType } from './scheduleTriggerType';

/**
 * The trigger input for a task of type \'schedule\'.
 */
export type ScheduleTriggerInput = {
  type: ScheduleTriggerType;

  /**
   * A cron expression that represent at which regularity the task should run.
   */
  cron: string;
};
