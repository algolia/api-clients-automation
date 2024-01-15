import 'package:algolia_test/algolia_test.dart';

T empty<T>() =>
    switch (T) { String _ => '', Map _ => {}, _ => throw SkipException() } as T;
