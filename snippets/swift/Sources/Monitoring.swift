#if canImport(Core)
    import Core
#endif
// >IMPORT
import Monitoring

// IMPORT<

final class MonitoringClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customDelete(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customGet(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getClusterIncidents method.
    ///
    /// getClusterIncidents
    func snippetForGetClusterIncidents() async throws {
        // >SEPARATOR getClusterIncidents default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getClusterIncidents(clusters: "c1-de")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getClusterStatus method.
    ///
    /// getClusterStatus
    func snippetForGetClusterStatus() async throws {
        // >SEPARATOR getClusterStatus default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getClusterStatus(clusters: "c1-de")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getIncidents method.
    ///
    /// getIncidents
    func snippetForGetIncidents() async throws {
        // >SEPARATOR getIncidents default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getIncidents()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getIndexingTime method.
    ///
    /// getIndexingTime
    func snippetForGetIndexingTime() async throws {
        // >SEPARATOR getIndexingTime default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getIndexingTime(clusters: "c1-de")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getLatency method.
    ///
    /// getLatency
    func snippetForGetLatency() async throws {
        // >SEPARATOR getLatency default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getLatency(clusters: "c1-de")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getMetrics method.
    ///
    /// getMetrics
    func snippetForGetMetrics() async throws {
        // >SEPARATOR getMetrics default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getMetrics(metric: Metric.avgBuildTime, period: Period.minute)
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getReachability method.
    ///
    /// getReachability
    func snippetForGetReachability() async throws {
        // >SEPARATOR getReachability default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getReachability(clusters: "c1-de")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getServers method.
    ///
    /// getInventory
    func snippetForGetServers() async throws {
        // >SEPARATOR getServers default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getServers()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getStatus method.
    ///
    /// getStatus
    func snippetForGetStatus() async throws {
        // >SEPARATOR getStatus default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getStatus()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setClientApiKey method.
    ///
    /// switch API key
    func snippetForSetClientApiKey() async throws {
        // >SEPARATOR setClientApiKey default
        // Initialize the client
        let client = try MonitoringClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }
}
