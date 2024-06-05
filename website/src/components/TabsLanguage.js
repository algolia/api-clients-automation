import Tabs from '@theme/Tabs';
import React from 'react';

export const languagesTabValues = [
  { label: 'C#', value: 'csharp' },
  { label: 'Dart', value: 'dart' },
  { label: 'Go', value: 'go' },
  { label: 'Java', value: 'java' },
  { label: 'JavaScript', value: 'javascript' },
  { label: 'Kotlin', value: 'kotlin' },
  { label: 'PHP', value: 'php' },
  { label: 'Python', value: 'python' },
  { label: 'Ruby', value: 'ruby' },
  { label: 'Scala', value: 'scala' },
  { label: 'Swift', value: 'swift' },
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
