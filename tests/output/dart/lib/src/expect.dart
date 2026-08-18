import 'dart:convert';

import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algolia_test/algolia_test.dart';
import 'package:collection/collection.dart';
import 'package:test/test.dart';
import 'package:test_api/hooks.dart';

/// Checks if the [actual] JSON object matches the [expected] JSON string,
/// disregarding the order of elements.
void expectBody(dynamic actual, String expected) {
  final expectedJson = jsonDecode(expected);
  final jsonObj = jsonEncode(actual);
  final actualJson = jsonDecode(jsonObj);
  expect(
    const DeepCollectionEquality.unordered().equals(expectedJson, actualJson),
    true,
    reason: "expected body: $expectedJson, \nactual body: $actual",
  );
}

/// Verifies that the [actual] map of HTTP headers matches the [expected]
/// headers given as a JSON string, with case-insensitive comparison.
/// [allowMintedRequestId] accepts the Request-ID header minted by the
/// clients that support it: when the expectation does not pin one, the
/// actual value only has to be well-formed.
void expectHeaders(
  Map<String, dynamic>? actual,
  String expected, {
  bool allowMintedRequestId = false,
}) {
  final expectedMap = _normalizeKeys(
    jsonDecode(expected) as Map<String, dynamic>,
  );
  final actualMap = _normalizeKeys(actual);
  if (allowMintedRequestId && !expectedMap.containsKey('request-id')) {
    final minted = actualMap.remove('request-id');
    expect(
      minted?.toString(),
      matches(RegExp(r'^[0-9A-Za-z]{11}$')),
      reason: 'the client must mint a well-formed Request-ID',
    );
  }
  expect(
    const DeepCollectionEquality.unordered().equals(actualMap, expectedMap),
    true,
    reason: "expected map: $expectedMap, \nactual map: $actualMap",
  );
}

/// Verifies that the [actual] headers do not carry [name], whatever its
/// casing, e.g. a Request-ID that must not be minted because the caller
/// supplied one through another channel.
void expectNoHeader(Map<String, dynamic>? actual, String name) {
  expect(
    actual?.keys.any((key) => key.toLowerCase() == name.toLowerCase()) ?? false,
    isFalse,
    reason: 'the $name header must not be sent',
  );
}

/// Normalizes a map by converting all keys to lowercase, making comparison
/// case-insensitive.
Map<String, dynamic> _normalizeKeys(Map<String, dynamic>? map) {
  // Mutable: expectHeaders removes the minted request-id entry.
  if (map == null) return <String, dynamic>{};
  var newMap = <String, dynamic>{};
  map.forEach((key, value) => newMap[key.toLowerCase()] = value);
  return newMap;
}

/// Verifies that the [actual] URI string, once fully decoded, matches the
/// [expected] string.
void expectPath(String actual, String expected) {
  expect(Uri.decodeFull(actual), Uri.decodeFull(expected));
}

/// Checks if the [actual] map of query parameters matches the [expected]
/// parameters given as a JSON string.
void expectParams(Map<String, dynamic> actual, String expected) {
  final expectedMap = jsonDecode(expected) as Map<String, dynamic>;
  expect(actual.length, expectedMap.length);
  expect(
    const DeepCollectionEquality.unordered().equals(actual, expectedMap),
    true,
    reason: "expected params: $expectedMap, \nactual params: $actual",
  );
}

Future<void> expectError(String message, Function block) async {
  try {
    await block();
  } on SkipException catch (_) {
    TestHandle.current.markSkipped('Skip non-nullable params test');
    return;
  } on AssertionError catch (e) {
    expect(e.message, message);
    return;
  } on ArgumentError catch (e) {
    expect(e.message, message);
    return;
  } on UnreachableHostsException catch (e) {
    expect(e.toString(), message);
    return;
  } on AlgoliaApiException catch (e) {
    expect(e.toString(), contains(message));
    return;
  }

  assert(false);
}
