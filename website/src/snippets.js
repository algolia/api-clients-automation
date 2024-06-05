export function waitForTaskSnippet(language) {
  return {
    'csharp': 'await client.WaitForTaskAsync("<SOURCE_INDEX_NAME>", response.TaskID);',
    'dart': "await client.waitTask('<SOURCE_INDEX_NAME>', response.taskID);",
    'go': `taskResponse, err := searchClient.WaitForTask("<SOURCE_INDEX_NAME>", response.TaskID, nil, nil, nil)
if err != nil {
  panic(err)
}`,
    'java': 'client.waitForTask("<SOURCE_INDEX_NAME>", response.getTaskID());',
    'javascript': "await client.waitForTask({ indexName: '<SOURCE_INDEX_NAME>', taskID: response.taskID });",
    'kotlin': 'client.waitTask("<SOURCE_INDEX_NAME>", response.taskID)',
    'php': "$client->waitForTask('<SOURCE_INDEX_NAME>', $response['taskID']);",
    'python': 'await client.wait_for_task(index_name="<SOURCE_INDEX_NAME>", task_id=response.task_id)',
    'ruby': 'client.wait_for_task("<SOURCE_INDEX_NAME>", response.task_id)',
    'scala': 'client.waitTask("<SOURCE_INDEX_NAME>", response.getTaskID())',
    'swift': 'try await client.waitForTask(with: response.taskID, in: "<SOURCE_INDEX_NAME>")'
  }[language];
}
