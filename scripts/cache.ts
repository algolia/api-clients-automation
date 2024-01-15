import fsp from 'fs/promises';

import { hashElement } from 'folder-hash';

import { exists } from './common';

export class Cache {
  folder: string;
  generatedFiles: string[];
  filesToCache: string[];
  cacheFile: string;

  constructor({
    folder,
    generatedFiles,
    filesToCache,
    cacheFile,
  }: {
    folder: string;
    generatedFiles: string[];
    filesToCache: string[];
    cacheFile: string;
  }) {
    this.folder = folder;
    this.generatedFiles = generatedFiles;
    this.filesToCache = filesToCache;
    this.cacheFile = cacheFile;
  }

  async computeHash(): Promise<string> {
    let hash = '';

    for (const generatedFile of this.generatedFiles) {
      hash += (await hashElement(`${this.folder}/${generatedFile}`)).hash;
    }

    for (const fileToCache of this.filesToCache) {
      hash += (await hashElement(`${this.folder}/${fileToCache}`)).hash;
    }

    return hash;
  }

  async isValid(): Promise<boolean> {
    if (!(await exists(this.cacheFile))) {
      return false;
    }

    const storedHash = (await fsp.readFile(this.cacheFile)).toString();
    return storedHash === (await this.computeHash());
  }

  async store(): Promise<void> {
    await fsp.writeFile(this.cacheFile, await this.computeHash());
  }
}
