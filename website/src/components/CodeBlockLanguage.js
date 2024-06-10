import React from 'react';
import CodeBlock from '@theme/CodeBlock';
import TabItem from '@theme/TabItem';
import { languagesTabValues, TabsLanguage } from './TabsLanguage';
import { addComment, getSnippet, waitForTaskSnippet } from '../snippets';

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
              waitForTaskSnippet: () => waitForTaskSnippet(language),
              language,
            })}
          </CodeBlock>
        </TabItem>
      )
    })}
  </TabsLanguage>;
}
