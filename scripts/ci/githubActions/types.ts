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
     * The command to build the clients.
     */
    buildCommand: string;
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
     * The snippets output path to store in the artifact.
     */
    snippetsToStore: string;
  }>;
};

export type ToRunMatrix = {
  path: string;
  toRun: string[];
};
