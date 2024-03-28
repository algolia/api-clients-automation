//
//  main.swift
//  playground
//
//  Created by Thomas Raffray on 23/12/2023.
//

import Foundation
import Core
import Search

guard let applicationID = Bundle.main.infoDictionary?["ALGOLIA_APPLICATION_ID"] as? String else {
    fatalError("Application ID not found in env")
}

guard let apiKey = Bundle.main.infoDictionary?["ALGOLIA_ADMIN_KEY"] as? String else {
    fatalError("Admin API key not found in env")
}

guard applicationID != "" && apiKey != "" else {
    fatalError("AppID and APIKey must be filled in your Info.plist file")
}

struct Contact: Codable, Hashable {
    let firstname: String
    let lastname: String
    let followers: Int
    let company: String
}

Task {
    do {
        let contacts: [Contact] = [
          .init(firstname: "Jimmie", lastname: "Barninger", followers: 93, company: "California Paint"),
          .init(firstname: "Warren", lastname: "Speach", followers: 42, company: "Norwalk Crmc")
        ]
        let indexName = "contacts"

        let client = try SearchClient(appID: applicationID, apiKey: apiKey)

        var taskIDs: [Int64] = []
        for contact in contacts {
            let saveObjRes = try await client.saveObject(indexName: indexName, body: contact)
            taskIDs.append(saveObjRes.taskID)
        }
        for taskID in taskIDs {
            try await client.waitForTask(with: taskID, in: indexName)
        }

        let searchParams = SearchSearchParamsObject(query: "Jimmy")

        let res: SearchResponse<Contact> = try await client.searchSingleIndex(
            indexName: "contacts",
            searchParams: .searchSearchParamsObject(searchParams)
        )

        dump(res.hits[0])
        
        exit(EXIT_SUCCESS)
    } catch {
        dump(error.localizedDescription)
        exit(EXIT_FAILURE)
    }
}

RunLoop.current.run()
