import AnyCodable

import Core
import Monitoring

final class MonitoringClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customDelete(
            path: "/test/minimal"
        )
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customGet(
            path: "/test/minimal"
        )
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customPost(
            path: "/test/minimal"
        )
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
    }

    /// Snippet for the getClusterIncidents method.
    ///
    /// getClusterIncidents
    func snippetForGetClusterIncidents() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getClusterIncidents(
            clusters: "c1-de"
        )
    }

    /// Snippet for the getClusterStatus method.
    ///
    /// getClusterStatus
    func snippetForGetClusterStatus() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getClusterStatus(
            clusters: "c1-de"
        )
    }

    /// Snippet for the getIncidents method.
    ///
    /// getIncidents
    func snippetForGetIncidents() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getIncidents()
    }

    /// Snippet for the getIndexingTime method.
    ///
    /// getIndexingTime
    func snippetForGetIndexingTime() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getIndexingTime(
            clusters: "c1-de"
        )
    }

    /// Snippet for the getInventory method.
    ///
    /// getInventory
    func snippetForGetInventory() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getInventory()
    }

    /// Snippet for the getLatency method.
    ///
    /// getLatency
    func snippetForGetLatency() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getLatency(
            clusters: "c1-de"
        )
    }

    /// Snippet for the getMetrics method.
    ///
    /// getMetrics
    func snippetForGetMetrics() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getMetrics(
            metric: Metric.avgBuildTime,
            period: Period.minute
        )
    }

    /// Snippet for the getReachability method.
    ///
    /// getReachability
    func snippetForGetReachability() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getReachability(
            clusters: "c1-de"
        )
    }

    /// Snippet for the getStatus method.
    ///
    /// getStatus
    func snippetForGetStatus() async throws {
        // Initialize the client
        let client = try MonitoringClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getStatus()
    }
}
