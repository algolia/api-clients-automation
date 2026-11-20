// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_params_allow_re_ranking.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchParamsAllowReRanking _$SearchParamsAllowReRankingFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchParamsAllowReRanking',
      json,
      ($checkedConvert) {
        final val = SearchParamsAllowReRanking(
          allowReRankingOnPersonalization: $checkedConvert(
              'allowReRankingOnPersonalization', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchParamsAllowReRankingToJson(
    SearchParamsAllowReRanking instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('allowReRankingOnPersonalization',
      instance.allowReRankingOnPersonalization);
  return val;
}
