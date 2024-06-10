import React from 'react';
import CodeBlock from '@theme/CodeBlock';
import TabItem from '@theme/TabItem';
import { languagesTabValues, TabsLanguage } from './TabsLanguage';
import { addComment, getSnippet, waitForTaskSnippet, waitForApiKeySnippet } from '../snippets';

export function CodeBlockLanguage(props) {
  return <TabsLanguage>
    {languagesTabValues.map((languageTabValue) => {
      const language = languageTabValue.value;
      return (
        <TabItem value={language}>
          <CodeBlock language={language}>
            {props.snippet({
              getSnippet: (...args) => getSnippet(language, props.client || 'search', ...args),
              addComment: (comment) => addComment(language, comment),
              waitForTaskSnippet: (indexName = '<YOUR_INDEX_NAME>') => waitForTaskSnippet(language, indexName),
              waitForApiKeySnippet: (operation) => waitForApiKeySnippet(language, operation),
              language,
            })}
          </CodeBlock>
        </TabItem>
      )
    })}
  </TabsLanguage>;
}
