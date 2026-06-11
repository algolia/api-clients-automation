// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'text_part_v5.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TextPartV5 _$TextPartV5FromJson(Map<String, dynamic> json) => $checkedCreate(
      'TextPartV5',
      json,
      ($checkedConvert) {
        final val = TextPartV5(
          type: $checkedConvert('type', (v) => v as String?),
          text: $checkedConvert('text', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$TextPartV5ToJson(TextPartV5 instance) {
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
