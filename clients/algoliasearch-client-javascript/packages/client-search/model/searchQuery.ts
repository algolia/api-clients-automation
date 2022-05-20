import type { SearchForFacetValuesRequest } from './searchForFacetValuesRequest';
import type { SearchParams } from './searchParams';

export type SearchQuery = SearchParams &
  (
    | ({
        // require that the keys of SearchForFacetValuesRequest aren't present
        [key in keyof SearchForFacetValuesRequest]?: undefined;
      } & {
        type?: 'default';
        indexName: string;
      })
    | (SearchForFacetValuesRequest & {
        type: 'facet';
        indexName: string;
        facet: string;
      })
  );
