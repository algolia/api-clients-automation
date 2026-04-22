// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injected_item_search_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectedItemSearchSource _$InjectedItemSearchSourceFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectedItemSearchSource',
      json,
      ($checkedConvert) {
        final val = InjectedItemSearchSource(
          search: $checkedConvert('search',
              (v) => InjectedItemSearch.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectedItemSearchSourceToJson(
        InjectedItemSearchSource instance) =>
    <String, dynamic>{
      'search': instance.search.toJson(),
    };
