export type Action = {
  /**
   * Unique name of the action.
   */
  name?: string;
  indexName: string;
  partialUpdate?: boolean;
  /**
   * How often this specific action will run. See root level schedule for more details.
   */
  schedule?: string;
  /**
   * Will determine which webpages will match for this action. This list is checked against the url of webpages using [micromatch](https://github.com/micromatch/micromatch). Negation, wildcards and more can be used. Check the full documentation.
   */
  pathsToMatch?: string[];
  /**
   * Will check for the presence or absence of DOM nodes.
   */
  selectorsToMatch?: string[];
  /**
   * Override if you want to index documents. Chosen file types will be converted to HTML using [Tika](https://wiki.apache.org/tika/TikaJAXRS), then treated as a normal HTML page. See the [documents guide](https://www.algolia.com/doc/tools/crawler/guides/extracting-data/how-to/index-documents/) for a list of available `fileTypes`.
   */
  fileTypesToMatch?: any | null;
  /**
   * Generate an `objectID` for records that don\'t have one. See the [`objectID` definition](#). Setting this parameter to `false` means we\'ll raise an error in case an extracted record doesn\'t have an `objectID`. Note, this parameter is not compatible with `partialUpdate = true`.
   */
  autoGenerateObjectIDs?: boolean;
  /**
   * An recordExtractor is just a custom Javascript function that let you execute your own code and extract what you want from a page.
   */
  recordExtractor?: any | null;
};
