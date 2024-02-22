// swift-tools-version: 5.9

import PackageDescription

let package = Package(
    name: "AlgoliaSearchClientSnippets",
    platforms: [
        .iOS(.v13),
        .macOS(.v10_15),
        .tvOS(.v13),
        .watchOS(.v6),
    ],
    products: [
        .library(
            name: "AlgoliaSearchClientSnippets",
            targets: ["AlgoliaSearchClientSnippets"]
        ),
    ],
    dependencies: [
        .package(path: "../../clients/algoliasearch-client-swift"),
        .package(url: "https://github.com/Flight-School/AnyCodable", from: "0.6.7"),
    ],
    targets: [
        .target(
            name: "AlgoliaSearchClientSnippets",
            dependencies: [
                .product(name: "AnyCodable", package: "AnyCodable"),
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
    ]
)
