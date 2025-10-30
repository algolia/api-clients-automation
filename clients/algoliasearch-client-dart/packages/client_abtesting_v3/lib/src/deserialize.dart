import 'package:algolia_client_abtesting_v3/src/model/ab_test.dart';
import 'package:algolia_client_abtesting_v3/src/model/ab_test_configuration.dart';
import 'package:algolia_client_abtesting_v3/src/model/ab_test_response.dart';
import 'package:algolia_client_abtesting_v3/src/model/ab_tests_variant.dart';
import 'package:algolia_client_abtesting_v3/src/model/ab_tests_variant_search_params.dart';
import 'package:algolia_client_abtesting_v3/src/model/add_ab_tests_request.dart';
import 'package:algolia_client_abtesting_v3/src/model/create_metric.dart';
import 'package:algolia_client_abtesting_v3/src/model/custom_search_params.dart';
import 'package:algolia_client_abtesting_v3/src/model/direction.dart';
import 'package:algolia_client_abtesting_v3/src/model/effect_metric.dart';
import 'package:algolia_client_abtesting_v3/src/model/empty_search_filter.dart';
import 'package:algolia_client_abtesting_v3/src/model/error_base.dart';
import 'package:algolia_client_abtesting_v3/src/model/error_correction_type.dart';
import 'package:algolia_client_abtesting_v3/src/model/estimate_ab_test_request.dart';
import 'package:algolia_client_abtesting_v3/src/model/estimate_ab_test_response.dart';
import 'package:algolia_client_abtesting_v3/src/model/estimate_configuration.dart';
import 'package:algolia_client_abtesting_v3/src/model/filter_effects.dart';
import 'package:algolia_client_abtesting_v3/src/model/list_ab_tests_response.dart';
import 'package:algolia_client_abtesting_v3/src/model/metric_date.dart';
import 'package:algolia_client_abtesting_v3/src/model/metric_metadata.dart';
import 'package:algolia_client_abtesting_v3/src/model/metric_name.dart';
import 'package:algolia_client_abtesting_v3/src/model/metric_result.dart';
import 'package:algolia_client_abtesting_v3/src/model/metrics_filter.dart';
import 'package:algolia_client_abtesting_v3/src/model/minimum_detectable_effect.dart';
import 'package:algolia_client_abtesting_v3/src/model/outliers_filter.dart';
import 'package:algolia_client_abtesting_v3/src/model/status.dart';
import 'package:algolia_client_abtesting_v3/src/model/timeseries.dart';
import 'package:algolia_client_abtesting_v3/src/model/timeseries_variant.dart';
import 'package:algolia_client_abtesting_v3/src/model/variant.dart';
import 'package:algolia_client_abtesting_v3/src/model/variant_metadata.dart';

final _regList = RegExp(r'^List<(.*)>$');
final _regSet = RegExp(r'^Set<(.*)>$');
final _regMap = RegExp(r'^Map<String,(.*)>$');

ReturnType deserialize<ReturnType, BaseType>(dynamic value, String targetType,
    {bool growable = true}) {
  switch (targetType) {
    case 'String':
      return '$value' as ReturnType;
    case 'int':
      return (value is int ? value : int.parse('$value')) as ReturnType;
    case 'bool':
      if (value is bool) {
        return value as ReturnType;
      }
      final valueString = '$value'.toLowerCase();
      return (valueString == 'true' || valueString == '1') as ReturnType;
    case 'double':
      return (value is double ? value : double.parse('$value')) as ReturnType;
    case 'ABTest':
      return ABTest.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ABTestConfiguration':
      return ABTestConfiguration.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ABTestResponse':
      return ABTestResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AbTestsVariant':
      return AbTestsVariant.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AbTestsVariantSearchParams':
      return AbTestsVariantSearchParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AddABTestsRequest':
      return AddABTestsRequest.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CreateMetric':
      return CreateMetric.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'CustomSearchParams':
      return CustomSearchParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Direction':
      return Direction.fromJson(value) as ReturnType;
    case 'EffectMetric':
      return EffectMetric.fromJson(value) as ReturnType;
    case 'EmptySearchFilter':
      return EmptySearchFilter.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ErrorBase':
      return ErrorBase.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ErrorCorrectionType':
      return ErrorCorrectionType.fromJson(value) as ReturnType;
    case 'EstimateABTestRequest':
      return EstimateABTestRequest.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'EstimateABTestResponse':
      return EstimateABTestResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'EstimateConfiguration':
      return EstimateConfiguration.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'FilterEffects':
      return FilterEffects.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ListABTestsResponse':
      return ListABTestsResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'MetricDate':
      return MetricDate.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'MetricMetadata':
      return MetricMetadata.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'MetricName':
      return MetricName.fromJson(value) as ReturnType;
    case 'MetricResult':
      return MetricResult.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'MetricsFilter':
      return MetricsFilter.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'MinimumDetectableEffect':
      return MinimumDetectableEffect.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'OutliersFilter':
      return OutliersFilter.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Status':
      return Status.fromJson(value) as ReturnType;
    case 'Timeseries':
      return Timeseries.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TimeseriesVariant':
      return TimeseriesVariant.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Variant':
      return Variant.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'VariantMetadata':
      return VariantMetadata.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    default:
      RegExpMatch? match;

      if (value is List && (match = _regList.firstMatch(targetType)) != null) {
        targetType = match![1]!; // ignore: parameter_assignments
        return value
            .map<BaseType>((dynamic v) => deserialize<BaseType, BaseType>(
                v, targetType,
                growable: growable))
            .toList(growable: growable) as ReturnType;
      }
      if (value is Set && (match = _regSet.firstMatch(targetType)) != null) {
        targetType = match![1]!; // ignore: parameter_assignments
        return value
            .map<BaseType>((dynamic v) => deserialize<BaseType, BaseType>(
                v, targetType,
                growable: growable))
            .toSet() as ReturnType;
      }
      if (value is Map && (match = _regMap.firstMatch(targetType)) != null) {
        targetType = match![1]!; // ignore: parameter_assignments
        return Map<dynamic, BaseType>.fromIterables(
          value.keys,
          value.values.map((dynamic v) => deserialize<BaseType, BaseType>(
              v, targetType,
              growable: growable)),
        ) as ReturnType;
      }
      if (targetType == 'Object') {
        return value;
      }
      break;
  }
  throw Exception('Cannot deserialize');
}
