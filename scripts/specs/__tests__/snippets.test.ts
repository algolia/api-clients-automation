import { describe, expect, it } from 'vitest';

import { parseCodeSamples } from '../snippets.js';
import { CodeSamples } from '../types.js';

describe('init', () => {
  it('parses a multi line import', () => {
    expect(
      JSON.stringify(
        parseCodeSamples({
          foo: {
            default: `
          // Initialize the client
var client = new QuerySuggestionsClient(
  new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
);

// Call the API
var response = await client.CreateConfigAsync(
  new ConfigurationWithIndex
  {
    IndexName = "<YOUR_INDEX_NAME>",
    SourceIndices = new List<SourceIndex>
    {
      new SourceIndex
      {
        IndexName = "<YOUR_INDEX_NAME>",
        Facets = new List<Facet> { new Facet { Attribute = "test" } },
        Generate = new List<List<string>>
        {
          new List<string> { "facetA", "facetB" },
          new List<string> { "facetC" },
        },
      },
    },
    Languages = new Languages(new List<string> { "french" }),
    Exclude = new List<string> { "test" },
  }
);
// >LOG
          `,
          },
        } as unknown as CodeSamples),
        null,
        2,
      ),
    ).toMatchInlineSnapshot(`
      "{
        "foo": {
          "default": "\\n          // Initialize the client\\nvar client = new QuerySuggestionsClient(\\n  new QuerySuggestionsConfig(\\"YOUR_APP_ID\\", \\"YOUR_API_KEY\\", \\"YOUR_APP_ID_REGION\\")\\n);\\n\\n// Call the API\\nvar response = await client.CreateConfigAsync(\\n  new ConfigurationWithIndex\\n  {\\n    IndexName = \\"<YOUR_INDEX_NAME>\\",\\n    SourceIndices = new List<SourceIndex>\\n    {\\n      new SourceIndex\\n      {\\n        IndexName = \\"<YOUR_INDEX_NAME>\\",\\n        Facets = new List<Facet> { new Facet { Attribute = \\"test\\" } },\\n        Generate = new List<List<string>>\\n        {\\n          new List<string> { \\"facetA\\", \\"facetB\\" },\\n          new List<string> { \\"facetC\\" },\\n        },\\n      },\\n    },\\n    Languages = new Languages(new List<string> { \\"french\\" }),\\n    Exclude = new List<string> { \\"test\\" },\\n  }\\n);\\n// >LOG\\n          "
        }
      }"
    `);
  });

  it('parses a single line import', () => {
    expect(
      JSON.stringify(
        parseCodeSamples({
          foo: {
            default: `
          // Initialize the client
var client = new QuerySuggestionsClient(new Client("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

// Call the API
var response = await client.CreateConfigAsync(
  new ConfigurationWithIndex
  {
    IndexName = "<YOUR_INDEX_NAME>",
    SourceIndices = new List<SourceIndex>
    {
      new SourceIndex
      {
        IndexName = "<YOUR_INDEX_NAME>",
        Facets = new List<Facet> { new Facet { Attribute = "test" } },
        Generate = new List<List<string>>
        {
          new List<string> { "facetA", "facetB" },
          new List<string> { "facetC" },
        },
      },
    },
    Languages = new Languages(new List<string> { "french" }),
    Exclude = new List<string> { "test" },
  }
);
// >LOG
          `,
          },
        } as unknown as CodeSamples),
        null,
        2,
      ),
    ).toMatchInlineSnapshot(`
      "{
        "foo": {
          "default": "\\n          // Initialize the client\\nvar client = new QuerySuggestionsClient(new Client(\\"YOUR_APP_ID\\", \\"YOUR_API_KEY\\", \\"YOUR_APP_ID_REGION\\"));\\n\\n// Call the API\\nvar response = await client.CreateConfigAsync(\\n  new ConfigurationWithIndex\\n  {\\n    IndexName = \\"<YOUR_INDEX_NAME>\\",\\n    SourceIndices = new List<SourceIndex>\\n    {\\n      new SourceIndex\\n      {\\n        IndexName = \\"<YOUR_INDEX_NAME>\\",\\n        Facets = new List<Facet> { new Facet { Attribute = \\"test\\" } },\\n        Generate = new List<List<string>>\\n        {\\n          new List<string> { \\"facetA\\", \\"facetB\\" },\\n          new List<string> { \\"facetC\\" },\\n        },\\n      },\\n    },\\n    Languages = new Languages(new List<string> { \\"french\\" }),\\n    Exclude = new List<string> { \\"test\\" },\\n  }\\n);\\n// >LOG\\n          "
        }
      }"
    `);
  });
});

describe('initialize', () => {
  it("doesn't stop at `client`", () => {
    expect(
      JSON.stringify(
        parseCodeSamples({
          foo: {
            default: `
          // Initialize the client foo bar BAAAAAAAAAAAAAAAAAAAAAZ
var client = new QuerySuggestionsClient(
  new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
);

// Call the API
var response = await client.CreateConfigAsync(
  new ConfigurationWithIndex
  {
    IndexName = "<YOUR_INDEX_NAME>",
    SourceIndices = new List<SourceIndex>
    {
      new SourceIndex
      {
        IndexName = "<YOUR_INDEX_NAME>",
        Facets = new List<Facet> { new Facet { Attribute = "test" } },
        Generate = new List<List<string>>
        {
          new List<string> { "facetA", "facetB" },
          new List<string> { "facetC" },
        },
      },
    },
    Languages = new Languages(new List<string> { "french" }),
    Exclude = new List<string> { "test" },
  }
);
// >LOG
          `,
          },
        } as unknown as CodeSamples),
        null,
        2,
      ),
    ).toMatchInlineSnapshot(`
      "{
        "foo": {
          "default": "\\n          // Initialize the client foo bar BAAAAAAAAAAAAAAAAAAAAAZ\\nvar client = new QuerySuggestionsClient(\\n  new QuerySuggestionsConfig(\\"YOUR_APP_ID\\", \\"YOUR_API_KEY\\", \\"YOUR_APP_ID_REGION\\")\\n);\\n\\n// Call the API\\nvar response = await client.CreateConfigAsync(\\n  new ConfigurationWithIndex\\n  {\\n    IndexName = \\"<YOUR_INDEX_NAME>\\",\\n    SourceIndices = new List<SourceIndex>\\n    {\\n      new SourceIndex\\n      {\\n        IndexName = \\"<YOUR_INDEX_NAME>\\",\\n        Facets = new List<Facet> { new Facet { Attribute = \\"test\\" } },\\n        Generate = new List<List<string>>\\n        {\\n          new List<string> { \\"facetA\\", \\"facetB\\" },\\n          new List<string> { \\"facetC\\" },\\n        },\\n      },\\n    },\\n    Languages = new Languages(new List<string> { \\"french\\" }),\\n    Exclude = new List<string> { \\"test\\" },\\n  }\\n);\\n// >LOG\\n          "
        }
      }"
    `);
  });
});
