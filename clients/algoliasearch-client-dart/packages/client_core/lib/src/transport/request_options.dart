/// Represents options for configuring a request to an endpoint.
final class RequestOptions {
  ///  The write timeout for the request.
  final Duration? writeTimeout;

  /// The read timeout for the request.
  final Duration? readTimeout;

  /// The connect timeout for the request.
  final Duration? connectTimeout;

  /// Header names to their respective values to be sent with the request.
  final Map<String, dynamic> headers;

  /// URL parameter names to their respective values to be appended to the request URL.
  final Map<String, dynamic> urlParameters;

  /// Custom request body.
  final dynamic body;

  const RequestOptions({
    this.writeTimeout,
    this.readTimeout,
    this.connectTimeout,
    this.headers = const {},
    this.urlParameters = const {},
    this.body,
  });

  RequestOptions operator +(RequestOptions? other) {
    if (other == null) {
      return this;
    }

    return RequestOptions(
      writeTimeout: other.writeTimeout ?? writeTimeout,
      readTimeout: other.readTimeout ?? readTimeout,
      connectTimeout: other.connectTimeout ?? connectTimeout,
      headers: {...headers, ...other.headers},
      urlParameters: {...urlParameters, ...other.urlParameters},
      body: other.body ?? body,
    );
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is RequestOptions &&
          runtimeType == other.runtimeType &&
          writeTimeout == other.writeTimeout &&
          readTimeout == other.readTimeout &&
          connectTimeout == other.connectTimeout &&
          headers == other.headers &&
          urlParameters == other.urlParameters &&
          body == other.body;

  @override
  int get hashCode =>
      writeTimeout.hashCode ^
      readTimeout.hashCode ^
      connectTimeout.hashCode ^
      headers.hashCode ^
      urlParameters.hashCode ^
      body.hashCode;

  @override
  String toString() {
    return 'RequestOptions{writeTimeout: $writeTimeout, readTimeout: $readTimeout, connectTimeout: $connectTimeout, headers: $headers, urlParameters: $urlParameters, body: $body}';
  }
}
