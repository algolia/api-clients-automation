// swift-tools-version: 5.9
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

var executableTargets: [Target] = []

[
    ("Abtesting", "abtesting"),
    ("Analytics", "analytics"),
    ("Ingestion", "ingestion"),
    ("Insights", "insights"),
    ("Monitoring", "monitoring"),
    ("Personalization", "personalization"),
    ("QuerySuggestions", "query-suggestions"),
    ("Recommend", "recommend"),
    ("Search", "search"),
].enumerated().forEach { _, client in
    let (name, library) = client
    executableTargets.append(
        .executableTarget(
            name: "\(library)-playground",
            dependencies: [
                .product(
                    name: name,
                    package: "algoliasearch-client-swift"
                )
            ],
            path: "Sources/\(name)"
        )
    )
}

let package = Package(
    name: "swift-playground",
    platforms: [
        .macOS(.v11),
    ],
    dependencies: [
        .package(path: "../../clients/algoliasearch-client-swift"),
    ],
    targets: executableTargets
)
