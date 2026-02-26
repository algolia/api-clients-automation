from os import environ
from asyncio import run

from algoliasearch.agent_studio.client import AgentStudioClient
from dotenv import load_dotenv

load_dotenv("../.env")


async def main():
    client = AgentStudioClient(
        environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY"), "us"
    )

    print("client initialized", client)

    try:
        response = await client.list_agents()

        print("List of agents:")
        for agent in response.data:
            print(f"- {agent.name} (ID: {agent.id})")
    finally:
        await client.close()

        print("client closed", client)


run(main())
