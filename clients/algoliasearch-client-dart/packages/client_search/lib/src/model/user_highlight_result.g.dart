// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_highlight_result.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

UserHighlightResult _$UserHighlightResultFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'UserHighlightResult',
      json,
      ($checkedConvert) {
        final val = UserHighlightResult(
          userID: $checkedConvert('userID', (v) => v),
          clusterName: $checkedConvert('clusterName', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$UserHighlightResultToJson(UserHighlightResult instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('userID', instance.userID);
  writeNotNull('clusterName', instance.clusterName);
  return val;
}
