export type CreateMatrix = {
  /**
   * The name of the branch of reference.
   */
  baseBranch: string;
  /**
   * `true` means we generated the matrix for the `clients` job, `false` for the specs.
   */
  forClients?: boolean;
};

export type ClientMatrix = {
  client: Array<{
    /**
     * Path to the file/folder being handled.
     */
    path: string;
    /**
     * The list of clients to run in the CI.
     */
    toRun: string;
    /**
     * The client language.
     */
    language: string;
    /**
     * The root of the test folder.
     */
    testsRootFolder: string;
    /**
     * The test output path to delete before running the CTS generation.
     */
    testsToDelete: string;
    /**
     * The test output path to store in the artifact.
     */
    testsToStore: string;
    /**
     * The guides output path folder to store in the artifact.
     */
    guidesToStore: string;
    /**
     * The version of the language to run, used for the setup step.
     */
    version?: string;
    /**
     * Whether the current matrix version is the main version, this allows us to skip CI steps that should run only once (e.g. Store artifact).
     */
    isMainVersion: boolean;
  }>;
};

export type ToRunMatrix = {
  path: string;
  toRun: string[];
};
