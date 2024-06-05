// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'bought_together_query.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BoughtTogetherQuery _$BoughtTogetherQueryFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'BoughtTogetherQuery',
      json,
      ($checkedConvert) {
        final val = BoughtTogetherQuery(
          indexName: $checkedConvert('indexName', (v) => v as String),
          threshold: $checkedConvert('threshold', (v) => (v as num).toDouble()),
          maxRecommendations: $checkedConvert(
              'maxRecommendations', (v) => (v as num?)?.toInt()),
          queryParameters: $checkedConvert(
              'queryParameters',
              (v) => v == null
                  ? null
                  : SearchParams.fromJson(v as Map<String, dynamic>)),
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$FbtModelEnumMap, v)),
          objectID: $checkedConvert('objectID', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$BoughtTogetherQueryToJson(BoughtTogetherQuery instance) {
  final val = <String, dynamic>{
    'indexName': instance.indexName,
    'threshold': instance.threshold,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('maxRecommendations', instance.maxRecommendations);
  writeNotNull('queryParameters', instance.queryParameters?.toJson());
  val['model'] = instance.model.toJson();
  val['objectID'] = instance.objectID;
  return val;
}

const _$FbtModelEnumMap = {
  FbtModel.boughtTogether: 'bought-together',
};
