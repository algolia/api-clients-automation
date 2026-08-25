import { createHash } from 'node:crypto';
import { createReadStream } from 'node:fs';
import { isAbsolute } from 'node:path';

import * as core from '@actions/core';

// lines are `<sha256> <artifact name>` coming from the producing jobs' outputs,
// artifacts without a line are restored unverified, a line that does not parse fails
export function parseExpectedChecksums(lines: string[]): Map<string, string> {
  const checksums = new Map<string, string>();
  for (const line of lines) {
    const [sha, name] = line.trim().split(/\s+/);
    if (!sha || !name || !/^[0-9a-f]{64}$/.test(sha)) {
      throw new Error(
        `Malformed expected-checksums line '${line}', the producing job's checksum output is probably missing`,
      );
    }
    checksums.set(name, sha);
  }
  return checksums;
}

export async function sha256(filePath: string): Promise<string> {
  return new Promise((resolve, reject) => {
    if (filePath.includes('..') || isAbsolute(filePath)) {
      reject(new Error('Invalid file path'));
      return;
    }
    const hash = createHash('sha256');
    createReadStream(filePath)
      .on('error', reject)
      .on('data', (chunk) => hash.update(chunk))
      .on('end', () => resolve(hash.digest('hex')));
  });
}

export async function verifyChecksum(
  checksums: Map<string, string>,
  artifactName: string,
  filePath: string,
): Promise<void> {
  const expected = checksums.get(artifactName);
  if (expected === undefined) {
    core.info(`No checksum provided for the '${artifactName}' artifact, restoring it unverified`);
    return;
  }
  const actual = await sha256(filePath);
  if (actual !== expected) {
    throw new Error(`Checksum mismatch for the '${artifactName}' artifact: expected ${expected}, got ${actual}`);
  }
  core.info(`Checksum verified for the '${artifactName}' artifact`);
}
