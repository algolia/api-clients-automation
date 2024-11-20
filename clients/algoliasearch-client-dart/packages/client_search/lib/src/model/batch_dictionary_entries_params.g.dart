// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'batch_dictionary_entries_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BatchDictionaryEntriesParams _$BatchDictionaryEntriesParamsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'BatchDictionaryEntriesParams',
      json,
      ($checkedConvert) {
        final val = BatchDictionaryEntriesParams(
          clearExistingDictionaryEntries: $checkedConvert(
              'clearExistingDictionaryEntries', (v) => v as bool?),
          requests: $checkedConvert(
              'requests',
              (v) => (v as List<dynamic>)
                  .map((e) => BatchDictionaryEntriesRequest.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$BatchDictionaryEntriesParamsToJson(
        BatchDictionaryEntriesParams instance) =>
    <String, dynamic>{
      if (instance.clearExistingDictionaryEntries case final value?)
        'clearExistingDictionaryEntries': value,
      'requests': instance.requests.map((e) => e.toJson()).toList(),
    };
