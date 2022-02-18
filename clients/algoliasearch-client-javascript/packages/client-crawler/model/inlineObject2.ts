export type InlineObject2 = {
  urls: string[];
  /**
   * If true, the given URLs will be added to the `extraUrls` field of the config (if not already in `startUrls` or `sitemaps`). If false, the URLs will not be saved in the config. If unspecified, the URLs will be saved to the `extraUrls` field of the config only if they haven\'t been indexed during the last reindex.
   */
  save?: boolean;
};
