// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'context_stats.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ContextStats _$ContextStatsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ContextStats',
      json,
      ($checkedConvert) {
        final val = ContextStats(
          messagesBefore:
              $checkedConvert('messagesBefore', (v) => (v as num).toInt()),
          messagesAfter:
              $checkedConvert('messagesAfter', (v) => (v as num).toInt()),
          tokensBeforeEstimate: $checkedConvert(
              'tokensBeforeEstimate', (v) => (v as num).toInt()),
          tokensAfterEstimate:
              $checkedConvert('tokensAfterEstimate', (v) => (v as num).toInt()),
          messagesDropped:
              $checkedConvert('messagesDropped', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ContextStatsToJson(ContextStats instance) =>
    <String, dynamic>{
      'messagesBefore': instance.messagesBefore,
      'messagesAfter': instance.messagesAfter,
      'tokensBeforeEstimate': instance.tokensBeforeEstimate,
      'tokensAfterEstimate': instance.tokensAfterEstimate,
      'messagesDropped': instance.messagesDropped,
    };
