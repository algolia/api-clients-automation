// swift-tools-version: 5.9

import PackageDescription

let package = Package(
    name: "AlgoliaSearchClientSnippets",
    platforms: [
        .iOS(.v13),
        .macOS(.v11),
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
    ],
    targets: [
        .target(
            name: "AlgoliaSearchClientSnippets",
            dependencies: [
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
