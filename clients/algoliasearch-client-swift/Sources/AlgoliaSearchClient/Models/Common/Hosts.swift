//
//  Hosts.swift
//
//
//  Created by Thomas Raffray on 15/12/2023.
//

import Foundation

public struct Hosts {

  public static func forApplicationID(_ appID: String) -> [RetryableHost] {

    func buildHost(_ components: (suffix: String, callType: RetryableHost.CallTypeSupport))
      -> RetryableHost
    {
      let url = URL(string: "\(appID)\(components.suffix)")!
      return RetryableHost(url: url, callType: components.callType)
    }
    let hosts = [
      ("-dsn.algolia.net", .read),
      (".algolia.net", .write),
    ].map(buildHost)

    let commonHosts = [
      ("-1.algolianet.com", .universal),
      ("-2.algolianet.com", .universal),
      ("-3.algolianet.com", .universal),
    ].map(buildHost).shuffled()

    return hosts + commonHosts
  }

  public static func insights(forRegion region: Region? = nil) -> [RetryableHost] {
    let regionComponent = region.flatMap { ".\($0.rawValue)" } ?? ""
    return [.init(url: URL(string: "insights\(regionComponent).algolia.io")!)]
  }

  public static func personalization(forRegion region: Region? = nil) -> [RetryableHost] {
    let regionComponent = region.flatMap { ".\($0.rawValue)" } ?? ""
    return [.init(url: URL(string: "personalization\(regionComponent).algolia.com")!)]
  }

  public static var analytics: [RetryableHost] = [
    .init(url: URL(string: "analytics.algolia.com")!)
  ]
}
