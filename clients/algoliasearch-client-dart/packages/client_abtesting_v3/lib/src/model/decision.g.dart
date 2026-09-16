// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'decision.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Decision _$DecisionFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Decision',
      json,
      ($checkedConvert) {
        final val = Decision(
          winnerVariantId:
              $checkedConvert('winnerVariantId', (v) => (v as num).toInt()),
          declaredAt: $checkedConvert('declaredAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$DecisionToJson(Decision instance) => <String, dynamic>{
      'winnerVariantId': instance.winnerVariantId,
      'declaredAt': instance.declaredAt,
    };
