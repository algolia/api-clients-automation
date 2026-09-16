/// How many times a 429 is waited out on the same host when
/// `ClientOptions.maxRateLimitRetries` is left unset.
const int defaultMaxRateLimitRetries = 3;

/// The wait applied when `Retry-After` is missing or not a whole number of
/// seconds.
const Duration defaultRateLimitWait = Duration(seconds: 1);

/// Largest whole-second wait a [Duration] can hold: it stores int64
/// microseconds, so `Duration(seconds: n)` wraps negative past this point.
/// This is a runtime ceiling, not a client-side maximum wait. On the web,
/// `Timer` compiles to `setTimeout`, which browsers truncate above 2^31 - 1 ms,
/// so a wait that long fires immediately there, as in the JavaScript client.
const int maxRateLimitWaitSeconds = 9223372036854;

final RegExp _wholeSeconds = RegExp(r'^[0-9]+$');

/// The `Retry-After` header as a wait.
///
/// Only a positive whole number of seconds is honoured (trimmed, ASCII digits,
/// header name matched case-insensitively); anything else (missing, empty,
/// `0`, HTTP-date, junk) waits [defaultRateLimitWait]. Values too large for a
/// [Duration] wait [maxRateLimitWaitSeconds].
Duration parseRetryAfter(Map<String, String>? headers) {
  if (headers == null) return defaultRateLimitWait;
  String? raw;
  for (final entry in headers.entries) {
    if (entry.key.toLowerCase() == 'retry-after') {
      raw = entry.value.trim();
      break;
    }
  }
  if (raw == null || !_wholeSeconds.hasMatch(raw)) return defaultRateLimitWait;
  // Digits that do not fit an int take the ceiling, not the fallback.
  final seconds = int.tryParse(raw);
  if (seconds == null || seconds > maxRateLimitWaitSeconds) {
    return const Duration(seconds: maxRateLimitWaitSeconds);
  }
  if (seconds <= 0) return defaultRateLimitWait;
  return Duration(seconds: seconds);
}

/// The effective budget for [configured]: `null` means
/// [defaultMaxRateLimitRetries], negative values behave like `0`.
int resolveMaxRateLimitRetries(int? configured) {
  if (configured == null) return defaultMaxRateLimitRetries;
  return configured < 0 ? 0 : configured;
}

/// Whether [statusCode] is an HTTP 429 Too Many Requests.
bool isRateLimited(int? statusCode) => statusCode == 429;
