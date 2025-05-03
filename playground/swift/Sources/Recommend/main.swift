// The Swift Programming Language
// https://docs.swift.org/swift-book

import Foundation

import DotEnv

import Core
@preconcurrency import Recommend

do {
    guard let currentFileURL = URL(string: #file) else {
        fatalError("Unable to get current file URL")
    }

    let packageDirectoryURL = currentFileURL
        .deletingLastPathComponent()
        .deletingLastPathComponent()
        .deletingLastPathComponent()
        .deletingLastPathComponent()

    let dotEnvURL = packageDirectoryURL
        .appendingPathComponent(".env")
    try DotEnv.load(path: dotEnvURL.absoluteString, encoding: .utf8, overwrite: true)
} catch {
    fatalError("Unable to load .env file from playground folder")
}

let env = ProcessInfo.processInfo.environment

guard let applicationID = env["ALGOLIA_APPLICATION_ID"] else {
    fatalError("Application ID not found in env")
}

guard let apiKey = env["ALGOLIA_ADMIN_KEY"] else {
    fatalError("Admin API key not found in env")
}

guard applicationID != "" && apiKey != "" else {
    fatalError("AppID and ApiKey must be filled in your .env file")
}

dump("Hello, world!")
