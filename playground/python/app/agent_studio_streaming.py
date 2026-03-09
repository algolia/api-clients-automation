import json
import time
from os import environ
from asyncio import run

from algoliasearch.agent_studio.client import AgentStudioClient
from dotenv import load_dotenv

load_dotenv("../.env")

# ─── Config ──────────────────────────────────────────────────────────────────
app_id = environ.get("ALGOLIA_APPLICATION_ID", "")
api_key = environ.get("ALGOLIA_ADMIN_KEY", "")

if not app_id or not api_key:
    print("[FATAL] ALGOLIA_APPLICATION_ID and ALGOLIA_ADMIN_KEY must be set in playground/.env")
    exit(1)

print(f"[CONFIG] appId={app_id}")
print(f"[CONFIG] apiKey={api_key[:6]}...")


async def main():
    client = AgentStudioClient(app_id, api_key, "us")
    print("[CLIENT] AgentStudioClient initialized")

    created_agent_id = None

    try:
        # 1. Find a provider to use
        print("\n─── Step 1: Finding a provider ───")
        providers_response = await client.list_providers()
        print(f"[PROVIDERS] Found {len(providers_response.data)} provider(s):")
        for p in providers_response.data:
            print(f"  - {p.name} (ID: {p.id})")

        if not providers_response.data:
            print("[FATAL] No providers found. Configure one first.")
            return

        provider = providers_response.data[0]
        print(f'\n[SELECTED] Using provider: "{provider.name}" ({provider.id})')

        # 2. Create a temporary agent with the provider
        print("\n─── Step 2: Creating temporary agent ───")
        agent = await client.create_agent(
            agent_config_create={
                "name": f"streaming-test-{int(time.time())}",
                "instructions": "You are a helpful assistant. Keep your answers short and concise.",
                "providerId": provider.id,
                "model": "gpt-4.1-mini",
            }
        )
        created_agent_id = agent.id
        print(f'[CREATED] Agent "{agent.name}" (ID: {agent.id})')
        print(f"[CREATED] Status: {agent.status}")

        # Publish the agent so it can serve completions
        print("[PUBLISH] Publishing agent...")
        await client.publish_agent(agent_id=agent.id)
        print("[PUBLISH] Agent published")

        # 3. Call the streaming endpoint
        print("\n─── Step 3: Calling create_agent_completion_stream ───")
        print('[REQUEST] Sending message: "Hello, what can you do?"')
        print("[REQUEST] compatibility_mode: ai-sdk-5")
        print("[REQUEST] stream: True")

        start_time = time.time()
        event_count = 0

        stream = client.create_agent_completion_stream(
            agent_id=agent.id,
            compatibility_mode="ai-sdk-5",
            stream=True,
            agent_completion_request={
                "messages": [
                    {
                        "role": "user",
                        "parts": [{"type": "text", "text": "Hello, what can you do? Keep it short."}],
                    }
                ],
            },
        )

        print("[STREAM] Stream object created, iterating events...\n")

        # 4. Iterate over SSE events
        print("─── Step 4: Receiving SSE events ───")
        async for event in stream:
            event_count += 1
            elapsed = f"{time.time() - start_time:.2f}"

            print(f"\n[EVENT #{event_count}] (t+{elapsed}s)")
            print(f'  event: "{event.event}"')
            print(f'  id:    "{event.id}"')
            print(f"  retry: {event.retry}")

            # Show data (truncate if too long)
            data_preview = (
                event.data[:200] + "..." if len(event.data) > 200 else event.data
            )
            print(f"  data:  {data_preview}")

            # Try to parse data as JSON
            if event.data:
                try:
                    parsed = json.loads(event.data)
                    keys = ", ".join(parsed.keys()) if isinstance(parsed, dict) else str(type(parsed).__name__)
                    print(f"  [PARSED JSON] type={type(parsed).__name__}, keys=[{keys}]")
                except (json.JSONDecodeError, ValueError):
                    print("  [RAW TEXT] (not JSON)")

        total_time = f"{time.time() - start_time:.2f}"
        print(f"\n─── Done ───")
        print(f"[SUMMARY] Received {event_count} events in {total_time}s")

    except Exception as e:
        print(f"\n[ERROR] {type(e).__name__}: {e}")
        raise
    finally:
        # 5. Teardown: delete the temporary agent
        if created_agent_id:
            print(f"\n─── Teardown ───")
            try:
                await client.delete_agent(agent_id=created_agent_id)
                print(f"[DELETED] Agent {created_agent_id}")
            except Exception as e:
                print(f"[TEARDOWN ERROR] Failed to delete agent {created_agent_id}: {e}")

        await client.close()
        print("[CLIENT] Closed")


run(main())
