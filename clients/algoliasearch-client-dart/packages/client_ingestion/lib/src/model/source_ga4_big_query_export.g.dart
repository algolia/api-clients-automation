// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source_ga4_big_query_export.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SourceGA4BigQueryExport _$SourceGA4BigQueryExportFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SourceGA4BigQueryExport',
      json,
      ($checkedConvert) {
        final val = SourceGA4BigQueryExport(
          projectID: $checkedConvert('projectID', (v) => v as String),
          datasetID: $checkedConvert('datasetID', (v) => v as String),
          tablePrefix: $checkedConvert('tablePrefix', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceGA4BigQueryExportToJson(
        SourceGA4BigQueryExport instance) =>
    <String, dynamic>{
      'projectID': instance.projectID,
      'datasetID': instance.datasetID,
      'tablePrefix': instance.tablePrefix,
    };
