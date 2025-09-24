// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'list_compositions_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ListCompositionsResponse _$ListCompositionsResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ListCompositionsResponse',
      json,
      ($checkedConvert) {
        final val = ListCompositionsResponse(
          items: $checkedConvert(
              'items',
              (v) => (v as List<dynamic>)
                  .map((e) => Composition.fromJson(e as Map<String, dynamic>))
                  .toList()),
          nbPages: $checkedConvert('nbPages', (v) => (v as num).toInt()),
          page: $checkedConvert('page', (v) => (v as num).toInt()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num).toInt()),
          nbHits: $checkedConvert('nbHits', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ListCompositionsResponseToJson(
        ListCompositionsResponse instance) =>
    <String, dynamic>{
      'items': instance.items.map((e) => e.toJson()).toList(),
      'nbPages': instance.nbPages,
      'page': instance.page,
      'hitsPerPage': instance.hitsPerPage,
      'nbHits': instance.nbHits,
    };
