---
title: API documentation guidelines
description: Guidelines for writing API documentation for Algolia's APIs.
---

To be a reliable and useful source of truth,
API documentation must be correct, clear, complete, and consistent.
To be as easy to understand as possible,
API documentation _should_ be concise, while maintaining clarity.

Use short sentences and write in the present tense.

For more general documentation guidelines,
see the [Google developer documentation style guide](https://developers.google.com/style).

For information on how to structure spec files to support a new API client,
see [Add a new API client](/docs/add-a-new-language).

## Prefer plain text

The `description` properties of OpenAPI objects support [CommonMark](https://commonmark.org/),
but the specs are used in contexts where Markdown isn't supported.

To make using the specs in these contexts easier, follow these guidelines:

- Don't use HTML.
- Don't use tables.
- Don't use headings, except in [API descriptions](#api-descriptions).
- Prefer using `externalDocs` objects over inline Markdown links.
- Use inline Markdown links judiciously.
  They don't render in CLI/code environments.
  - Don't link to readily searchable information, such as internet RFCs or Wikipedia.
  - Don't link to endpoints of other Algolia APIs. These links won't be portable.

### Markdown in long descriptions

Operations and parameters may need more information that can fit in one sentence.
In that case, split your descriptions into two or more paragraphs:

```yaml
description: |
  First sentence as short description (no markdown, just plain text).

  More information in separate paragraphs after an empty line.
  You can use **Markdown** here.
```

Use the `|` character to write multi-line descriptions.

The first sentence can be used as a _short description_ in environments that don't support Markdown,
such as the [Algolia CLI](https://github.com/algolia/cli/).
After an empty line, you can provide more context.

## Capitalization

In general, follow the capitalization of the API.
For example, keys in JSON objects are case-sensitive.

Pay special attention to abbreviations like `taskID` vs `taskId`,
because the Algolia APIs capitalize them inconsistently.

For case-insensitive properties, follow these conventions.

### Headers

When describing headers, such as the authentication headers `x-algolia-application-id`, prefer lowercase letters.

### Path and query parameters

Use _camelCase_ for parameters, such as `indexName`.
Use uppercase abbreviations for parameters like `objectID` or `taskID`.

## API descriptions

Each API spec must include a `description` property in its `info` object.
In the first sentence, describe what the API does or what it can be used for.

After the introductory sentence, include the following sections.
Use `h2` headings.

For consistent documentation of each API,
use the same wording as the listed example API.

### Client libraries

For APIs with clients that implement the retry strategy,
the documentation must mention that to be covered by Algolia's SLA,
users must use the API clients.

**Example:** [Search API](https://www.algolia.com/doc/rest-api/search#section/Client-libraries)

### Base URLs

All APIs must list the base URLs for making requests.
If there are multiple base URLs, help users choose by providing guidance and explanations.

**Example:** [Search API](https://www.algolia.com/doc/rest-api/search#section/Base-URLs)

### Retry strategy

For APIs with clients that implement the retry strategy,
the documentation must explain the retry strategy.

**Example:** [Search API](https://www.algolia.com/doc/rest-api/search#section/Base-URLs)

### Availability and authentication

For APIs that require a specific pricing plan (usually a Premium plan),
or an add-on to the regular Algolia subscription,
include an _Availability and authentication_ section.

For APIs that are available to every Algolia subscription, see [Authentication](#authentication).

**Example:** [Analytics API](https://www.algolia.com/doc/rest-api/analytics#section/Availability-and-authentication)

### Authentication

For APIs with requests that require authentication,
describe the authentication method and where to find the credentials.

For APIs that require a specific Algolia plan, see [Availability and authentication](#availability-and-authentication).

**Example:** [Search API](https://www.algolia.com/doc/rest-api/search#section/Authentication)

### Rate limits

For APIs with rate limits per request,
describe what the rate limits are and how to check the current rate limits,
usually with response headers.

**Example:** [Analytics API](https://www.algolia.com/doc/rest-api/analytics#section/Rate-limits)

### Request format

If the API has `POST`, `PUT`, or `PATCH` requests that require request bodies,
explain what the expected format is.
Omit this section if the API only has `GET` or `DELETE` requests.

**Example:** [Search API](https://www.algolia.com/doc/rest-api/search#section/Request-format)

### Parameters

If the API accepts query or path parameters,
explain what their expected format is.
Omit this section if the API doesn't use query or path parameters.

**Example:** [Search API](https://www.algolia.com/doc/rest-api/search#section/Parameters)

### Response status and errors

Explain the response format, status codes, and error messages.

### Version

State the current version of the API and how to determine it.

## Operation summaries

Operations are endpoints combined with an HTTP verb.
Each operation must have a `summary` property.
Start with an imperative verb and describe what the operation does in 2 to 3 words.

**Examples:**

- Delete an index
- List indices
- Send events

For common operations, use these verbs consistently:

- **Search**. For `/search` endpoints (records, rules, synonyms, etc.).
- **List**. For operations that return many or all instances of an object.
- **Retrieve**. For operations that return one instance of an object.
- **Update**. For operations that update parts of an object without completely replacing it.
- **Replace**. For operations that replace entire objects.

## Operation descriptions

Each operation must have a `description` property.
Omit the subject and start with a verb in third-person in the present tense.
Describe what the operation does.
In many cases, this repeats what is written in the summary,
but you can expand it.

**Examples:**

- Deletes an index and all its settings ...
- Lists all indices in the current Algolia application ...
- Sends a list of events to the Insights API ...

Add paragraphs with more information that users might need when using this endpoint,
such as limitations, side effects, or any other information that can't be expressed in the schema.

## Properties and parameter descriptions

Use a noun phrase to describe what the parameter represents, without articles.

**Examples:**

- `disableTypoToleranceOnAttributes`: Attributes for which you want to turn off typo-tolerance.
- `maxHitsPerQuery`: Maximum number of API requests allowed per IP address or user token per hour.

### Boolean parameters

Start the description with the word _whether_ and describe what the effect of this parameter is.
If it's clearer, you can add _if true..._ and _if false..._ to explicitly state the consequences of each value.
Don't use _whether or not_.
Use regular font for the literal values _true_ and _false_ (instead of code font).

**Example:**

- `advancedSyntax`: Whether to support phrase matching and excluding words from search queries.

### Dates and timestamps

Don't use the `format` specifier for dates and timestamps.

<details>
<summary>Why not?</summary>

If you include `format: date` or `format: date-time`,
the generated code expects formatted date or time objects as input instead of simple strings.
Strings are straightforward to enter, while date and time objects need to be constructed.

</details>

Instead, include the expected format in the description and provide examples.

To help users distinguish between dates (strings) and timestamps (integers),
use the following terms consistently:

- Use **Date and time** for dates in [RFC 3339](https://datatracker.ietf.org/doc/html/rfc3339) (ISO 8601) format.
- Use **Timestamp** for timestamps in seconds or milliseconds since the [Unix epoch](https://en.wikipedia.org/wiki/Unix_time).

#### Example: date and time

Use _Date and time ..., in RFC 3339 format_.
Don't link to the RFC, and don't use ISO 8601.
Don't use _timestamp_ for dates and times.

```
createdAt:
  type: string
  description: Date and time when the object was created, in RFC 3339 format.
  example: 2024-04-06T08:08:08Z
```

<details>
<summary>RFC 3339 vs ISO 8601</summary>

RFC 3339 is slightly less ambiguous than ISO 8601 and leads to more readable dates.
Since RFC 3339 is a _profile_ of ISO 8601,
every RFC 3339 date also complies with ISO 8601,
but not every ISO 8601 date complies with RFC 3339.

For example, `2024-04-06T00:00:00` conforms to both RFC 3339 and ISO 8601.
But `20240406T000000` only conforms to ISO 8601, which allows omitting the `-` and `:` separators.

**Exception:** ISO 8601 requires date and time to be separated by `T`,
whereas RFC 3339 permits a space character for the sake of readability.
It's best to avoid this ambiguity.

</details>

#### Example: timestamp

Use _Timestamp ..., measured in milliseconds since the Unix epoch_.
Don't use _Unix time_ or _Unix epoch time_.

```
createdAtTimestamp:
  type: integer
  format: int64
  description: Timestamp when the object was created, measured in milliseconds since the Unix epoch.
  example: 1656345570000
```
