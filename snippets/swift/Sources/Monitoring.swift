import AnyCodable

import Core
import Monitoring

final class MonitoringClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customDelete(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customGet(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customPost(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the getClusterIncidents method.
    ///
    /// getClusterIncidents
    func snippetForGetClusterIncidents() async throws {
        // >SEPARATOR getClusterIncidents
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getClusterIncidents(
            clusters: "c1-de"
        )
        // SEPARATOR<
    }

    /// Snippet for the getClusterStatus method.
    ///
    /// getClusterStatus
    func snippetForGetClusterStatus() async throws {
        // >SEPARATOR getClusterStatus
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getClusterStatus(
            clusters: "c1-de"
        )
        // SEPARATOR<
    }

    /// Snippet for the getIncidents method.
    ///
    /// getIncidents
    func snippetForGetIncidents() async throws {
        // >SEPARATOR getIncidents
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getIncidents()
        // SEPARATOR<
    }

    /// Snippet for the getIndexingTime method.
    ///
    /// getIndexingTime
    func snippetForGetIndexingTime() async throws {
        // >SEPARATOR getIndexingTime
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getIndexingTime(
            clusters: "c1-de"
        )
        // SEPARATOR<
    }

    /// Snippet for the getInventory method.
    ///
    /// getInventory
    func snippetForGetInventory() async throws {
        // >SEPARATOR getInventory
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getInventory()
        // SEPARATOR<
    }

    /// Snippet for the getLatency method.
    ///
    /// getLatency
    func snippetForGetLatency() async throws {
        // >SEPARATOR getLatency
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getLatency(
            clusters: "c1-de"
        )
        // SEPARATOR<
    }

    /// Snippet for the getMetrics method.
    ///
    /// getMetrics
    func snippetForGetMetrics() async throws {
        // >SEPARATOR getMetrics
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getMetrics(
            metric: Metric.avgBuildTime,
            period: Period.minute
        )
        // SEPARATOR<
    }

    /// Snippet for the getReachability method.
    ///
    /// getReachability
    func snippetForGetReachability() async throws {
        // >SEPARATOR getReachability
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getReachability(
            clusters: "c1-de"
        )
        // SEPARATOR<
    }

    /// Snippet for the getStatus method.
    ///
    /// getStatus
    func snippetForGetStatus() async throws {
        // >SEPARATOR getStatus
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getStatus()
        // SEPARATOR<
    }
}
