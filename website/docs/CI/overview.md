# Github Actions CI

The CI runs on Github Actions and tries to be as efficient as possible by only running the required steps based on the changes.
To achieve this, it's using a combination of caches and artifacts, with [matrix jobs](https://docs.github.com/en/actions/using-jobs/using-a-matrix-for-your-jobs) to run only certain languages.

## Note on JavaScript

JavaScript CI is highly specialized and contains many differences with the other clients, so it has it's own dedicated steps.
The rest applies for all the other languages.
