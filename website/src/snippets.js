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
  switch (language) {
    case 'csharp':
    case 'dart':
    case 'go':
    case 'java':
    case 'javascript':
    case 'kotlin':
    case 'php':
    case 'python':
    case 'ruby':
    case 'scala':
    case 'swift':
  }
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
  return getSnippetsForClient(client)?.[language]?.[operationID]?.[name] || '';
}
