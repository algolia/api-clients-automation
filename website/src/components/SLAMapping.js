import React from 'react';

import useBaseUrl from '@docusaurus/useBaseUrl';

import { languagesTabValues } from './TabsLanguage';

export function SLAMapping() {
  return (
    <>
      {languagesTabValues.map((languageTabValues) => (
        <div>
          <h2>{languageTabValues.label}</h2>
          <img src={useBaseUrl(`/img/${languageTabValues.value}-sla.png`)} />
        </div>
      ))}
    </>
  )
}
