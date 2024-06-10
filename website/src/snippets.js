import { snippets as abtestingSnippets } from './generated/abtesting-snippets';
import { snippets as analyticsSnippets } from './generated/analytics-snippets';
import { snippets as ingestionSnippets } from './generated/ingestion-snippets';
import { snippets as insightsSnippets } from './generated/insights-snippets';
import { snippets as monitoringSnippets } from './generated/monitoring-snippets';
import { snippets as personalizationSnippets } from './generated/personalization-snippets';
import { snippets as querySuggestionsSnippets } from './generated/query-suggestions-snippets';
import { snippets as recommendSnippets } from './generated/recommend-snippets';
import { snippets as searchSnippets } from './generated/search-snippets';
import { snippets as usageSnippets } from './generated/usage-snippets';

export function waitForTaskSnippet(language, indexName = 'YOUR_INDEX_NAME') {
  return {
    'csharp': `await client.WaitForTaskAsync("${indexName}", response.TaskID);`,
    'dart': `await client.waitTask('${indexName}', response.taskID);`,
    'go': `taskResponse, err := searchClient.WaitForTask("${indexName}", response.TaskID, nil, nil, nil)
if err != nil {
  panic(err)
}`,
    'java': `client.waitForTask("${indexName}", response.getTaskID());`,
    'javascript': `await client.waitForTask({ indexName: '${indexName}', taskID: response.taskID });`,
    'kotlin': `client.waitTask("${indexName}", response.taskID)`,
    'php': `$client->waitForTask('${indexName}', $response['taskID']);`,
    'python': `await client.wait_for_task(index_name="${indexName}", task_id=response.task_id)`,
    'ruby': `client.wait_for_task("${indexName}", response.task_id)`,
    'scala': `client.waitTask("${indexName}", response.getTaskID())`,
    'swift': `try await client.waitForTask(with: response.taskID, in: "${indexName}")`,
  }[language];
}

export function waitForApiKeySnippet(language, operation) {
  return {
    'csharp': {
      'add': `await client.WaitForApiKeyAsync(ApiKeyOperation.Add, response.Key);`,
      'update': `await client.WaitForApiKeyAsync(ApiKeyOperation.Update, response.Key);`,
      'delete': `await client.WaitForApiKeyAsync(ApiKeyOperation.Delete, response.Key);`,
    },
    'dart': {
      'add': ``,
      'update': ``,
      'delete': ``,
    },
    'go': {
      'add': `waitResponse, err := client.WaitForApiKey(search.APIKEYOPERATION_ADD, response.Key, nil)
if err != nil {
  panic(err)
}`,
      'update': `waitResponse, err := client.WaitForApiKey(search.APIKEYOPERATION_UPDATE, response.Key, nil)
if err != nil {
  panic(err)
}`,
      'delete': `waitResponse, err := client.WaitForApiKey(search.APIKEYOPERATION_DELETE, response.Key, nil)
if err != nil {
  panic(err)
}`,
    },
    'java': {
      'add': `client.waitForApiKey(ApiKeyOperation.ADD, response.Key, null)`,
      'update': `client.waitForApiKey(ApiKeyOperation.UPDATE, response.Key, null)`,
      'delete': `client.waitForApiKey(ApiKeyOperation.DELETE, response.Key, null)`,
    },
    'javascript': {
      'add': `await client.waitForApiKey({ operation: "${operation}", key: response.key });`,
      'update': `await client.waitForApiKey({ operation: "${operation}", key: response.key, apiKey: null });`,
      'delete': `await client.waitForApiKey({ operation: "${operation}", key: response.key });`,
    },
    'kotlin': {
      'add': ``,
      'update': ``,
      'delete': ``,
    },
    'php': {
      'add': `$client->waitForApiKey('${operation}', $response['key']);`,
      'update': `$client->waitForApiKey('${operation}', $response['key'], null);`,
      'delete': `$client->waitForApiKey('${operation}', $response['key']);`,
    },
    'python': {
      'add': `await client.wait_for_api_key(operation="${operation}", key=response.key)`,
      'update': `await client.wait_for_api_key(operation="${operation}", key=response.key, api_key=None)`,
      'delete': `await client.wait_for_api_key(operation="${operation}", key=response.key)`,
    },
    'ruby': {
      'add': `await client.wait_for_api_key(operation="${operation}", key=response.key)`,
      'update': `await client.wait_for_api_key(operation="${operation}", key=response.key, api_key=nil)`,
      'delete': `await client.wait_for_api_key(operation="${operation}", key=response.key)`,
    },
    'scala': {
      'add': ``,
      'update': ``,
      'delete': ``,
    },
    'swift': {
      'add': `try await client.waitForApiKey(with: response.key, operation: ApiKeyOperation.add)`,
      'update': `try await client.waitForApiKey(with: response.key, operation: ApiKeyOperation.update, apiKey: nil)`,
      'delete': `try await client.waitForApiKey(with: response.key, operation: ApiKeyOperation.delete)`,
    },
  }[language][operation] || `waitForApiKey.${operation} is not implemented in ${language}`;
}

function getSnippetsForClient(client) {
  switch (client) {
    case 'abtesting':
      return abtestingSnippets;
    case 'analytics':
      return analyticsSnippets;
    case 'ingestion':
      return ingestionSnippets;
    case 'insights':
      return insightsSnippets;
    case 'monitoring':
      return monitoringSnippets;
    case 'personalization':
      return personalizationSnippets;
    case 'querySuggestions':
      return querySuggestionsSnippets;
    case 'recommend':
      return recommendSnippets;
    case 'search':
      return searchSnippets;
    case 'usage':
      return usageSnippets;
  }
}

export function getSnippet(language, client, operationID, name = 'default') {
  return getSnippetsForClient(client)?.[language]?.[operationID]?.[name] || `${client}.${operationID} is not implemented in ${language}`;
}

export function addComment(language, comment) {
  return {
    'csharp': `// ${comment}`,
    'dart': `// ${comment}`,
    'go': `// ${comment}`,
    'java': `// ${comment}`,
    'javascript': `// ${comment}`,
    'kotlin': `// ${comment}`,
    'php': `// ${comment}`,
    'python': `# ${comment}`,
    'ruby': `# ${comment}`,
    'scala': `// ${comment}`,
    'swift': `// ${comment}`,
  }[language];
}
