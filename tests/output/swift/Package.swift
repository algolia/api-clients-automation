// swift-tools-version: 5.9
// 

import PackageDescription

let package = Package(
  name: "AlgoliaSearchClientTests",
  dependencies: [
    .package(url: "https://github.com/Flight-School/AnyCodable", .upToNextMajor(from: "0.6.1")),
    .package(path: "../../../clients/algoliasearch-client-swift"),
  ],
  targets: [
    .target(
        name: "Utils",
        dependencies: [
            .product(name: "AnyCodable", package: "AnyCodable")
        ],
        path: "Tests/Utils"
    ),
    .testTarget(
      name: "client",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .target(name: "Utils"),
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
    ),
    .testTarget(
      name: "requests",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .target(name: "Utils"),
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