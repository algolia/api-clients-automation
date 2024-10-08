// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { FetchedIndex } from './fetchedIndex';

export type ListIndicesResponse = {
  /**
   * All indices in your Algolia application.
   */
  items: Array<FetchedIndex>;

  /**
   * Number of pages.
   */
  nbPages?: number;
};
