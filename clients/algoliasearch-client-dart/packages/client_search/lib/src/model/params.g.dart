// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Params _$ParamsFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Params',
      json,
      ($checkedConvert) {
        final val = Params(
          query: $checkedConvert('query', (v) => v),
          automaticFacetFilters:
              $checkedConvert('automaticFacetFilters', (v) => v),
          automaticOptionalFacetFilters:
              $checkedConvert('automaticOptionalFacetFilters', (v) => v),
          renderingContent: $checkedConvert(
              'renderingContent',
              (v) => v == null
                  ? null
                  : RenderingContent.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ParamsToJson(Params instance) => <String, dynamic>{
      if (instance.query case final value?) 'query': value,
      if (instance.automaticFacetFilters case final value?)
        'automaticFacetFilters': value,
      if (instance.automaticOptionalFacetFilters case final value?)
        'automaticOptionalFacetFilters': value,
      if (instance.renderingContent?.toJson() case final value?)
        'renderingContent': value,
    };
