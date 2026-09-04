import { createHash } from 'node:crypto';
import fsp from 'node:fs/promises';
import { tmpdir } from 'node:os';
import { join } from 'node:path';

import * as core from '@actions/core';
import { afterAll, beforeAll, beforeEach, describe, expect, it, vi } from 'vitest';

import type { Verification } from '../checksums.ts';
import { parseExpectedChecksums, sha256, verifyChecksum, warnAboutUnverified } from '../checksums.ts';

vi.mock('@actions/core', () => {
  return {
    info: vi.fn(),
    warning: vi.fn(),
  };
});

const PAYLOAD = 'artifact payload';
const PAYLOAD_SHA = createHash('sha256').update(PAYLOAD).digest('hex');

let tmpDir: string;
let tmpFile: string;

beforeAll(async () => {
  tmpDir = await fsp.mkdtemp(join(tmpdir(), 'restore-artifacts-checksum-'));
  tmpFile = join(tmpDir, 'fixture.bin');
  await fsp.writeFile(tmpFile, PAYLOAD);
});

let verification: Verification;

beforeEach(() => {
  verification = { checksums: new Map(), unverified: [] };
  vi.clearAllMocks();
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
    verification.checksums.set('specs', PAYLOAD_SHA);
    await expect(verifyChecksum(verification, 'specs', tmpFile)).resolves.toBeUndefined();
    verification.checksums.set('specs', 'b'.repeat(64));
    await expect(verifyChecksum(verification, 'specs', tmpFile)).rejects.toThrow(
      /Checksum mismatch for the 'specs' artifact/,
    );
    expect(verification.unverified).toEqual([]);
  });

  it('fails closed when the file is missing but a checksum is expected', async () => {
    verification.checksums.set('specs', PAYLOAD_SHA);
    await expect(verifyChecksum(verification, 'specs', join(tmpDir, 'missing.zip'))).rejects.toMatchObject({
      code: 'ENOENT',
    });
  });

  it('skips artifacts that have no expected checksum without annotating each one', async () => {
    await expect(verifyChecksum(verification, 'clients-go', 'does-not-exist.zip')).resolves.toBeUndefined();
    expect(core.info).toHaveBeenCalledWith(
      "No checksum provided for the 'clients-go' artifact, restoring it unverified",
    );
    expect(core.warning).not.toHaveBeenCalled();
    expect(verification.unverified).toEqual(['clients-go']);
  });
});

describe('warnAboutUnverified', () => {
  it('reports every unverified artifact in a single warning', async () => {
    await verifyChecksum(verification, 'clients-go', 'does-not-exist.zip');
    await verifyChecksum(verification, 'clients-php', 'does-not-exist.zip');
    warnAboutUnverified(verification.unverified);
    expect(core.warning).toHaveBeenCalledTimes(1);
    expect(vi.mocked(core.warning).mock.calls[0][0]).toEqual(
      'Restored 2 artifact(s) without checksum verification: clients-go, clients-php',
    );
  });

  it('says nothing when everything was verified', () => {
    warnAboutUnverified([]);
    expect(core.warning).not.toHaveBeenCalled();
  });
});
