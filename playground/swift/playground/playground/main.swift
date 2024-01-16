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

struct Contact: Codable {
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

        let client = SearchClient(applicationID: applicationID, apiKey: apiKey)

        for contact in contacts {
            let saveObjRes = try await client.saveObject(indexName: "contacts", body: contact)
//            let saveObjRes = try await client.saveObject(indexName: "contacts", body: contact, requestOptions: RequestOptions(headers: ["X-Algolia-Test": "True"], body: ["age": contact.followers]))
            while true {
                let taskResponse = try await client.getTask(indexName: "contacts", taskID: saveObjRes.taskID)
                if taskResponse.status == TaskStatus.published {
                    break
                }
            }
        }

        let searchParams = SearchParamsObject(query: "Jimmy")

        let res = try await client.searchSingleIndex(
            indexName: "contacts",
            searchParams: .searchParamsObject(searchParams)
        )

        dump(res.hits[0])
        
        exit(EXIT_SUCCESS)
    } catch {
        dump(error.localizedDescription)
        exit(EXIT_FAILURE)
    }
}

RunLoop.current.run()
