// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'text_part_v4.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TextPartV4 _$TextPartV4FromJson(Map<String, dynamic> json) => $checkedCreate(
      'TextPartV4',
      json,
      ($checkedConvert) {
        final val = TextPartV4(
          type: $checkedConvert('type', (v) => v as String?),
          text: $checkedConvert('text', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$TextPartV4ToJson(TextPartV4 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('type', instance.type);
  val['text'] = instance.text;
  return val;
}
