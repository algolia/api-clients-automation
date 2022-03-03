---
title: How to send PRs
---

# How to send PRs

Since submodules introduced, the way we make changes and send PRs is different.

**Ground rule**: we do not commit the generated clients. You can run `yarn docker generate <LANG>` locally to see the outcome, but you don't need to commit them, because it will be done automatically during the release process.

## If you changed only on the monorepo level,

If you changed files only on the monorepo level (not under `clients/`), then it's the same. You can directly create a PR.

## If you need to change something under `clients/`,

If you need to change something under `clients/`, for example, rollup config, it's not something you can generate from the monorepo level. So you need to do it directly inside `clients/`.

Here's a slightly shift of mental model. Those `algoliasearch-client-xxx` folders under `clients/` are no longer real folders and files. The monorepo has references to the commit SHAs to those repositories. That's it. So you are actually making changes in the language repository. For example, when you change `clients/algoliasearch-client-javascript/rollup.config.js`, you will create a pull request in the `algoliasearch-client-javascript` repository. We are using `next` branch for the automated clients. So you will create a PR from something like `chore/rollup` → `next`. Then we review the PR in `algoliasearch-client-javascript` repository. It will be approved and merged back to `next`. By the way, our release script only works for commits starting with `chore: release`, so this won't trigger any release. Once merged, you come back to the monorepo,

```bash
cd clients/algoliasearch-client-javascript
git pull origin next
```

↑ This pulls the latest changes. And now the monorepo's reference to `algoliasearch-client-javascript` is outdated.

```bash
cd ../../
git status
```

```
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   clients/algoliasearch-client-javascript
```

So, we need to commit the change.

```
git add clients/algoliasearch-client-javascript
git commit -m "chore: update submodule"
```

And this commit is going to become a PR on the monorepo side. Git Submodules pin-points specific commit SHA, not a branch.

We could even automate this part so that whenever a new commit is pushed to language repositories, there will be a PR on the monorepo to update the reference, but it seems too much for now. Let's get used to the whole workflow until we attempt to automate more.
