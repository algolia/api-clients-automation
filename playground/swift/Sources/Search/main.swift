// The Swift Programming Language
// https://docs.swift.org/swift-book

import Foundation

import DotEnv

import Core
@preconcurrency import Search

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

struct Contact: Codable {
    let firstname: String
    let lastname: String
    let followers: Int
    let company: String
}

do {
    let contacts: [Contact] = [
      .init(firstname: "Jimmie", lastname: "Barninger", followers: 93, company: "California Paint"),
      .init(firstname: "Warren", lastname: "Speach", followers: 42, company: "Norwalk Crmc")
    ]
    let indexName = "contacts"

    let config = try SearchClientConfiguration(appID: applicationID, apiKey: apiKey)
    let client = SearchClient(
      configuration: config,
      transporter: Transporter(configuration: config, exposeIntermediateErrors: true)
    )

    var taskIDs: [Int64] = []
    for contact in contacts {
        let saveObjRes = try await client.saveObject(indexName: indexName, body: contact)
        taskIDs.append(saveObjRes.taskID)
    }
    for taskID in taskIDs {
        try await client.waitForTask(indexName: indexName, taskID: taskID)
    }

    let searchParams = SearchSearchParamsObject(query: "Jimmy")

    let res: SearchResponse<Contact> = try await client.searchSingleIndex(
        indexName: "contacts",
        searchParams: .searchSearchParamsObject(searchParams)
    )

    dump(res.hits[0])
} catch {
    dump(error.localizedDescription)
}
