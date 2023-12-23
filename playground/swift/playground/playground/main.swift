//
//  main.swift
//  playground
//
//  Created by Thomas Raffray on 23/12/2023.
//

import Foundation
import Core
import Ingestion

guard let applicationID = Bundle.main.infoDictionary?["ALGOLIA_APPLICATION_ID"] as? String else {
    fatalError("Application ID not found in env")
}

guard let apiKey = Bundle.main.infoDictionary?["ALGOLIA_ADMIN_KEY"] as? String else {
    fatalError("Admin API key not found in env")
}

guard applicationID != "" && apiKey != "" else {
    fatalError("AppID and APIKey must be filled in your Info.plist file")
}

let client = IngestionClient(applicationID: applicationID, apiKey: apiKey, region: Region.us)

let res = try await client.getSources()

for source in res.sources {
    dump(source)
}

