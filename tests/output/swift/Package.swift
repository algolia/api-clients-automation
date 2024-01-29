// swift-tools-version: 5.9
// 

import PackageDescription

let package = Package(
  name: "AlgoliaSearchClientTests",
  dependencies: [
    .package(url: "https://github.com/Flight-School/AnyCodable", .upToNextMajor(from: "0.6.1")),
    .package(url: "https://github.com/SwiftyJSON/SwiftyJSON.git", from: "5.0.0"),
    .package(path: "../../../clients/algoliasearch-client-swift"),
  ],
  targets: [
    .testTarget(
      name: "requests",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .product(name: "SwiftyJSON", package: "SwiftyJSON"),
        .product(
          name: "Abtesting",
          package: "algoliasearch-client-swift"
        ),
        .product(
          name: "Analytics",
          package: "algoliasearch-client-swift"
        ),
        .product(
          name: "Ingestion",
          package: "algoliasearch-client-swift"
        ),
        .product(
          name: "Insights",
          package: "algoliasearch-client-swift"
        ),
        .product(
          name: "Monitoring",
          package: "algoliasearch-client-swift"
        ),
        .product(
          name: "Personalization",
          package: "algoliasearch-client-swift"
        ),
        .product(
          name: "QuerySuggestions",
          package: "algoliasearch-client-swift"
        ),
        .product(
          name: "Recommend",
          package: "algoliasearch-client-swift"
        ),
        .product(
          name: "Search",
          package: "algoliasearch-client-swift"
        ),
      ]
    )
  ]
)