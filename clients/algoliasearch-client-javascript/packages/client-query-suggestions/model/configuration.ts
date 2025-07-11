// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { Languages } from './languages';
import type { SourceIndex } from './sourceIndex';

/**
 * Query Suggestions configuration.
 */
export type Configuration = {
  /**
   * Algolia indices from which to get the popular searches for query suggestions.
   */
  sourceIndices: Array<SourceIndex>;

  languages?: Languages | undefined;

  exclude?: Array<string> | null | undefined;

  /**
   * Whether to turn on personalized query suggestions.
   */
  enablePersonalization?: boolean | undefined;

  /**
   * Whether to include suggestions with special characters.
   */
  allowSpecialCharacters?: boolean | undefined;
};
