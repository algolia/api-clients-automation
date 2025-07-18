// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'rendering_content.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RenderingContent _$RenderingContentFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'RenderingContent',
      json,
      ($checkedConvert) {
        final val = RenderingContent(
          facetOrdering: $checkedConvert(
              'facetOrdering',
              (v) => v == null
                  ? null
                  : FacetOrdering.fromJson(v as Map<String, dynamic>)),
          redirect: $checkedConvert(
              'redirect',
              (v) => v == null
                  ? null
                  : RedirectURL.fromJson(v as Map<String, dynamic>)),
          widgets: $checkedConvert(
              'widgets',
              (v) => v == null
                  ? null
                  : Widgets.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$RenderingContentToJson(RenderingContent instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('facetOrdering', instance.facetOrdering?.toJson());
  writeNotNull('redirect', instance.redirect?.toJson());
  writeNotNull('widgets', instance.widgets?.toJson());
  return val;
}
