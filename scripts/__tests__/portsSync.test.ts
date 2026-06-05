import { readFileSync } from 'node:fs';
import path from 'node:path';

import { describe, expect, it } from 'vitest';

import { BASE_PORT, PORTS_PER_SLOT } from '../cts/testServer/ports.ts';

const ROOT = path.resolve(import.meta.dirname, '../..');

describe('PORTS_PER_SLOT sync', () => {
  it('TestsClient.java matches ports.ts', () => {
    const java = readFileSync(
      path.join(ROOT, 'generators/src/main/java/com/algolia/codegen/cts/tests/TestsClient.java'),
      'utf8',
    );

    const portsMatch = java.match(/PORTS_PER_SLOT\s*=\s*(\d+)/);
    expect(portsMatch, 'PORTS_PER_SLOT not found in TestsClient.java').not.toBeNull();
    expect(Number(portsMatch![1])).toBe(PORTS_PER_SLOT);

    const baseMatch = java.match(/BASE_PORT\s*=\s*(\d+)/);
    expect(baseMatch, 'BASE_PORT not found in TestsClient.java').not.toBeNull();
    expect(Number(baseMatch![1])).toBe(BASE_PORT);
  });
});
