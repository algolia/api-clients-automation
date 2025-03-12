import type { Condition, Consequence } from 'algoliasearch';

const condition: Condition = {
  anchoring: 'is',
  pattern: '{facet:brand}',
};

const consequence: Consequence = {
  filterPromotes: true,
};
