// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'global_request_scope.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

GlobalRequestScope _$GlobalRequestScopeFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'GlobalRequestScope',
      json,
      ($checkedConvert) {
        final val = GlobalRequestScope(
          global: $checkedConvert('global', (v) => v as bool),
        );
        return val;
      },
    );

Map<String, dynamic> _$GlobalRequestScopeToJson(GlobalRequestScope instance) =>
    <String, dynamic>{
      'global': instance.global,
    };
