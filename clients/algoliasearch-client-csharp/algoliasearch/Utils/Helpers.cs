using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using System.Threading.Tasks;
using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;
using TaskStatus = Algolia.Search.Models.Search.TaskStatus;

namespace Algolia.Search.Utils
{
  /// <summary>
  /// A tool class to help with common tasks
  /// </summary>
  public static class Helpers
  {
    private const int DefaultMaxRetries = 50;

    /// <summary>
    /// Wait for a task to complete with `indexName` and `taskID`.
    /// </summary>
    /// <param name="client">Algolia Search Client instance</param>
    /// <param name="indexName">The `indexName` where the operation was performed.</param>
    /// <param name="taskId">The `taskID` returned in the method response.</param>
    /// <param name="maxRetries">The maximum number of retry. 50 by default. (optional)</param>
    /// <param name="requestOptions">The requestOptions to send along with the query, they will be merged with the transporter requestOptions. (optional)</param>
    /// <param name="ct">Cancellation token (optional)</param>
    public static async Task<GetTaskResponse> WaitForTaskAsync(this SearchClient client, string indexName, long taskId,
      int maxRetries = DefaultMaxRetries, RequestOptions requestOptions = null, CancellationToken ct = default)
    {
      return await RetryUntil(
        async () => await client.GetTaskAsync(indexName, taskId, requestOptions, ct),
        resp => resp.Status == TaskStatus.Published, maxRetries, ct).ConfigureAwait(false);
    }

    /// <summary>
    /// This function waits for the Algolia's API Key to finish
    /// </summary>
    /// <param name="client">Algolia Search Client instance</param>
    /// <param name="operation">The `operation` that was done on a `key`.</param>
    /// <param name="key">The key that has been added, deleted or updated.</param>
    /// <param name="apiKey">Necessary to know if an `update` operation has been processed, compare fields of the response with it. (optional - mandatory if operation is UPDATE)</param>
    /// <param name="maxRetries">The maximum number of retry. 50 by default. (optional)</param>
    /// <param name="requestOptions">The requestOptions to send along with the query, they will be merged with the transporter requestOptions. (optional)</param>
    /// <param name="ct">Cancellation token (optional)</param>
    public static async Task<GetApiKeyResponse> WaitForApiKeyAsync(this SearchClient client,
      ApiKeyOperation operation, string key,
      ApiKey apiKey = default, int maxRetries = DefaultMaxRetries, RequestOptions requestOptions = null,
      CancellationToken ct = default)
    {
      if (operation == ApiKeyOperation.UPDATE)
      {
        if (apiKey == null)
        {
          throw new AlgoliaException("`ApiKey` is required when waiting for an `update` operation.");
        }

        return await RetryUntil(() => client.GetApiKeyAsync(key, requestOptions, ct),
          resp =>
          {
            var apiKeyResponse = new ApiKey
            {
              Acl = resp.Acl,
              Description = resp.Description,
              Indexes = resp.Indexes,
              Referers = resp.Referers,
              Validity = resp.Validity,
              QueryParameters = resp.QueryParameters,
              MaxHitsPerQuery = resp.MaxHitsPerQuery,
              MaxQueriesPerIPPerHour = resp.MaxQueriesPerIPPerHour
            };
            return apiKeyResponse.Equals(apiKey);
          }, maxRetries: maxRetries, ct: ct).ConfigureAwait(false);
      }

      //
      // bypass lambda restriction to modify final object
      var addedKey = new GetApiKeyResponse();

      // check the status of the getApiKey method
      await RetryUntil(async () =>
        {
          try
          {
            addedKey = await client.GetApiKeyAsync(key, requestOptions, ct).ConfigureAwait(false);
            // magic number to signify we found the key
            return -2;
          }
          catch (AlgoliaApiException e)
          {
            return e.HttpErrorCode;
          }
        }, (status) =>
        {
          switch (operation)
          {
            case ApiKeyOperation.ADD:
              // stop either when the key is created or when we don't receive 404
              return status == -2 || status != 404;
            case ApiKeyOperation.DELETE:
              // stop when the key is not found
              return status == 404;
            default:
              // continue
              return false;
          }
        },
        maxRetries, ct
      );
      return addedKey;
    }

    /// <summary>
    /// Iterate on the `browse` method of the client to allow aggregating objects of an index.
    /// </summary>
    /// <param name="client"></param>
    /// <param name="indexName">The index in which to perform the request.</param>
    /// <param name="browseParams">The `browse` parameters.</param>
    /// <param name="requestOptions">The requestOptions to send along with the query, they will be forwarded to the `browse` method and merged with the transporter requestOptions.</param>
    /// <typeparam name="T">The model of the record</typeparam>
    public static async Task<IEnumerable<T>> BrowseObjects<T>(this SearchClient client, string indexName,
      BrowseParamsObject browseParams,
      RequestOptions requestOptions)
    {
      var all = await CreateIterable<BrowseResponse<T>>(async (prevResp) =>
      {
        browseParams.Cursor = prevResp?.Cursor;
        return await client.BrowseAsync<T>(indexName, new BrowseParams(browseParams), requestOptions);
      }, resp => resp != null && resp.Cursor == null).ConfigureAwait(false);

      return all.SelectMany(u => u.Hits);
    }

    /// <summary>
    /// Iterate on the `searchRules` method of the client to allow aggregating rules of an index.
    /// </summary>
    /// <param name="client"></param>
    /// <param name="indexName">The index in which to perform the request.</param>
    /// <param name="rulesParams">The `rules` parameters.</param>
    /// <param name="requestOptions">The requestOptions to send along with the query, they will be forwarded to the `browse` method and merged with the transporter requestOptions.</param>
    public static async Task<IEnumerable<Rule>> BrowseRules<T>(this SearchClient client, string indexName,
      SearchRulesParams rulesParams,
      RequestOptions requestOptions)
    {
      var all = await CreateIterable<SearchRulesResponse>(async (prevResp) =>
      {
        rulesParams.HitsPerPage = 1000;
        rulesParams.Page = prevResp != null ? prevResp.Page + 1 : rulesParams.Page ?? 0;
        return await client.SearchRulesAsync(indexName, rulesParams, requestOptions);
      }, resp => resp?.Page != null && resp.NbPages < rulesParams.HitsPerPage).ConfigureAwait(false);

      return all.SelectMany(u => u.Hits);
    }


    /// <summary>
    /// Iterate on the `SearchSynonyms` method of the client to allow aggregating rules of an index.
    /// </summary>
    /// <param name="client"></param>
    /// <param name="indexName">The index in which to perform the request.</param>
    /// <param name="rulesParams">The `rules` parameters.</param>
    /// <param name="synomymsParams"></param>
    /// <param name="requestOptions">The requestOptions to send along with the query, they will be forwarded to the `browse` method and merged with the transporter requestOptions.</param>
    /// <param name="type"></param>
    public static async Task<IEnumerable<SynonymHit>> BrowseSynonyms<T>(this SearchClient client, string indexName,
      SynonymType? type,
      SearchSynonymsParams synomymsParams,
      RequestOptions requestOptions)
    {
      const int hitPerPage = 1000;
      var all = await CreateIterable<Tuple<SearchSynonymsResponse, int>>(async (prevResp) =>
      {
        var searchSynonymsResponse = await client.SearchSynonymsAsync(indexName, type, prevResp.Item2, hitPerPage,
          synomymsParams,
          requestOptions);
        return new Tuple<SearchSynonymsResponse, int>(searchSynonymsResponse, prevResp.Item2 + 1);
      }, resp => resp?.Item1 != null && resp.Item1.NbHits < hitPerPage).ConfigureAwait(false);

      return all.SelectMany(u => u.Item1.Hits);
    }

    private static async Task<T> RetryUntil<T>(Func<Task<T>> func, Func<T, bool> validate,
      int maxRetries = DefaultMaxRetries, CancellationToken ct = default)
    {
      var retryCount = 0;
      while (retryCount < maxRetries)
      {
        var resp = await func().ConfigureAwait(false);
        if (validate(resp))
        {
          return resp;
        }

        await Task.Delay(NextDelay(retryCount), ct).ConfigureAwait(false);
        retryCount++;
      }

      throw new AlgoliaException(
        "The maximum number of retries exceeded. (" + (retryCount + 1) + "/" + maxRetries + ")");
    }

    private static int NextDelay(int retryCount)
    {
      return Math.Min(retryCount * 200, 5000);
    }

    private static async Task<List<TU>> CreateIterable<TU>(Func<TU, Task<TU>> executeQuery, Func<TU, bool> hasNext)
    {
      var responses = new List<TU>();
      var current = default(TU);
      do
      {
        var response = await executeQuery(current).ConfigureAwait(false);
        current = response;
        responses.Add(response);
      } while (hasNext(current));

      return responses;
    }
  }
}
