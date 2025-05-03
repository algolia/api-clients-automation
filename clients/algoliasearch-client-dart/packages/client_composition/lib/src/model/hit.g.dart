// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'hit.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Hit _$HitFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Hit',
      json,
      ($checkedConvert) {
        final val = Hit(
          objectID: $checkedConvert('objectID', (v) => v as String),
          highlightResult: $checkedConvert(
              '_highlightResult', (v) => v as Map<String, dynamic>?),
          snippetResult: $checkedConvert(
              '_snippetResult', (v) => v as Map<String, dynamic>?),
          rankingInfo: $checkedConvert(
              '_rankingInfo',
              (v) => v == null
                  ? null
                  : HitRankingInfo.fromJson(v as Map<String, dynamic>)),
          distinctSeqID:
              $checkedConvert('_distinctSeqID', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
      fieldKeyMap: const {
        'highlightResult': '_highlightResult',
        'snippetResult': '_snippetResult',
        'rankingInfo': '_rankingInfo',
        'distinctSeqID': '_distinctSeqID'
      },
    );

const _$HitFieldMap = <String, String>{
  'objectID': 'objectID',
  'highlightResult': '_highlightResult',
  'snippetResult': '_snippetResult',
  'rankingInfo': '_rankingInfo',
  'distinctSeqID': '_distinctSeqID',
};

Map<String, dynamic> _$HitToJson(Hit instance) => <String, dynamic>{
      'objectID': instance.objectID,
      if (instance.highlightResult case final value?) '_highlightResult': value,
      if (instance.snippetResult case final value?) '_snippetResult': value,
      if (instance.rankingInfo?.toJson() case final value?)
        '_rankingInfo': value,
      if (instance.distinctSeqID case final value?) '_distinctSeqID': value,
    };
