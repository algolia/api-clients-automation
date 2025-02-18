// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_search_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseSearchResponse _$BaseSearchResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'BaseSearchResponse',
      json,
      ($checkedConvert) {
        final val = BaseSearchResponse(
          abTestID: $checkedConvert('abTestID', (v) => (v as num?)?.toInt()),
          abTestVariantID:
              $checkedConvert('abTestVariantID', (v) => (v as num?)?.toInt()),
          aroundLatLng: $checkedConvert('aroundLatLng', (v) => v as String?),
          automaticRadius:
              $checkedConvert('automaticRadius', (v) => v as String?),
          exhaustive: $checkedConvert(
              'exhaustive',
              (v) => v == null
                  ? null
                  : Exhaustive.fromJson(v as Map<String, dynamic>)),
          appliedRules: $checkedConvert('appliedRules',
              (v) => (v as List<dynamic>?)?.map((e) => e as Object).toList()),
          exhaustiveFacetsCount:
              $checkedConvert('exhaustiveFacetsCount', (v) => v as bool?),
          exhaustiveNbHits:
              $checkedConvert('exhaustiveNbHits', (v) => v as bool?),
          exhaustiveTypo: $checkedConvert('exhaustiveTypo', (v) => v as bool?),
          facets: $checkedConvert(
              'facets',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, Map<String, int>.from(e as Map)),
                  )),
          facetsStats: $checkedConvert(
              'facets_stats',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(
                        k, FacetStats.fromJson(e as Map<String, dynamic>)),
                  )),
          index: $checkedConvert('index', (v) => v as String?),
          indexUsed: $checkedConvert('indexUsed', (v) => v as String?),
          message: $checkedConvert('message', (v) => v as String?),
          nbSortedHits:
              $checkedConvert('nbSortedHits', (v) => (v as num?)?.toInt()),
          parsedQuery: $checkedConvert('parsedQuery', (v) => v as String?),
          processingTimeMS:
              $checkedConvert('processingTimeMS', (v) => (v as num).toInt()),
          processingTimingsMS: $checkedConvert('processingTimingsMS', (v) => v),
          queryAfterRemoval:
              $checkedConvert('queryAfterRemoval', (v) => v as String?),
          redirect: $checkedConvert(
              'redirect',
              (v) => v == null
                  ? null
                  : Redirect.fromJson(v as Map<String, dynamic>)),
          renderingContent: $checkedConvert(
              'renderingContent',
              (v) => v == null
                  ? null
                  : RenderingContent.fromJson(v as Map<String, dynamic>)),
          serverTimeMS:
              $checkedConvert('serverTimeMS', (v) => (v as num?)?.toInt()),
          serverUsed: $checkedConvert('serverUsed', (v) => v as String?),
          userData: $checkedConvert('userData', (v) => v),
          queryID: $checkedConvert('queryID', (v) => v as String?),
          automaticInsights:
              $checkedConvert('_automaticInsights', (v) => v as bool?),
        );
        return val;
      },
      fieldKeyMap: const {
        'facetsStats': 'facets_stats',
        'automaticInsights': '_automaticInsights'
      },
    );

const _$BaseSearchResponseFieldMap = <String, String>{
  'abTestID': 'abTestID',
  'abTestVariantID': 'abTestVariantID',
  'aroundLatLng': 'aroundLatLng',
  'automaticRadius': 'automaticRadius',
  'exhaustive': 'exhaustive',
  'appliedRules': 'appliedRules',
  'exhaustiveFacetsCount': 'exhaustiveFacetsCount',
  'exhaustiveNbHits': 'exhaustiveNbHits',
  'exhaustiveTypo': 'exhaustiveTypo',
  'facets': 'facets',
  'facetsStats': 'facets_stats',
  'index': 'index',
  'indexUsed': 'indexUsed',
  'message': 'message',
  'nbSortedHits': 'nbSortedHits',
  'parsedQuery': 'parsedQuery',
  'processingTimeMS': 'processingTimeMS',
  'processingTimingsMS': 'processingTimingsMS',
  'queryAfterRemoval': 'queryAfterRemoval',
  'redirect': 'redirect',
  'renderingContent': 'renderingContent',
  'serverTimeMS': 'serverTimeMS',
  'serverUsed': 'serverUsed',
  'userData': 'userData',
  'queryID': 'queryID',
  'automaticInsights': '_automaticInsights',
};

Map<String, dynamic> _$BaseSearchResponseToJson(BaseSearchResponse instance) =>
    <String, dynamic>{
      if (instance.abTestID case final value?) 'abTestID': value,
      if (instance.abTestVariantID case final value?) 'abTestVariantID': value,
      if (instance.aroundLatLng case final value?) 'aroundLatLng': value,
      if (instance.automaticRadius case final value?) 'automaticRadius': value,
      if (instance.exhaustive?.toJson() case final value?) 'exhaustive': value,
      if (instance.appliedRules case final value?) 'appliedRules': value,
      if (instance.exhaustiveFacetsCount case final value?)
        'exhaustiveFacetsCount': value,
      if (instance.exhaustiveNbHits case final value?)
        'exhaustiveNbHits': value,
      if (instance.exhaustiveTypo case final value?) 'exhaustiveTypo': value,
      if (instance.facets case final value?) 'facets': value,
      if (instance.facetsStats?.map((k, e) => MapEntry(k, e.toJson()))
          case final value?)
        'facets_stats': value,
      if (instance.index case final value?) 'index': value,
      if (instance.indexUsed case final value?) 'indexUsed': value,
      if (instance.message case final value?) 'message': value,
      if (instance.nbSortedHits case final value?) 'nbSortedHits': value,
      if (instance.parsedQuery case final value?) 'parsedQuery': value,
      'processingTimeMS': instance.processingTimeMS,
      if (instance.processingTimingsMS case final value?)
        'processingTimingsMS': value,
      if (instance.queryAfterRemoval case final value?)
        'queryAfterRemoval': value,
      if (instance.redirect?.toJson() case final value?) 'redirect': value,
      if (instance.renderingContent?.toJson() case final value?)
        'renderingContent': value,
      if (instance.serverTimeMS case final value?) 'serverTimeMS': value,
      if (instance.serverUsed case final value?) 'serverUsed': value,
      if (instance.userData case final value?) 'userData': value,
      if (instance.queryID case final value?) 'queryID': value,
      if (instance.automaticInsights case final value?)
        '_automaticInsights': value,
    };
