## Dependency of generated code

Here is a summary of what generated codes depends on, what needs to be checked for the cache.
Note that this is only the generating dependency graph, that mean if a parent has changed, the child must be generated again.

`yarn cli cts generate javascript <client>`

```mermaid
flowchart TD
  clients.config.json --> Scripts
  openapitools.json --> Scripts
  .github --> Scripts
  npm-package --> Scripts

  Custom-eslint --> ESLint

  Spec-Search --> Bundled-Spec-Search
  Common-Spec --> Bundled-Spec-Search
  Scripts --> Bundled-Spec-Search
  ESLint --> Bundled-Spec-Search

  Bundled-Spec-Search --> Generators

  CTS-Templates-JS --> CTS-JS-Search
  Scripts --> CTS-JS-Search
  Generators --> CTS-JS-Search
  CTS-Search --> CTS-JS-Search
  CTS-JS-Common-Files --> CTS-JS-Search
  %% Spec-Search --> CTS-JS-Search

  Client-Template-JS --> Client-JS-Search
  Generators --> Client-JS-Search
  Scripts --> Client-JS-Search
  Client-JS-Search-Common-Files --> Client-JS-Search
  Client-JS-Common-Files --> Client-JS-Search
```
