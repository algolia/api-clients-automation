// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { CommercetoolsCustomFields } from './commercetoolsCustomFields';

export type SourceUpdateCommercetools = {
  storeKeys?: Array<string>;

  /**
   * Locales for your commercetools stores.
   */
  locales?: Array<string>;

  url?: string;

  /**
   * Whether a fallback value is stored in the Algolia record if there\'s no inventory information about the product.
   */
  fallbackIsInStockValue?: boolean;

  customFields?: CommercetoolsCustomFields;
};
