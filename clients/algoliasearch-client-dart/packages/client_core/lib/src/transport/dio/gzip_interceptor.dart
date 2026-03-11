import 'dart:convert';

import 'package:dio/dio.dart';

import 'compress_stub.dart'
    if (dart.library.html) 'compress_web.dart'
    if (dart.library.io) 'compress_io.dart';

const int compressionThreshold = 750;

/// Interceptor that compresses POST/PUT request bodies using gzip.
class GzipInterceptor extends Interceptor {
  @override
  void onRequest(RequestOptions options, RequestInterceptorHandler handler) {
    if (options.data != null &&
        (options.method == 'POST' || options.method == 'PUT')) {
      final serialized = jsonEncode(options.data);
      if (serialized.length > compressionThreshold) {
        final compressed = gzipCompress(serialized);
        if (compressed != null) {
          options.data = Stream.value(compressed);
          options.headers['content-encoding'] = 'gzip';
        }
      }
    }
    super.onRequest(options, handler);
  }
}
