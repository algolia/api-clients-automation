import Tabs from '@theme/Tabs';
import React from 'react';

export const languagesTabValues = [
  { label: 'JavaScript', value: 'javascript' },
  { label: 'PHP', value: 'php' },
  { label: 'Java', value: 'java' },
  { label: 'Kotlin', value: 'kotlin' },
  { label: 'Dart', value: 'dart' },
  { label: 'Go', value: 'go' },
  { label: 'Python', value: 'python' },
  { label: 'Scala', value: 'scala' },
  { label: 'C#', value: 'csharp' },
];

export function TabsLanguage(props) {
  return (
    <Tabs groupId="language" defaultValue="javascript" values={props.values}>
      {props.children}
    </Tabs>
  );
}

TabsLanguage.defaultProps = {
  values: languagesTabValues,
};
