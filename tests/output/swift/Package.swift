// swift-tools-version: 5.9
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "AlgoliaSearchClientTests",
    dependencies: [
      .package(path: "../../../clients/algoliasearch-client-swift"),
    ],
    targets: [
        .testTarget(
            name: "AlgoliaSearchClientTests",
            dependencies: [
              .product(name: "Abtesting", package: "algoliasearch-client-swift"),
            ]
        ),
    ]
)
