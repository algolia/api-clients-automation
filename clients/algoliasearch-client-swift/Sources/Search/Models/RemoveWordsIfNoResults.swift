// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

/// Strategy for removing words from the query when it doesn&#39;t return any results. This helps to avoid returning
/// empty search results.  &lt;dl&gt; &lt;dt&gt;&lt;code&gt;none&lt;/code&gt;&lt;/dt&gt; &lt;dd&gt;No words are removed
/// when a query doesn&#39;t return results.&lt;/dd&gt; &lt;dt&gt;&lt;code&gt;lastWords&lt;/code&gt;&lt;/dt&gt;
/// &lt;dd&gt;Treat the last (then second to last, then third to last) word as optional, until there are results or at
/// most 5 words have been removed.&lt;/dd&gt; &lt;dt&gt;&lt;code&gt;firstWords&lt;/code&gt;&lt;/dt&gt; &lt;dd&gt;Treat
/// the first (then second, then third) word as optional, until there are results or at most 5 words have been
/// removed.&lt;/dd&gt; &lt;dt&gt;&lt;code&gt;allOptional&lt;/code&gt;&lt;/dt&gt; &lt;dd&gt;Treat all words as
/// optional.&lt;/dd&gt; &lt;/dl&gt;  For more information, see [Remove words to improve results](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/in-depth/why-use-remove-words-if-no-results/).
public enum RemoveWordsIfNoResults: String, Codable, CaseIterable {
    case `none`
    case lastWords
    case firstWords
    case allOptional
}
