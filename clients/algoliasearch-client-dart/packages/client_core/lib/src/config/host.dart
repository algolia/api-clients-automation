/// Represents an Algolia host.
final class Host {
  /// Host url.
  final String url;

  // url port
  final int? port;

  /// Host protocol (i.e. `http`, `https`)
  final String scheme;

  /// Whether this host should be used for [CallType.read] or [CallType.write] requests.
  final CallType? callType;

  /// Constructs a [Host] instance with the provided parameters.
  const Host(
      {required this.url, this.port, this.scheme = 'https', this.callType});

  factory Host.create(
      {required String url, String scheme = 'https', CallType? callType}) {
    if (url.contains(':')) {
      final parts = url.split(':');
      return Host(
          url: parts[0],
          port: int.parse(parts[1]),
          scheme: scheme,
          callType: callType);
    }

    return Host(url: url, scheme: scheme, callType: callType);
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is Host &&
          runtimeType == other.runtimeType &&
          url == other.url &&
          port == other.port &&
          scheme == other.scheme &&
          callType == other.callType;

  @override
  int get hashCode =>
      url.hashCode ^ (port ?? 1) ^ scheme.hashCode ^ callType.hashCode;

  @override
  String toString() {
    return 'Host{url: $url, port: $port, scheme: $scheme, callType: $callType}';
  }
}

/// Indicate whether the HTTP call performed is of type [read] (GET) or [write]
/// (POST, PUT ..). Used to determine which timeout duration to use.
enum CallType {
  read,
  write,
}
