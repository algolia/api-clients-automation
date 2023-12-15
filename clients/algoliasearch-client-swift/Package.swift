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
    .iOS(.v11),
    .macOS(macOSVersion),
    .tvOS(.v11),
    .watchOS(.v4),
  ],
  products: [
    .library(
      name: "AlgoliaSearchClient",
      targets: ["AlgoliaSearchClient"]
    )
  ],
  dependencies: [
    .package(url: "https://github.com/Flight-School/AnyCodable", .upToNextMajor(from: "0.6.1")),
    .package(url: "https://github.com/apple/swift-log.git", from: "1.4.0"),
  ] + extraPackageDependencies,
  targets: [
    .target(
      name: "AlgoliaSearchClient",
      dependencies: [
        "AnyCodable",
        .product(name: "Logging", package: "swift-log"),
      ] + extraTargetDependencies,
      path: "Sources/AlgoliaSearchClient"
    )
  ]
)
