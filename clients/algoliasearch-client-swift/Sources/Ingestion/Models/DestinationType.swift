// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Destination type.  &lt;dl&gt; &lt;dt&gt;&lt;code&gt;search&lt;/code&gt;&lt;/dt&gt; &lt;dd&gt;Data is stored in an
/// Algolia index.&lt;/dd&gt; &lt;dt&gt;&lt;code&gt;insights&lt;/code&gt;&lt;/dt&gt; &lt;dd&gt;Data is recorded as user
/// events in the Insights API.&lt;/dd&gt; &lt;/dl&gt;.
public enum DestinationType: String, Codable, CaseIterable {
    case search
    case insights
}

extension DestinationType: Hashable {}
