// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'recommendations_results.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RecommendationsResults _$RecommendationsResultsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'RecommendationsResults',
      json,
      ($checkedConvert) {
        final val = RecommendationsResults(
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
              $checkedConvert('processingTimeMS', (v) => (v as num?)?.toInt()),
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
          page: $checkedConvert('page', (v) => (v as num?)?.toInt()),
          nbHits: $checkedConvert('nbHits', (v) => (v as num?)?.toInt()),
          nbPages: $checkedConvert('nbPages', (v) => (v as num?)?.toInt()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
          hits: $checkedConvert('hits', (v) => v as List<dynamic>),
        );
        return val;
      },
      fieldKeyMap: const {
        'facetsStats': 'facets_stats',
        'automaticInsights': '_automaticInsights'
      },
    );

Map<String, dynamic> _$RecommendationsResultsToJson(
    RecommendationsResults instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('abTestID', instance.abTestID);
  writeNotNull('abTestVariantID', instance.abTestVariantID);
  writeNotNull('aroundLatLng', instance.aroundLatLng);
  writeNotNull('automaticRadius', instance.automaticRadius);
  writeNotNull('exhaustive', instance.exhaustive?.toJson());
  writeNotNull('appliedRules', instance.appliedRules);
  writeNotNull('exhaustiveFacetsCount', instance.exhaustiveFacetsCount);
  writeNotNull('exhaustiveNbHits', instance.exhaustiveNbHits);
  writeNotNull('exhaustiveTypo', instance.exhaustiveTypo);
  writeNotNull('facets', instance.facets);
  writeNotNull('facets_stats',
      instance.facetsStats?.map((k, e) => MapEntry(k, e.toJson())));
  writeNotNull('index', instance.index);
  writeNotNull('indexUsed', instance.indexUsed);
  writeNotNull('message', instance.message);
  writeNotNull('nbSortedHits', instance.nbSortedHits);
  writeNotNull('parsedQuery', instance.parsedQuery);
  writeNotNull('processingTimeMS', instance.processingTimeMS);
  writeNotNull('processingTimingsMS', instance.processingTimingsMS);
  writeNotNull('queryAfterRemoval', instance.queryAfterRemoval);
  writeNotNull('redirect', instance.redirect?.toJson());
  writeNotNull('renderingContent', instance.renderingContent?.toJson());
  writeNotNull('serverTimeMS', instance.serverTimeMS);
  writeNotNull('serverUsed', instance.serverUsed);
  writeNotNull('userData', instance.userData);
  writeNotNull('queryID', instance.queryID);
  writeNotNull('_automaticInsights', instance.automaticInsights);
  writeNotNull('page', instance.page);
  writeNotNull('nbHits', instance.nbHits);
  writeNotNull('nbPages', instance.nbPages);
  writeNotNull('hitsPerPage', instance.hitsPerPage);
  val['hits'] = instance.hits.toList();
  return val;
}
