import { readFileSync, writeFileSync } from 'fs';
import path from 'path';

function setHostsOptions(): void {
  const openapitoolsPath = path.join(__dirname, '../../openapitools.json');
  const openapitools = JSON.parse(readFileSync(openapitoolsPath, 'utf-8'));

  const [generator, rawURL, fallbackToAliasHost, isEuHost, isDeHost] =
    process.argv.slice(2);
  const generatorOptions = openapitools['generator-cli'].generators[generator];

  if (!generator || !generatorOptions) {
    throw new Error(`Generator not found: ${generator}`);
  }

  if (!rawURL) {
    throw new Error(`Invalid server: ${rawURL}`);
  }

  const { host } = new URL(rawURL);

  openapitools['generator-cli'].generators[generator] = {
    ...generatorOptions,
    additionalProperties: {
      ...generatorOptions.additionalProperties,
      hasRegionalHost: true,
      fallbackToAliasHost: fallbackToAliasHost === 'true' || undefined,
      isEuHost: isEuHost === 'true' || undefined,
      isDeHost: isDeHost === 'true' || undefined,
      host: host.split('.')[0],
      topLevelDomain: host.split('.').pop(),
    },
  };

  writeFileSync(openapitoolsPath, JSON.stringify(openapitools, null, 2));
}

setHostsOptions();
