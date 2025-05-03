// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'value.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Value _$ValueFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Value',
      json,
      ($checkedConvert) {
        final val = Value(
          order: $checkedConvert('order',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          sortRemainingBy: $checkedConvert('sortRemainingBy',
              (v) => $enumDecodeNullable(_$SortRemainingByEnumMap, v)),
          hide: $checkedConvert('hide',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ValueToJson(Value instance) => <String, dynamic>{
      if (instance.order case final value?) 'order': value,
      if (instance.sortRemainingBy?.toJson() case final value?)
        'sortRemainingBy': value,
      if (instance.hide case final value?) 'hide': value,
    };

const _$SortRemainingByEnumMap = {
  SortRemainingBy.count: 'count',
  SortRemainingBy.alpha: 'alpha',
  SortRemainingBy.hidden: 'hidden',
};
