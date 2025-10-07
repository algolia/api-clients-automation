import { algoliasearch } from 'algoliasearch';

import type { Rule } from 'algoliasearch';

const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

const objectID = 'a-rule-id';

const rule: Rule = {
  objectID,
  consequence: {
    // Set relevant consequence
  },
};

// Set validity (optional)
rule.validity = [
  {
    from: 1688774400,
    until: 1738972800,
  },
];

await client.saveRule({ indexName: 'indexName', objectID: objectID, rule: rule });
