import { describe, expect, it } from 'vitest';

import { generateSnippetsJSON } from '../snippets.ts';
import type { CodeSamples } from '../types.ts';

describe('init', () => {
  it('parses a multi line init', () => {
    expect(
      JSON.stringify(
        generateSnippetsJSON({
          csharp: {
            ope: {
              default: `
          // Initialize the client
var client = new QuerySuggestionsClient(
  new QuerySuggestionsConfig(
    "ALGOLIA_APPLICATION_ID",
    "ALGOLIA_API_KEY",
    "ALGOLIA_APPLICATION_REGION"
  )
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
// print the response
Console.WriteLine(response);
          `,
            },
          },
        } as unknown as CodeSamples),
        null,
        2,
      ),
    ).toMatchInlineSnapshot(`
      "{
        "csharp": {
          "ope": {
            "default": "var response = await client.CreateConfigAsync(\\n  new ConfigurationWithIndex\\n  {\\n    IndexName = \\"<YOUR_INDEX_NAME>\\",\\n    SourceIndices = new List<SourceIndex>\\n    {\\n      new SourceIndex\\n      {\\n        IndexName = \\"<YOUR_INDEX_NAME>\\",\\n        Facets = new List<Facet> { new Facet { Attribute = \\"test\\" } },\\n        Generate = new List<List<string>>\\n        {\\n          new List<string> { \\"facetA\\", \\"facetB\\" },\\n          new List<string> { \\"facetC\\" },\\n        },\\n      },\\n    },\\n    Languages = new Languages(new List<string> { \\"french\\" }),\\n    Exclude = new List<string> { \\"test\\" },\\n  }\\n);"
          },
          "init": {
            "default": "var client = new QuerySuggestionsClient(\\n  new QuerySuggestionsConfig(\\n    \\"ALGOLIA_APPLICATION_ID\\",\\n    \\"ALGOLIA_API_KEY\\",\\n    \\"ALGOLIA_APPLICATION_REGION\\"\\n  )\\n);"
          }
        }
      }"
    `);
  });

  it('parses a single line init', () => {
    expect(
      JSON.stringify(
        generateSnippetsJSON({
          csharp: {
            ope: {
              default: `
          // Initialize the client
var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"));

// Call the API
var response = await client.CreateConfigAsync();
// >LOG
// print the response
Console.WriteLine(response);
          `,
            },
          },
        } as unknown as CodeSamples),
        null,
        2,
      ),
    ).toMatchInlineSnapshot(`
      "{
        "csharp": {
          "ope": {
            "default": "var response = await client.CreateConfigAsync();"
          },
          "init": {
            "default": "var client = new QuerySuggestionsClient(new QuerySuggestionsConfig(\\"ALGOLIA_APPLICATION_ID\\", \\"ALGOLIA_API_KEY\\", \\"ALGOLIA_APPLICATION_REGION\\"));"
          }
        }
      }"
    `);
  });
});

describe('initialize', () => {
  it("doesn't stop at `client`", () => {
    expect(
      JSON.stringify(
        generateSnippetsJSON({
          csharp: {
            ope: {
              default: `
          // Initialize the client foo bar BAAAAAAAAAAAAAAAAAAAAAZ
var client = new QuerySuggestionsClient(
  new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
);

// Call the API
var response = await client.CreateConfigAsync();
// >LOG
// print the response
Console.WriteLine(response);
          `,
            },
          },
        } as unknown as CodeSamples),
        null,
        2,
      ),
    ).toMatchInlineSnapshot(`
      "{
        "csharp": {
          "ope": {
            "default": "var response = await client.CreateConfigAsync();"
          },
          "init": {
            "default": "var client = new QuerySuggestionsClient(\\n  new QuerySuggestionsConfig(\\"YOUR_APP_ID\\", \\"YOUR_API_KEY\\", \\"YOUR_APP_ID_REGION\\")\\n);"
          }
        }
      }"
    `);
  });
});
