import { createHash } from 'node:crypto';
import fsp from 'node:fs/promises';

import { afterAll, describe, expect, it } from 'vitest';

import { parseExpectedChecksums, sha256, verifyChecksum } from '../checksums.ts';

// relative path on purpose, sha256 rejects absolute paths
const TMP_FILE = '.vitest-checksum-fixture';
const PAYLOAD = 'artifact payload';
const PAYLOAD_SHA = createHash('sha256').update(PAYLOAD).digest('hex');

afterAll(async () => {
  await fsp.rm(TMP_FILE, { force: true });
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
  it('rejects path traversal and absolute paths', async () => {
    await expect(sha256('../etc/passwd')).rejects.toThrow('Invalid file path');
    await expect(sha256('/etc/passwd')).rejects.toThrow('Invalid file path');
  });
});

describe('verifyChecksum', () => {
  it('passes on a matching file and throws on a mismatch', async () => {
    await fsp.writeFile(TMP_FILE, PAYLOAD);
    await expect(verifyChecksum(new Map([['specs', PAYLOAD_SHA]]), 'specs', TMP_FILE)).resolves.toBeUndefined();
    await expect(verifyChecksum(new Map([['specs', 'b'.repeat(64)]]), 'specs', TMP_FILE)).rejects.toThrow(
      /Checksum mismatch for the 'specs' artifact/,
    );
  });

  it('skips artifacts that have no expected checksum', async () => {
    await expect(verifyChecksum(new Map(), 'clients-go', 'does-not-exist.zip')).resolves.toBeUndefined();
  });
});
