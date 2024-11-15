---
title: Generating Guides
---

# Generating Guides

You can create guides which allow you to write arbitrary code in any language and let the CI test the code and push it to your repo automatically.

## Create guide templates

Go to `templates` and you will find folders for each language. Inside, you can add a `.mustache` file to each language's `/guides` folder. This `.mustache` file serves as the template for your guide, and allows you to compose guides that inject client code programmatically.

Whenever API client methods are updated, a PR will be automatically generated based on a `pushConfig` which describes the expected set of guides and destination repo details.

## Create a push config

Go to `scripts` > `ci` > `codegen` > `pushConfigs.ts` and add a new config to the `pushConfigs` array

### Push Config Properties

- `destination`: (`object`)
  - `repo`: (`string`) the name of the destination repository
  - `prBranch`: (`string`) the name of the branch referenced in the created pull request
  - `baseBranch`: (`string`) the branch in the destination repo that you want to merge the created PR into
- `commitMessage`: (`string`) the PR commit message
- `guides`: (`string[]`) an array containing the name of the generated guides to include in the output file
- `outputFilePath`: (`string`) the path in the destination repo where the file will be written

### Example config

```js
{
  destination: {
    repo: 'AlgoliaWeb',
    prBranch: 'feat/automated-update-from-api-clients-automation-repository',
    baseBranch: 'develop',
  },
  commitMessage: 'feat: update generated guides',
  guides: ['saveObjectsMovies'],
  outputFilePath: '_client/src/routes/launchpad/onboarding-snippets.json'
}
```
