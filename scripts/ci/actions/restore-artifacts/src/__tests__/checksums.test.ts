import { createHash } from 'node:crypto';
import fsp from 'node:fs/promises';
import { tmpdir } from 'node:os';
import { join } from 'node:path';

import { afterAll, beforeAll, describe, expect, it } from 'vitest';

import { parseExpectedChecksums, sha256, verifyChecksum } from '../checksums.ts';

const PAYLOAD = 'artifact payload';
const PAYLOAD_SHA = createHash('sha256').update(PAYLOAD).digest('hex');

let tmpDir: string;
let tmpFile: string;

beforeAll(async () => {
  tmpDir = await fsp.mkdtemp(join(tmpdir(), 'restore-artifacts-checksum-'));
  tmpFile = join(tmpDir, 'fixture.bin');
  await fsp.writeFile(tmpFile, PAYLOAD);
});

afterAll(async () => {
  if (tmpDir !== undefined) {
    await fsp.rm(tmpDir, { recursive: true, force: true });
  }
});

describe('parseExpectedChecksums', () => {
  it('parses valid lines', () => {
    const map = parseExpectedChecksums([`${PAYLOAD_SHA} specs`, `${'a'.repeat(64)}  clients-javascript`]);
    expect(map.get('specs')).toEqual(PAYLOAD_SHA);
    expect(map.get('clients-javascript')).toEqual('a'.repeat(64));
  });

  it('returns an empty map for no lines', () => {
    expect(parseExpectedChecksums([]).size).toEqual(0);
  });

  it('fails closed on a missing sha', () => {
    expect(() => parseExpectedChecksums(['specs'])).toThrow(/Malformed expected-checksums line/);
  });

  it('fails closed on a non hex sha', () => {
    expect(() => parseExpectedChecksums([`${'z'.repeat(64)} specs`])).toThrow(/Malformed expected-checksums line/);
  });

  it('fails closed on a truncated sha', () => {
    expect(() => parseExpectedChecksums([`${'a'.repeat(63)} specs`])).toThrow(/Malformed expected-checksums line/);
  });
});

describe('sha256', () => {
  it('hashes a file at an absolute path', async () => {
    await expect(sha256(tmpFile)).resolves.toEqual(PAYLOAD_SHA);
  });
});

describe('verifyChecksum', () => {
  it('passes on a matching file and throws on a mismatch', async () => {
    await expect(verifyChecksum(new Map([['specs', PAYLOAD_SHA]]), 'specs', tmpFile)).resolves.toBeUndefined();
    await expect(verifyChecksum(new Map([['specs', 'b'.repeat(64)]]), 'specs', tmpFile)).rejects.toThrow(
      /Checksum mismatch for the 'specs' artifact/,
    );
  });

  it('skips artifacts that have no expected checksum', async () => {
    await expect(verifyChecksum(new Map(), 'clients-go', 'does-not-exist.zip')).resolves.toBeUndefined();
  });
});
