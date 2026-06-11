import 'package:algolia_test/algolia_test.dart';

T empty<T>() {
  if (T == String) return '' as T;
  if (T == Map) return {} as T;
  if (null is T) return null as T;
  throw SkipException();
}
