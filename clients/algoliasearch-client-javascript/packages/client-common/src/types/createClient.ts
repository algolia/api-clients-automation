import type { AlgoliaAgentOptions, TransporterOptions } from './transporter';

/**
 * Where credentials are placed on the request.
 *
 * - `'WithinHeaders'`: API key and application ID as headers.
 * - `'WithinQueryParameters'`: API key and application ID as query parameters.
 * - `'WithinBody'`: application ID as a query parameter, API key as `apiKey` in the JSON body of the
 *   requests that accept it: `search`, `searchSingleIndex`, `browse` and `searchForFacetValues`. Other
 *   requests send the API key as the `x-algolia-api-key` query parameter, so they can still hit URL length limits.
 */
export type AuthMode = 'WithinHeaders' | 'WithinQueryParameters' | 'WithinBody';

type OverriddenTransporterOptions = 'baseHeaders' | 'baseQueryParameters' | 'baseBodyParameters' | 'hosts';

export type CreateClientOptions = Omit<TransporterOptions, OverriddenTransporterOptions | 'algoliaAgent'> &
  Partial<Pick<TransporterOptions, OverriddenTransporterOptions>> & {
    appId: string;
    apiKey: string;
    authMode?: AuthMode | undefined;
    algoliaAgents: AlgoliaAgentOptions[];
  };

export type ClientOptions = Partial<Omit<CreateClientOptions, 'apiKey' | 'appId' | 'compress'>>;
