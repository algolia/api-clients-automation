---
title: Generating Guides
---

# Generating Guides

You can create guides which allow you to write arbitrary code in any language and let the CI test the code and push it to your repo automatically.

## Create guide templates

Go to `templates` and you will find folders for each language. Inside, you can add a `.mustache` file to each language's `/guides` folder. This `.mustache` file serves as the template for your guide, and allows you to compose guides that inject client code programmatically.

Whenever API client methods are updated, a PR will be automatically generated based on a `pushConfig` which describes the expected set of guides and destination repo details.

## Create a push config

See the [`pushToRepositoryConfiguration`](https://github.com/algolia/api-clients-automation/blob/main/scripts/ci/codegen/types.ts#L38) and add your repository to the map, or a `task` if it's already listed.

### Push Config Properties

> [See the definition of `RepositoryConfiguration`](https://github.com/algolia/api-clients-automation/blob/main/scripts/ci/codegen/types.ts#L30)

### Example config

> A `task` describes a pull request action for the files selected

```js
{
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
}
```
