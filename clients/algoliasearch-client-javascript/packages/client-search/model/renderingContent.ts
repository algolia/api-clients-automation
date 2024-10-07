// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { FacetOrdering } from './facetOrdering';
import type { RedirectURL } from './redirectURL';
import type { Widgets } from './widgets';

/**
 * Extra data that can be used in the search UI.  You can use this to control aspects of your search UI, such as, the order of facet names and values without changing your frontend code.
 */
export type RenderingContent = {
  facetOrdering?: FacetOrdering;

  redirect?: RedirectURL;

  widgets?: Widgets;
};
