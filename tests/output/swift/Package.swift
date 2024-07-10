// swift-tools-version: 5.9

import PackageDescription

let libraries: [Target.Dependency] = [
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
    .product(
        name: "Usage",
        package: "algoliasearch-client-swift"
    ),
]

let package = Package(
    name: "AlgoliaSearchClientTests",
    platforms: [
        .macOS(.v11),
    ],
    dependencies: [
        .package(url: "https://github.com/swiftpackages/DotEnv.git", from: "3.0.0"),
        .package(path: "../../../clients/algoliasearch-client-swift"),
    ],
    targets: [
        .target(
            name: "Utils",
            dependencies: [
                .product(name: "Core", package: "algoliasearch-client-swift"),
                .product(name: "Search", package: "algoliasearch-client-swift"),
            ],
            path: "Tests/Utils"
        ),
        .testTarget(
            name: "client",
            dependencies: [
                .target(name: "Utils"),
            ] + libraries
        ),
        .testTarget(
            name: "requests",
            dependencies: [
                .product(name: "DotEnv", package: "DotEnv"),
                .target(name: "Utils"),
            ] + libraries
        ),
    ]
)
