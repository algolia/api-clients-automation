import { describe, expect, it } from 'vitest';

import { transformCodeSamplesToGuideMethods } from '../snippets.js';
import { SnippetSamples } from '../types.js';

describe('init', () => {
  it('parses a multi line import', () => {
    expect(
      JSON.parse(
        transformCodeSamplesToGuideMethods({
          csharp: {
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
          },
        } as unknown as SnippetSamples),
      ),
    ).toMatchInlineSnapshot(`
      {
        "csharp": {
          "foo": {
            "default": "var response = await client.CreateConfigAsync(
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
      );",
          },
          "init": {
            "default": "var client = new QuerySuggestionsClient(
        new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
      );",
          },
        },
      }
    `);
  });

  it('parses a single line import', () => {
    expect(
      JSON.parse(
        transformCodeSamplesToGuideMethods({
          csharp: {
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
          },
        } as unknown as SnippetSamples),
      ),
    ).toMatchInlineSnapshot(`
      {
        "csharp": {
          "foo": {
            "default": "var response = await client.CreateConfigAsync(
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
      );",
          },
          "init": {
            "default": "var client = new QuerySuggestionsClient(new Client("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));",
          },
        },
      }
    `);
  });
});

describe('initialize', () => {
  it("doesn't stop at `client`", () => {
    expect(
      JSON.parse(
        transformCodeSamplesToGuideMethods({
          csharp: {
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
          },
        } as unknown as SnippetSamples),
      ),
    ).toMatchInlineSnapshot(`
      {
        "csharp": {
          "foo": {
            "default": "var response = await client.CreateConfigAsync(
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
      );",
          },
          "init": {
            "default": "var client = new QuerySuggestionsClient(
        new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
      );",
          },
        },
      }
    `);
  });
});
