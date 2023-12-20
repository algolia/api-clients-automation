// swift-tools-version:5.1

import PackageDescription

#if os(Linux)
  let macOSVersion: SupportedPlatform.MacOSVersion = .v10_15
#else
  let macOSVersion: SupportedPlatform.MacOSVersion = .v10_10
#endif

#if os(Linux)
  let extraPackageDependencies: [Package.Dependency] = [
    .package(url: "https://github.com/apple/swift-crypto.git", from: "1.1.2")
  ]
#else
  let extraPackageDependencies: [Package.Dependency] = []
#endif

#if os(Linux)
  let extraTargetDependencies: [Target.Dependency] = [
    .product(name: "Crypto", package: "swift-crypto")
  ]
#else
  let extraTargetDependencies: [Target.Dependency] = []
#endif

let package = Package(
  name: "AlgoliaSearchClient",
  platforms: [
    .iOS(.v13),
    .macOS(macOSVersion),
    .tvOS(.v13),
    .watchOS(.v6),
  ],
  products: [
    .library(
      name: "Abtesting",
      targets: ["Abtesting"]
    ),
    .library(
      name: "Analytics",
      targets: ["Analytics"]
    ),
    .library(
      name: "Ingestion",
      targets: ["Ingestion"]
    ),
    .library(
      name: "Insights",
      targets: ["Insights"]
    ),
    .library(
      name: "Monitoring",
      targets: ["Monitoring"]
    ),
    .library(
      name: "Personalization",
      targets: ["Personalization"]
    ),
    .library(
      name: "QuerySuggestions",
      targets: ["QuerySuggestions"]
    ),
    .library(
      name: "Recommend",
      targets: ["Recommend"]
    ),
    .library(
      name: "Search",
      targets: ["Search"]
    ),
  ],
  dependencies: [
    .package(url: "https://github.com/Flight-School/AnyCodable", .upToNextMajor(from: "0.6.1")),
    .package(url: "https://github.com/apple/swift-log.git", from: "1.4.0"),
  ] + extraPackageDependencies,
  targets: [
    .target(
      name: "Core",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .product(name: "Logging", package: "swift-log"),
      ] + extraTargetDependencies,
      path: "Sources/Core"
    ),
    .target(
      name: "Abtesting",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .product(name: "Logging", package: "swift-log"),
        .target(name: "Core"),
      ] + extraTargetDependencies,
      path: "Sources/Abtesting"
    ),
    .target(
      name: "Analytics",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .product(name: "Logging", package: "swift-log"),
        .target(name: "Core"),
      ] + extraTargetDependencies,
      path: "Sources/Analytics"
    ),
    .target(
      name: "Ingestion",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .product(name: "Logging", package: "swift-log"),
        .target(name: "Core"),
      ] + extraTargetDependencies,
      path: "Sources/Ingestion"
    ),
    .target(
      name: "Insights",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .product(name: "Logging", package: "swift-log"),
        .target(name: "Core"),
      ] + extraTargetDependencies,
      path: "Sources/Insights"
    ),
    .target(
      name: "Monitoring",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .product(name: "Logging", package: "swift-log"),
        .target(name: "Core"),
      ] + extraTargetDependencies,
      path: "Sources/Monitoring"
    ),
    .target(
      name: "Personalization",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .product(name: "Logging", package: "swift-log"),
        .target(name: "Core"),
      ] + extraTargetDependencies,
      path: "Sources/Personalization"
    ),
    .target(
      name: "QuerySuggestions",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .product(name: "Logging", package: "swift-log"),
        .target(name: "Core"),
      ] + extraTargetDependencies,
      path: "Sources/QuerySuggestions"
    ),
    .target(
      name: "Recommend",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .product(name: "Logging", package: "swift-log"),
        .target(name: "Core"),
      ] + extraTargetDependencies,
      path: "Sources/Recommend"
    ),
    .target(
      name: "Search",
      dependencies: [
        .product(name: "AnyCodable", package: "AnyCodable"),
        .product(name: "Logging", package: "swift-log"),
        .target(name: "Core"),
      ] + extraTargetDependencies,
      path: "Sources/Search"
    ),
  ]
)
