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

Map<String, dynamic> _$UserHighlightResultToJson(
        UserHighlightResult instance) =>
    <String, dynamic>{
      if (instance.userID case final value?) 'userID': value,
      if (instance.clusterName case final value?) 'clusterName': value,
    };
