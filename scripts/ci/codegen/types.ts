export type GuidesToPush = {
  // the type of changes to push to the repository (post-processing of files will be performed)
  type: 'guides';

  // the name of the guides to push in this pull request
  names: string[];

  // the name of the JSON file output that will contain every guides in `names`
  output: string;

  // a key-value of the variable in guides to replace, with the name you'd like to use instead
  placeholderVariables?: Record<string, string>;
};

export type SpecsToPush = {
  type: 'specs';
  output: string;
};

type RepositoryTask = {
  // the name of the pull request branch
  prBranch: string;

  // the commit message of the pull request (will also be used as the title)
  commitMessage: string;

  files: GuidesToPush | SpecsToPush;
};

export type RepositoryConfiguration = {
  // the name of the branch to base the pull request on
  baseBranch: string;

  // the pull requests tasks to create for this repository
  tasks: Array<RepositoryTask>;
};

export const pushToRepositoryConfiguration: { [k in 'AlgoliaWeb' | 'doc']: RepositoryConfiguration } = {
  AlgoliaWeb: {
    baseBranch: 'develop',
    tasks: [
      {
        prBranch: 'feat/update-generated-onboarding-guides',
        commitMessage: 'feat: update generated onboarding guides',
        files: {
          type: 'guides',
          names: ['saveObjectsMovies'],
          output: '_client/src/routes/launchpad/onboarding-snippets.json',
          placeholderVariables: {
            ALGOLIA_APPLICATION_ID: 'YourApplicationID',
            ALGOLIA_API_KEY: 'YourWriteAPIKey',
            '<YOUR_INDEX_NAME>': 'movies_index',
          },
        },
      },
      {
        prBranch: 'feat/update-generated-ingestion-guides',
        commitMessage: 'feat: update generated ingestion guides',
        files: {
          type: 'guides',
          names: ['pushSetup'],
          output: '_client/src/routes/connectors/generated/ingestion-snippets.json',
        },
      },
    ],
  },
  doc: {
    baseBranch: 'master',
    tasks: [
      {
        prBranch: 'feat/automated-update-from-api-clients-automation-repository',
        commitMessage: 'feat: update specs and supported versions',
        files: {
          type: 'specs',
          output: 'app_data/api/specs',
        },
      },
    ],
  },
};
