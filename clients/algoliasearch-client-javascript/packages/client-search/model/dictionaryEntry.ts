// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { DictionaryEntryState } from './dictionaryEntryState';
import type { DictionaryEntryType } from './dictionaryEntryType';
import type { SupportedLanguage } from './supportedLanguage';

/**
 * Dictionary entry.
 */
export type DictionaryEntry = Record<string, any> & {
  /**
   * Unique identifier for the dictionary entry.
   */
  objectID: string;

  language?: SupportedLanguage;

  /**
   * Matching dictionary word for `stopwords` and `compounds` dictionaries.
   */
  word?: string;

  /**
   * Matching words in the `plurals` dictionary including declensions.
   */
  words?: string[];

  /**
   * Invividual components of a compound word in the `compounds` dictionary.
   */
  decomposition?: string[];

  state?: DictionaryEntryState;

  type?: DictionaryEntryType;
};
