import type { AlgoliaAgentOptions, TransporterOptions } from './transporter';

/**
 * Where credentials are placed on the request.
 *
 * - `'WithinHeaders'`: API key and application ID as headers.
 * - `'WithinQueryParameters'`: API key and application ID as query parameters.
 * - `'WithinBody'`: Search-tested opt-in. Sends the API key in the JSON body as
 *   `apiKey`. GET requests and requests with empty or array bodies fall back to
 *   the `x-algolia-api-key` query parameter and can still hit URL limits.
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
