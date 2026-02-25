package com.algolia.playground

import com.algolia.client.api.AgentStudioClient
import io.github.cdimascio.dotenv.Dotenv
import kotlin.system.exitProcess

suspend fun main() {
    val dotenv = Dotenv.configure().directory("../").load()

    val client = AgentStudioClient(
        appId = dotenv["ALGOLIA_APPLICATION_ID"],
        apiKey = dotenv["ALGOLIA_ADMIN_KEY"],
    )

    val response = client.listAgents()
    println("List of agents:")
    for (agent in response.agents) {
        println("- ${agent.name} (ID: ${agent.id})")
    }

    exitProcess(0)
}
