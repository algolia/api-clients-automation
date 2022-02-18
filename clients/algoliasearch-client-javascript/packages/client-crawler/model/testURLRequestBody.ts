export type TestURLRequestBody = {
  /**
   * The URL to test.
   */
  url: string;
  /**
   * A partial configuration object, that will be merged with the configuration saved. This allows to tests changes in a configuration before saving it. Note that it\'s not a deep merge, we will simply override all top level fields with the ones that you will pass.
   */
  config?: Record<string, any>;
};
