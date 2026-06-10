// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'transformation_search.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TransformationSearch _$TransformationSearchFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'TransformationSearch',
      json,
      ($checkedConvert) {
        final val = TransformationSearch(
          transformationIDs: $checkedConvert('transformationIDs',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$TransformationSearchToJson(
        TransformationSearch instance) =>
    <String, dynamic>{
      'transformationIDs': instance.transformationIDs,
    };
