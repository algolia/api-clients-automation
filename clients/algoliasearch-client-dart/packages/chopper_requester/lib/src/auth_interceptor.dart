import 'dart:async' show FutureOr;

import 'package:chopper/chopper.dart';

/// Interceptor that attaches the application id and API key to outgoing requests.
///
/// This interceptor modifies the headers of each request to include the
/// application id and API key for Algolia authentication.
class AuthInterceptor implements Interceptor {
  /// The application id used for Algolia authentication.
  final String appId;

  /// The API key used for Algolia authentication.
  final String _apiKey;

  /// Constructs an [AuthInterceptor] with the provided application id and API key.
  const AuthInterceptor({
    required this.appId,
    required String apiKey,
  }) : _apiKey = apiKey;

  @override
  FutureOr<Response<BodyType>> intercept<BodyType>(Chain<BodyType> chain) =>
      chain.proceed(
        applyHeaders(
          chain.request,
          {
            'x-algolia-application-id': appId,
            'x-algolia-api-key': _apiKey,
          },
        ),
      );
}
