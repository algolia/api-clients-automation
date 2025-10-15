import fsp from 'fs/promises';

import { hashElement } from 'folder-hash';

import { exists } from './common.ts';

export class Cache {
  folder: string;
  generatedFiles: string[];
  dependsOn: string[];
  cacheFile: string;

  constructor({
    folder,
    generatedFiles,
    dependsOn,
    cacheFile,
  }: {
    folder: string;
    generatedFiles: string[];
    dependsOn: string[];
    cacheFile: string;
  }) {
    this.folder = folder;
    this.generatedFiles = generatedFiles;
    this.dependsOn = dependsOn;
    this.cacheFile = cacheFile;
  }

  async computeHash(): Promise<string> {
    let hash = '';

    for (const generatedFile of this.generatedFiles) {
      hash += (await hashElement(`${this.folder}/${generatedFile}`)).hash;
    }

    for (const file of this.dependsOn) {
      hash += (await hashElement(`${this.folder}/${file}`)).hash;
    }

    return hash;
  }

  async hit(): Promise<boolean> {
    if (!(await exists(this.cacheFile))) {
      return false;
    }

    // hashElement throws when the folder is missing, we need to make sure it exists.
    for (const generatedFiles of this.generatedFiles) {
      if (!(await exists(`${this.folder}/${generatedFiles}`))) {
        return false;
      }
    }

    const storedHash = (await fsp.readFile(this.cacheFile)).toString();
    return storedHash === (await this.computeHash());
  }

  async store(): Promise<void> {
    await fsp.writeFile(this.cacheFile, await this.computeHash());
  }
}
