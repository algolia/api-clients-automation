import type { ReleaseType } from 'semver';
import { run } from '../common.ts';
import { getLanguageFolder } from '../config.ts';
import { isPreRelease } from './versionsHistory.ts';

export async function updateJavaScriptPackages(releaseType: ReleaseType) {
  const cwd = getLanguageFolder('javascript');
  await run('yarn', { cwd });
  const packages = JSON.parse(await run('yarn lerna ls --json --all --loglevel silent', { cwd })) as Array<{
    version: string;
    location: string;
  }>;

  for (const pkg of packages) {
    await run(`yarn version ${isPreRelease(pkg.version) ? 'prerelease' : releaseType}`, { cwd: pkg.location });
  }
}
