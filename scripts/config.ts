import clientsConfig from '../config/clients.config.json';

import type { Generator, Language } from './types';

export function getLanguageFolder(language: Language): string {
  return clientsConfig[language].folder;
}

export function getLanguageApiFolder(language: Language): string {
  return clientsConfig[language].apiFolder;
}

export function getLanguageModelFolder(language: Language): string {
  return clientsConfig[language].modelFolder;
}

export function getTestExtension(language: Language): string {
  return clientsConfig[language].tests.extension;
}

export function getTestOutputFolder(language: Language): string {
  return clientsConfig[language].tests.outputFolder;
}

export function getCustomGenerator(language: Language): string {
  return clientsConfig[language].customGenerator;
}

export function getPackageVersion({
  language,
  additionalProperties,
}: Generator): string {
  if (language === 'javascript') {
    return additionalProperties.packageVersion;
  }
  return getPackageVersionExcludeJavascript(language);
}

export function getPackageVersionExcludeJavascript(
  language: Exclude<Language, 'javascript'>
): string {
  return clientsConfig[language].packageVersion;
}
