// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_recommended_for_you_query_parameters.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseRecommendedForYouQueryParameters
    _$BaseRecommendedForYouQueryParametersFromJson(Map<String, dynamic> json) =>
        $checkedCreate(
          'BaseRecommendedForYouQueryParameters',
          json,
          ($checkedConvert) {
            final val = BaseRecommendedForYouQueryParameters(
              userToken: $checkedConvert('userToken', (v) => v as String),
            );
            return val;
          },
        );

Map<String, dynamic> _$BaseRecommendedForYouQueryParametersToJson(
        BaseRecommendedForYouQueryParameters instance) =>
    <String, dynamic>{
      'userToken': instance.userToken,
    };
