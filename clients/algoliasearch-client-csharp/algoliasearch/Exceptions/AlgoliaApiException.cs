using System;

namespace Algolia.Search.Exceptions;

/// <summary>
/// Exception sent by Algolia's API
/// </summary>
public class AlgoliaApiException : Exception
{
  /// <summary>
  /// Http error code
  /// </summary>
  public int HttpErrorCode { get; set; }

  /// <summary>
  /// The Correlation-ID header of the failed response, when present.
  /// Quote it when contacting Algolia support.
  /// </summary>
  public string CorrelationId { get; }

  /// <summary>
  /// Create a new AlgoliaAPIException
  /// </summary>
  /// <param name="message"></param>
  /// <param name="httpErrorCode"></param>
  public AlgoliaApiException(string message, int httpErrorCode)
    : this(message, httpErrorCode, null) { }

  /// <summary>
  /// Create a new AlgoliaAPIException carrying the Correlation-ID of the failed response
  /// </summary>
  /// <param name="message"></param>
  /// <param name="httpErrorCode"></param>
  /// <param name="correlationId"></param>
  public AlgoliaApiException(string message, int httpErrorCode, string correlationId)
    : base(correlationId == null ? message : $"{message} (Correlation-ID: {correlationId})")
  {
    HttpErrorCode = httpErrorCode;
    CorrelationId = correlationId;
  }
}
