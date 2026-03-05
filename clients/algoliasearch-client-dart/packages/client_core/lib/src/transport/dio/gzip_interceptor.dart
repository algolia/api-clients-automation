import 'package:dio/dio.dart';

import 'compress_stub.dart'
    if (dart.library.html) 'compress_web.dart'
    if (dart.library.io) 'compress_io.dart';

/// Interceptor that compresses POST/PUT request bodies using gzip.
class GzipInterceptor extends Interceptor {
  @override
  void onRequest(RequestOptions options, RequestInterceptorHandler handler) {
    if (options.data != null &&
        (options.method == 'POST' || options.method == 'PUT')) {
      final compressed = gzipCompress(options.data);
      if (compressed != null) {
        options.data = Stream.value(compressed);
        options.headers['content-encoding'] = 'gzip';
      }
    }
    super.onRequest(options, handler);
  }
}
