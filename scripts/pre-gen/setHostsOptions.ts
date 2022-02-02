import { existsSync, readFileSync, writeFileSync } from 'fs';
import path from 'path';

import yaml from 'js-yaml';

type Server = {
  url: string;
  variables?: {
    [k: string]: {
      enum?: string[];
      default: string;
    };
  };
};

type Spec = Record<string, any> & {
  servers: Server[];
};

type AdditionalProperties = Partial<{
  hasRegionalHost: boolean;
  fallbackToAliasHost: boolean;
  isEuHost: boolean;
  isDeHost: boolean;
  host: string;
  topLevelDomain: string;
}>;

function setHostsOptions(): void {
  const openapitoolsPath = path.join(__dirname, '../../openapitools.json');
  const openapitools = JSON.parse(readFileSync(openapitoolsPath, 'utf-8'));

  const [language, client] = process.argv.slice(2);
  const generator = `${language}-${client}`;
  const generatorOptions = openapitools['generator-cli'].generators[generator];

  if (!generator || !generatorOptions) {
    throw new Error(`Generator not found: ${generator}`);
  }

  const specPath = path.join(__dirname, `../../specs/dist/${client}.yml`);

  if (!existsSync(specPath)) {
    throw new Error(`File not found ${specPath}`);
  }

  try {
    const { servers } = yaml.load(readFileSync(specPath, 'utf8')) as Spec;
    const options: AdditionalProperties = {
      fallbackToAliasHost:
        client === 'insights' ||
        client === 'analytics' ||
        client === 'abtesting' ||
        undefined,
    };

    for (const { url, variables } of servers) {
      if (!url) {
        throw new Error(`Invalid server: ${url}`);
      }

      const { host } = new URL(url);

      if (!variables?.region || !variables?.region?.enum) {
        continue;
      }

      options.hasRegionalHost = true;

      if (variables.region.enum.includes('eu')) {
        options.isEuHost = true;
      }

      if (variables.region.enum.includes('de')) {
        options.isDeHost = true;
      }

      options.host = host.split('.')[0];
      options.topLevelDomain = host.split('.').pop();
    }

    openapitools['generator-cli'].generators[generator].additionalProperties = {
      ...generatorOptions.additionalProperties,
      ...options,
    };

    writeFileSync(openapitoolsPath, JSON.stringify(openapitools, null, 2));
  } catch (e) {
    throw new Error(`Error reading yaml file ${generator}: ${e}`);
  }
}

setHostsOptions();
