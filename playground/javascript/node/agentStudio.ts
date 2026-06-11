import { ApiError } from '@algolia/client-common';
import { agentStudioClient } from '@algolia/agent-studio';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_ADMIN_KEY || '**** ADMIN_KEY *****';

// Init client with appId and apiKey
const client = agentStudioClient(appId, apiKey);

async function testAgentStudio() {
  try {
    const response = await client.listAgents();

    console.log('List of agents:');
    for (const agent of response.data) {
      console.log(`- ${agent.name} (ID: ${agent.id})`);
    }
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace);
    }

    console.log('[ERROR]', e);
  }
}

testAgentStudio();
