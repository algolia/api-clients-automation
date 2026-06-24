import { readdirSync, readFileSync } from 'node:fs';
import path from 'node:path';

import { describe, expect, it } from 'vitest';

import { BASE_PORT, PORTS_PER_SLOT, SERVER_PORTS } from '../cts/testServer/ports.ts';

const TEST_SERVER_DIR = path.resolve(import.meta.dirname, '../cts/testServer');

describe('SERVER_PORTS is the single source of truth', () => {
  const values = Object.values(SERVER_PORTS);

  it('has no duplicate ports', () => {
    expect(new Set(values).size).toBe(values.length);
  });

  it('is a contiguous block of PORTS_PER_SLOT ports starting at BASE_PORT', () => {
    // Contiguity is what makes `slot * PORTS_PER_SLOT` tile without overlap or gaps.
    const sorted = [...values].sort((a, b) => a - b);
    expect(sorted).toHaveLength(PORTS_PER_SLOT);
    expect(sorted[0]).toBe(BASE_PORT);
    sorted.forEach((port, i) => expect(port).toBe(BASE_PORT + i));
  });

  it('matches the entry count scripts/docker/slot.sh parses', () => {
    // Mirror the grep in slot.sh so the shell-computed offset can never drift from the list.
    const src = readFileSync(path.join(TEST_SERVER_DIR, 'ports.ts'), 'utf8');
    const entries = src.match(/^\s+\w+:\s*\d+,/gm) ?? [];
    expect(entries).toHaveLength(PORTS_PER_SLOT);
  });

  it('is referenced by every test server (no hardcoded ports)', () => {
    const offenders: string[] = [];
    for (const file of readdirSync(TEST_SERVER_DIR)) {
      if (!file.endsWith('.ts') || file === 'ports.ts' || file === 'index.ts') {
        continue;
      }
      const src = readFileSync(path.join(TEST_SERVER_DIR, file), 'utf8');
      if (/setupServer\(\s*['"][^'"]+['"]\s*,\s*\d+/.test(src)) {
        offenders.push(file);
      }
    }
    expect(offenders, `hardcoded ports found in: ${offenders.join(', ')}`).toEqual([]);
  });
});
