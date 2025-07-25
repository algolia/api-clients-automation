// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { CompositionRuleConsequence } from './compositionRuleConsequence';
import type { Condition } from './condition';
import type { TimeRange } from './timeRange';

export type CompositionRule = {
  /**
   * Composition rule unique identifier.
   */
  objectID: string;

  /**
   * Conditions that trigger a composition rule.
   */
  conditions: Array<Condition>;

  consequence: CompositionRuleConsequence;

  /**
   * Description of the rule\'s purpose to help you distinguish between different rules.
   */
  description?: string | undefined;

  /**
   * Whether the rule is active.
   */
  enabled?: boolean | undefined;

  /**
   * Time periods when the rule is active.
   */
  validity?: Array<TimeRange> | undefined;
};
