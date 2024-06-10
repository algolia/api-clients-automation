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
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.customDelete(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.customGet(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.customPost(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the getClusterIncidents method.
    ///
    /// getClusterIncidents
    func snippetForGetClusterIncidents() async throws {
        // >SEPARATOR getClusterIncidents default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getClusterIncidents(clusters: "c1-de")
        // SEPARATOR<
    }

    /// Snippet for the getClusterStatus method.
    ///
    /// getClusterStatus
    func snippetForGetClusterStatus() async throws {
        // >SEPARATOR getClusterStatus default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getClusterStatus(clusters: "c1-de")
        // SEPARATOR<
    }

    /// Snippet for the getIncidents method.
    ///
    /// getIncidents
    func snippetForGetIncidents() async throws {
        // >SEPARATOR getIncidents default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getIncidents()
        // SEPARATOR<
    }

    /// Snippet for the getIndexingTime method.
    ///
    /// getIndexingTime
    func snippetForGetIndexingTime() async throws {
        // >SEPARATOR getIndexingTime default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getIndexingTime(clusters: "c1-de")
        // SEPARATOR<
    }

    /// Snippet for the getLatency method.
    ///
    /// getLatency
    func snippetForGetLatency() async throws {
        // >SEPARATOR getLatency default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getLatency(clusters: "c1-de")
        // SEPARATOR<
    }

    /// Snippet for the getMetrics method.
    ///
    /// getMetrics
    func snippetForGetMetrics() async throws {
        // >SEPARATOR getMetrics default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getMetrics(metric: Metric.avgBuildTime, period: Period.minute)
        // SEPARATOR<
    }

    /// Snippet for the getReachability method.
    ///
    /// getReachability
    func snippetForGetReachability() async throws {
        // >SEPARATOR getReachability default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getReachability(clusters: "c1-de")
        // SEPARATOR<
    }

    /// Snippet for the getServers method.
    ///
    /// getInventory
    func snippetForGetServers() async throws {
        // >SEPARATOR getServers default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getServers()
        // SEPARATOR<
    }

    /// Snippet for the getStatus method.
    ///
    /// getStatus
    func snippetForGetStatus() async throws {
        // >SEPARATOR getStatus default
        // Initialize the client
        let client = try MonitoringClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getStatus()
        // SEPARATOR<
    }
}
