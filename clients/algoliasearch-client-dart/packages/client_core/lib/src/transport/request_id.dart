import 'dart:math';

/// The name of the header carrying the Request-ID minted when a client supports it.
const requestIdHeader = 'Request-ID';

const _alphabet =
    'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';

final Random _random = _createRandom();

Random _createRandom() {
  try {
    return Random.secure();
  } on UnsupportedError {
    // A request must not fail over its tracing metadata: platforms without a
    // secure entropy source degrade to the seeded generator.
    return Random();
  }
}

/// Returns a fresh 11-character base62 identifier suitable for the Request-ID
/// header.
String generateRequestId() => String.fromCharCodes(
      List.generate(
        11,
        (_) => _alphabet.codeUnitAt(_random.nextInt(_alphabet.length)),
      ),
    );

/// Whether the given headers already carry a Request-ID entry, whatever its
/// casing. Header maps keep the caller's literal casing, so the lookup must
/// not assume a canonical form.
bool hasRequestIdHeader(Map<String, dynamic>? headers) =>
    headers?.keys.any((key) => key.toLowerCase() == 'request-id') ?? false;

/// Whether the given query parameters already carry an `x-algolia-request-id`
/// entry, whatever its casing. The server consults that parameter only when
/// the header is absent, so a caller-supplied value must suppress header
/// minting or it would be shadowed.
bool hasRequestIdQueryParameter(Map<String, dynamic>? queryParameters) =>
    queryParameters?.keys
        .any((key) => key.toLowerCase() == 'x-algolia-request-id') ??
    false;
