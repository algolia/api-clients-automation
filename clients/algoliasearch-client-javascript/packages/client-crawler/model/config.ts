import type { Action } from './action';
import type { ConfigCache } from './configCache';
import type { ConfigLogin } from './configLogin';
import type { ConfigRequestOptions } from './configRequestOptions';
import type { ConfigSafetyChecks } from './configSafetyChecks';

/**
 * Typed Schema used for autocompletion in the Editor of the Admin Console. Note: please keep in sync with crawler-common/src/config/validation.
 */
export type Config = {
  appId: string;
  apiKey: string;
  rateLimit: number;
  /**
   * How often you want to execute a complete recrawl. Expressed using [Later.js\' syntax](https://bunkat.github.io/later/).  If omitted, you will need to manually launch a reindex operation in order to update the crawled records.  Important notes: 1. The interval between two scheduled crawls must be equal or higher than 24 hours. 2. Times will be interpreted as UTC (GMT+0 timezone).
   */
  schedule?: string;
  /**
   * When `true`, all web pages are rendered with a chrome headless browser. You get the rendered HTML result.  Because rendering JavaScript-based web pages is much slower than crawling regular HTML pages, you can apply this setting to a specified list of [micromatch](https://github.com/micromatch/micromatch) URL patterns. These patterns can include negations and wildcards.    With this setting enabled, JavaScript is executed on the webpage. Because a lot of websites have infinite refreshes and updates, this Chrome headless browser is configured with a timeout (set to a few seconds).  This can lead to inconsistent records across recrawls, depending on the browser load and the website speed.  Make sure your crawler manages to load the data from JavaScript-based pages interested in fast enough.
   */
  renderJavaScript?: string[] | boolean | null;
  /**
   * Saves a backup of your production index before it is overwritten by the index generated during a recrawl.
   */
  saveBackup?: boolean;
  /**
   * When set to `true`, this tells the Crawler to ignore rules set in the robots.txt.
   */
  ignoreRobotsTxtRules?: boolean;
  /**
   * Whether the Crawler should extract records from a page whose `robots` meta tag contains `noindex` or `none`.  When `true`, the crawler will ignore the `noindex` directive of the [robots meta tag](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta/name#Other_metadata_names).  Its default value is currently `true`, but it will change to `false` in a near future. If you\'d like the crawler to not respect the `noindex` directive, you should set it explicitely.
   */
  ignoreNoIndex?: boolean;
  /**
   * Whether the Crawler should follow links marked as `nofollow`.  This setting applies to both: - links which should be ignored because the [`robots` meta tag](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta/name#Other_metadata_names) contains `nofollow`; - links whose [rel attribute](https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/rel) contains the `nofollow` directive.  When `true`, the crawler will consider those links as if they weren\'t marked to be ignored.  The crawler might still ignore links that don\'t match the patterns of your configuration.  Its default value is currently `true`, but it will change to `false` in a near future. If you\'d like the crawler to never respect `nofollow` directives, you should set it explicitely.  Note: The \"To\" suffix is here for consistency with `ignoreCanonicalTo`. While it only accepts a boolean for now, we plan for it to accept an array of patterns eventually. Please contact us if you need such fine grained control.
   */
  ignoreNoFollowTo?: boolean;
  /**
   * This tells the Crawler to process a page even if there is a meta canonical URL specified.  When set to `true`, it will ignore all canonical. When set to `string[]`, it will ignore canonical that matches the specified patterns.
   */
  ignoreCanonicalTo?: string[] | boolean | null;
  startUrls?: string[];
  sitemaps?: string[];
  /**
   * URLs found in `extraUrls` are treated as `startUrls` for your crawler: they are used as start points for the crawl.  Crawler saves URLs added through the **Add a URL** field of the Admin\'s Configuration tab to the `extraUrls` array.  Internally `extraUrls` is treated like `startUrls`. The seperate parameter serves to identify which URLs were added directly to the crawler\'s configuration file vs. Those that were added through the Admin.
   */
  extraUrls?: string[];
  /**
   * Determines the webpage patterns ignored or excluded during a crawl.  This list is checked against the url of webpages using [micromatch](https://github.com/micromatch/micromatch). You can use negation, wildcards, and more.
   */
  exclusionPatterns?: string[];
  /**
   * Filters out specified query parameters from crawled urls. Useful for avoiding duplicate crawls of the same page.
   */
  ignoreQueryParams?: string[];
  /**
   * Prefix added in front of all indices defined in the crawler\'s configuration.
   */
  indexPrefix?: string;
  /**
   * Defines the settings for the indices that updated by your crawler.  Index names should be provided as keys. Their values are objects that define Algolia index settings as properties (e.g. `searchableAttributes` `attributesForFaceting`).  Index settings will only be applied on your Algolia\'s index during the first run (or if the index doesn\'t exist when launching the reindex). Once an index has been created, settings are never re-applied: this prevents to not override any manual changes you may have done.
   */
  initialIndexSettings?: Record<string, any>;
  /**
   * Limits the number of URLs your crawler processes.  Useful for demoing and preventing infinite link holes in the website structure.  `maxUrls` does not guarantee consistent indexing accross recrawls. Because of parallel processing, discovered URLs can be processed in different orders for different recrawls.  This parameter is capped at a maximum of  `1,000,000`.
   */
  maxUrls?: number;
  /**
   * Limits the processing of URLs to a specified depth, inclusively.  _Maximum_: `100`.  URLs added manually (startUrls, sitemaps...) are not checked against this limit.  **How we calculate depth:**.
   */
  maxDepth?: number;
  /**
   * Defines which webpages will be visited. It is used in combination with the `pathsToMatchs` of your actions. The Crawler will visit all links that match at least one of those paths.
   */
  discoveryPatterns?: string[];
  /**
   * Defines a hostname key that will be transformed as the value specified. The keys are exact match only.  Applied to: - All URLs found - Canonical - Redirection.  Not applied to: - props: startUrls, extraUrls, pathsToMatch, etc... - URLs in your code.
   */
  hostnameAliases?: Record<string, any>;
  pathAliases?: Record<string, any>;
  /**
   * Determines the function used to extract URLs from pages.  If provided, this function is called on a crawled page. Only the URLs it returns are enqueued for further crawling. By default, all the URLs found while crawling a page are enqueued given that they comply with `pathsToMatch`, `fileTypesToMatch` and `exclusions`.  Expected return value: `array` of `strings` (URLs).
   */
  linkExtractor?: any | null;
  _requestOptions?: ConfigRequestOptions;
  login?: ConfigLogin;
  cache?: ConfigCache;
  /**
   * Defines the list of External Data you want to use for this configuration. Every External Data declared here can be accessed in your `recordExtractor` through the `dataSources` object.
   */
  externalData?: string[];
  /**
   * Determines which web pages are translated into Algolia records and in what way.  A single action defines: 1. The subset of your crawler\'s websites it targets, 2. The extraction process for those websites, 3. And the index(es) to which the extracted records are pushed.  A single web page can match multiple actions. In this case, your crawler creates a record for each matched actions.
   */
  actions: Action[];
  safetyChecks?: ConfigSafetyChecks;
};
