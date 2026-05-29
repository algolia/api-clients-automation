import 'dart:convert';

import 'package:archive/archive.dart';

List<int>? gzipCompress(String data) {
  return GZipEncoder().encode(utf8.encode(data));
}
