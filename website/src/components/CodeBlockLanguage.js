import React from 'react';
import CodeBlock from '@theme/CodeBlock';
import TabItem from '@theme/TabItem';
import { languagesTabValues } from './TabsLanguage';
import { TabsLanguage } from './TabsLanguage';

export function CodeBlockLanguage(props) {
  return (<TabsLanguage>
    {languagesTabValues.map((languageTabValue) => {
      return (
        <TabItem value={languageTabValue.value}>
          <CodeBlock language={languageTabValue.value}>
        {props.snippet(languageTabValue.value)}
        </CodeBlock>
        </TabItem>
      )
    })}
    </TabsLanguage>)
}
