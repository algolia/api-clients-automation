import type { SearchQuery } from './SearchQuery';
import type { SearchStrategy } from './searchStrategy';

export type SearchMethodParams = {
  requests: SearchQuery[];
  strategy?: SearchStrategy;
};
