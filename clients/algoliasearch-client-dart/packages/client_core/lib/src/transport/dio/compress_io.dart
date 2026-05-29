import 'dart:convert';
import 'dart:io';

List<int>? gzipCompress(String data) {
  return GZipCodec().encode(utf8.encode(data));
}
