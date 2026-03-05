import 'dart:convert';
import 'dart:io';

List<int>? gzipCompress(dynamic data) {
  if (data == null) return null;
  return GZipCodec().encode(utf8.encode(jsonEncode(data)));
}
