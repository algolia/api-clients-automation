export interface PushConfig {
  destination: { repo: string; prBranch: string; baseBranch: string };
  commitMessage: string;
  guides: Array<string>;
  outputFilePath: string;
}

export const pushConfigs: Array<PushConfig> = [
  {
    destination: {
      repo: 'AlgoliaWeb',
      prBranch: 'feat/automated-update-from-api-clients-automation-repository',
      baseBranch: 'develop',
    },
    commitMessage: 'feat: update generated guides',
    guides: ['saveObjectsMovies'],
    outputFilePath: '_client/src/routes/launchpad/onboarding-snippets.json',
  },
];
