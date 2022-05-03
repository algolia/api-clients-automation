export type CreateMatrix = {
  /**
   * `baseChanged` is computed in `.github/actions/setup/action.yml`.
   */
  baseChanged: boolean;
  /**
   * The name of the branch of reference.
   */
  baseBranch: string;
  /**
   * `true` means we generated the matrix for the `clients` job, `false` for the specs.
   */
  forClients?: boolean;
};

type BaseMatrix = {
  /**
   * Name of the client.
   */
  name: string;
  /**
   * Path to the file/folder being handled.
   */
  path: string;
  /**
   * The computed cache key, used to restore files from the CI.
   */
  cacheKey: string;
};

export type ClientMatrix = BaseMatrix & {
  /**
   * The client language.
   */
  language: string;

  /**
   * The client name plus `Config` appended. With the casing corresponding to the language.
   */
  configName: string;
  /**
   * The client name plus `Client` appended. With the casing corresponding to the language.
   */
  apiName: string;

  /**
   * The capitalized name of the client.
   */
  capitalizedClientName: string;
  /**
   * The camelized name of the client.
   */
  camelizedClientName: string;

  /**
   * Path to the `API` file/folder of the client, based on the language.
   */
  apiPath: string;
  /**
   * Path to the `Model` file/folder of the client, based on the language.
   */
  modelPath: string;
  /**
   * Path to the bundled spec used to generated the client.
   */
  bundledSpecPath: string;

  /**
   * Wether to run the build action or not.
   *
   * E.g. It's false for `PHP` as it does not have a build process.
   */
  shouldBuild: boolean;

  /**
   * Wether to store the whole client folder or only the API/Model files.
   *
   * JavaScript outputs clients in their own folder, so we can store everything.
   *
   * PHP or Java will output generated files in a common `algoliasearch` API/Model folder,
   * so we only store the relevant files.
   */
  storeFolder: boolean;
};

export type SpecMatrix = BaseMatrix & {
  /**
   * The path of the bundled spec file.
   */
  bundledPath: string;
};

export type Matrix<TMatrix> = {
  client: TMatrix[];
};
