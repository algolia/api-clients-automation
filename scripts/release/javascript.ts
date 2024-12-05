import { ReleaseType } from 'semver';
import { run } from '../common.js';
import { getLanguageFolder } from '../config.js';
import { isPreRelease } from './versionsHistory.js';

export async function updateJavaScriptPackages(releaseType: ReleaseType) {
  const cwd = getLanguageFolder('javascript');
  const packages = JSON.parse(await run('yarn lerna ls --json --all --loglevel silent', { cwd })) as Array<{
    version: string;
    location: string;
  }>;

  for (const pkg of packages) {
    await run(`yarn version ${isPreRelease(pkg.version) ? 'prerelease' : releaseType}`, { cwd: pkg.location });
  }
}
