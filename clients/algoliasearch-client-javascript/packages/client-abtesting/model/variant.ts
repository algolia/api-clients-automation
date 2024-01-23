// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { CurrenciesValue } from './currenciesValue';
import type { FilterEffects } from './filterEffects';

export type Variant = {
  /**
   * Number of add-to-cart events for this variant.
   */
  addToCartCount: number;

  /**
   * Variant\'s [add-to-cart rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#add-to-cart-rate).
   */
  addToCartRate: number;

  /**
   * Variant\'s [average click position](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-position).
   */
  averageClickPosition: number;

  /**
   * Number of click events for this variant.
   */
  clickCount: number;

  /**
   * Variant\'s [click-through rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).
   */
  clickThroughRate: number;

  /**
   * Number of click events for this variant.
   */
  conversionCount: number;

  /**
   * Variant\'s [conversion rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate).
   */
  conversionRate: number;

  /**
   * A/B test currencies.
   */
  currencies: Record<string, CurrenciesValue>;

  /**
   * A/B test description.
   */
  description: string;

  filterEffects?: FilterEffects;

  /**
   * A/B test index.
   */
  index: string;

  /**
   * Number of [searches without results](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#searches-without-results) for that variant.
   */
  noResultCount: number;

  /**
   * Number of purchase events for this variant.
   */
  purchaseCount: number;

  /**
   * Variant\'s [purchase rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#purchase-rate).
   */
  purchaseRate: number;

  /**
   * Number of searches carried out during the A/B test.
   */
  searchCount: number;

  /**
   * Number of tracked searches. This is the number of search requests where the `clickAnalytics` parameter is `true`.
   */
  trackedSearchCount: number;

  /**
   * A/B test traffic percentage.
   */
  trafficPercentage: number;

  /**
   * Number of users during the A/B test.
   */
  userCount: number;

  /**
   * Number of users that performed a tracked search during the A/B test.
   */
  trackedUserCount: number;
};
