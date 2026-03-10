import { ApiError } from '@algolia/client-common';
import { agentStudioClient } from '@algolia/agent-studio';

// ─── Config ─────────────────────────────────────────────────────────────────
const appId = process.env.ALGOLIA_APPLICATION_ID || '';
const apiKey = process.env.ALGOLIA_ADMIN_KEY || '';

if (!appId || !apiKey) {
  console.error('[FATAL] ALGOLIA_APPLICATION_ID and ALGOLIA_ADMIN_KEY must be set in playground/.env');
  process.exit(1);
}

console.log(`[CONFIG] appId=${appId}`);
console.log(`[CONFIG] apiKey=${apiKey.slice(0, 6)}...`);

const client = agentStudioClient(appId, apiKey, 'us');

// The generated JS clients set 'content-type: text/plain' by default, which works
// for traditional Algolia APIs but agent-studio (FastAPI) requires 'application/json'.
const jsonHeaders = { headers: { 'content-type': 'application/json' } };

let createdAgentId: string | undefined;

async function testStreaming() {
  try {
    // 1. Find a provider to use
    console.log('\n─── Step 1: Finding a provider ───');
    const providersResponse = await client.listProviders();
    console.log(`[PROVIDERS] Found ${providersResponse.data.length} provider(s):`);
    for (const p of providersResponse.data) {
      console.log(`  - ${p.name} (ID: ${p.id})`);
    }

    if (providersResponse.data.length === 0) {
      console.error('[FATAL] No providers found. Configure one first.');
      return;
    }

    const provider = providersResponse.data[0];
    console.log(`\n[SELECTED] Using provider: "${provider.name}" (${provider.id})`);

    // 2. Create a temporary agent with the provider
    console.log('\n─── Step 2: Creating temporary agent ───');
    const agent = await client.createAgent({
        name: `streaming-test-${Date.now()}`,
        instructions: 'You are a helpful assistant. Keep your answers short and concise.',
        providerId: provider.id,
        model: 'gpt-4.1-mini',
      },
      jsonHeaders,
    );
    createdAgentId = agent.id;
    console.log(`[CREATED] Agent "${agent.name}" (ID: ${agent.id})`);
    console.log(`[CREATED] Status: ${agent.status}`);

    // Publish the agent so it can serve completions
    console.log('[PUBLISH] Publishing agent...');
    await client.publishAgent({ agentId: agent.id }, jsonHeaders);
    console.log('[PUBLISH] Agent published');

    // 3. Call the streaming endpoint
    console.log('\n─── Step 3: Calling createAgentCompletionStream ───');
    console.log('[REQUEST] Sending message: "Hello, what can you do?"');
    console.log('[REQUEST] compatibilityMode: "ai-sdk-5"');
    console.log('[REQUEST] stream: true');

    const startTime = Date.now();
    let eventCount = 0;

    const stream = client.createAgentCompletionStream({
        agentId: agent.id,
        compatibilityMode: 'ai-sdk-5',
        stream: true,
        agentCompletionRequest: {
          messages: [
            {
              role: 'user',
              parts: [{ type: 'text', text: 'Hello, what can you do? Keep it short.' }],
            },
          ],
        },
      },
      jsonHeaders,
    );

    console.log('[STREAM] Stream object created, iterating events...\n');

    // 4. Iterate over SSE events (typed: StreamEvent<AgentCompletionResponse>)
    console.log('─── Step 4: Receiving SSE events ───');
    for await (const event of stream) {
      eventCount++;
      const elapsed = ((Date.now() - startTime) / 1000).toFixed(2);

      console.log(`\n[EVENT #${eventCount}] (t+${elapsed}s)`);
      console.log(`  event: "${event.raw.event}"`);
      console.log(`  id:    "${event.raw.id}"`);

      if (event.error) {
        console.log(`  [PARSE ERROR] ${event.error.message}`);
        console.log(`  [RAW DATA] ${event.raw.data.slice(0, 200)}`);
      } else if (event.data) {
        console.log(`  [TYPED DATA] keys=[${Object.keys(event.data).join(', ')}]`);
      }
    }

    const totalTime = ((Date.now() - startTime) / 1000).toFixed(2);
    console.log(`\n─── Done ───`);
    console.log(`[SUMMARY] Received ${eventCount} events in ${totalTime}s`);
  } catch (e) {
    if (e instanceof ApiError) {
      console.error(`\n[API ERROR] [${e.status}] ${e.message}`);
      console.error('[STACK]', e.stackTrace);
      return;
    }

    console.error('\n[ERROR]', e);
  } finally {
    // 5. Teardown: delete the temporary agent
    if (createdAgentId) {
      console.log(`\n─── Teardown ───`);
      try {
        await client.deleteAgent({ agentId: createdAgentId }, jsonHeaders);
        console.log(`[DELETED] Agent ${createdAgentId}`);
      } catch (e) {
        console.error(`[TEARDOWN ERROR] Failed to delete agent ${createdAgentId}:`, e);
      }
    }
  }
}

testStreaming();
