import 'package:algolia_client_ingestion/src/model/action.dart';
import 'package:algolia_client_ingestion/src/model/action_type.dart';
import 'package:algolia_client_ingestion/src/model/auth_api_key.dart';
import 'package:algolia_client_ingestion/src/model/auth_api_key_partial.dart';
import 'package:algolia_client_ingestion/src/model/auth_algolia.dart';
import 'package:algolia_client_ingestion/src/model/auth_algolia_insights.dart';
import 'package:algolia_client_ingestion/src/model/auth_algolia_insights_partial.dart';
import 'package:algolia_client_ingestion/src/model/auth_algolia_partial.dart';
import 'package:algolia_client_ingestion/src/model/auth_basic.dart';
import 'package:algolia_client_ingestion/src/model/auth_basic_partial.dart';
import 'package:algolia_client_ingestion/src/model/auth_google_service_account.dart';
import 'package:algolia_client_ingestion/src/model/auth_google_service_account_partial.dart';
import 'package:algolia_client_ingestion/src/model/auth_o_auth.dart';
import 'package:algolia_client_ingestion/src/model/auth_o_auth_partial.dart';
import 'package:algolia_client_ingestion/src/model/authentication.dart';
import 'package:algolia_client_ingestion/src/model/authentication_create.dart';
import 'package:algolia_client_ingestion/src/model/authentication_create_response.dart';
import 'package:algolia_client_ingestion/src/model/authentication_search.dart';
import 'package:algolia_client_ingestion/src/model/authentication_sort_keys.dart';
import 'package:algolia_client_ingestion/src/model/authentication_type.dart';
import 'package:algolia_client_ingestion/src/model/authentication_update.dart';
import 'package:algolia_client_ingestion/src/model/authentication_update_response.dart';
import 'package:algolia_client_ingestion/src/model/big_commerce_channel.dart';
import 'package:algolia_client_ingestion/src/model/big_commerce_metafield.dart';
import 'package:algolia_client_ingestion/src/model/big_query_data_type.dart';
import 'package:algolia_client_ingestion/src/model/commercetools_custom_fields.dart';
import 'package:algolia_client_ingestion/src/model/delete_response.dart';
import 'package:algolia_client_ingestion/src/model/destination.dart';
import 'package:algolia_client_ingestion/src/model/destination_create.dart';
import 'package:algolia_client_ingestion/src/model/destination_create_response.dart';
import 'package:algolia_client_ingestion/src/model/destination_input.dart';
import 'package:algolia_client_ingestion/src/model/destination_search.dart';
import 'package:algolia_client_ingestion/src/model/destination_sort_keys.dart';
import 'package:algolia_client_ingestion/src/model/destination_type.dart';
import 'package:algolia_client_ingestion/src/model/destination_update.dart';
import 'package:algolia_client_ingestion/src/model/destination_update_input.dart';
import 'package:algolia_client_ingestion/src/model/destination_update_response.dart';
import 'package:algolia_client_ingestion/src/model/docker_streams.dart';
import 'package:algolia_client_ingestion/src/model/docker_streams_input.dart';
import 'package:algolia_client_ingestion/src/model/docker_streams_sync_mode.dart';
import 'package:algolia_client_ingestion/src/model/email_notifications.dart';
import 'package:algolia_client_ingestion/src/model/entity_type.dart';
import 'package:algolia_client_ingestion/src/model/error_base.dart';
import 'package:algolia_client_ingestion/src/model/event.dart';
import 'package:algolia_client_ingestion/src/model/event_sort_keys.dart';
import 'package:algolia_client_ingestion/src/model/event_status.dart';
import 'package:algolia_client_ingestion/src/model/event_type.dart';
import 'package:algolia_client_ingestion/src/model/list_authentications_response.dart';
import 'package:algolia_client_ingestion/src/model/list_destinations_response.dart';
import 'package:algolia_client_ingestion/src/model/list_events_response.dart';
import 'package:algolia_client_ingestion/src/model/list_sources_response.dart';
import 'package:algolia_client_ingestion/src/model/list_tasks_response.dart';
import 'package:algolia_client_ingestion/src/model/list_tasks_response_v1.dart';
import 'package:algolia_client_ingestion/src/model/list_transformations_response.dart';
import 'package:algolia_client_ingestion/src/model/mapping_field_directive.dart';
import 'package:algolia_client_ingestion/src/model/mapping_format_schema.dart';
import 'package:algolia_client_ingestion/src/model/mapping_input.dart';
import 'package:algolia_client_ingestion/src/model/mapping_kit_action.dart';
import 'package:algolia_client_ingestion/src/model/mapping_type_csv.dart';
import 'package:algolia_client_ingestion/src/model/method_type.dart';
import 'package:algolia_client_ingestion/src/model/notifications.dart';
import 'package:algolia_client_ingestion/src/model/on_demand_trigger.dart';
import 'package:algolia_client_ingestion/src/model/on_demand_trigger_input.dart';
import 'package:algolia_client_ingestion/src/model/on_demand_trigger_type.dart';
import 'package:algolia_client_ingestion/src/model/order_keys.dart';
import 'package:algolia_client_ingestion/src/model/pagination.dart';
import 'package:algolia_client_ingestion/src/model/platform.dart';
import 'package:algolia_client_ingestion/src/model/platform_none.dart';
import 'package:algolia_client_ingestion/src/model/policies.dart';
import 'package:algolia_client_ingestion/src/model/push_task_payload.dart';
import 'package:algolia_client_ingestion/src/model/push_task_records.dart';
import 'package:algolia_client_ingestion/src/model/record_type.dart';
import 'package:algolia_client_ingestion/src/model/run.dart';
import 'package:algolia_client_ingestion/src/model/run_list_response.dart';
import 'package:algolia_client_ingestion/src/model/run_outcome.dart';
import 'package:algolia_client_ingestion/src/model/run_progress.dart';
import 'package:algolia_client_ingestion/src/model/run_reason_code.dart';
import 'package:algolia_client_ingestion/src/model/run_response.dart';
import 'package:algolia_client_ingestion/src/model/run_sort_keys.dart';
import 'package:algolia_client_ingestion/src/model/run_source_payload.dart';
import 'package:algolia_client_ingestion/src/model/run_source_response.dart';
import 'package:algolia_client_ingestion/src/model/run_status.dart';
import 'package:algolia_client_ingestion/src/model/run_task_payload.dart';
import 'package:algolia_client_ingestion/src/model/run_type.dart';
import 'package:algolia_client_ingestion/src/model/schedule_trigger.dart';
import 'package:algolia_client_ingestion/src/model/schedule_trigger_input.dart';
import 'package:algolia_client_ingestion/src/model/schedule_trigger_type.dart';
import 'package:algolia_client_ingestion/src/model/shopify_input.dart';
import 'package:algolia_client_ingestion/src/model/shopify_market.dart';
import 'package:algolia_client_ingestion/src/model/shopify_metafield.dart';
import 'package:algolia_client_ingestion/src/model/source.dart';
import 'package:algolia_client_ingestion/src/model/source_algolia_index.dart';
import 'package:algolia_client_ingestion/src/model/source_big_commerce.dart';
import 'package:algolia_client_ingestion/src/model/source_big_query.dart';
import 'package:algolia_client_ingestion/src/model/source_csv.dart';
import 'package:algolia_client_ingestion/src/model/source_commercetools.dart';
import 'package:algolia_client_ingestion/src/model/source_create.dart';
import 'package:algolia_client_ingestion/src/model/source_create_response.dart';
import 'package:algolia_client_ingestion/src/model/source_docker.dart';
import 'package:algolia_client_ingestion/src/model/source_ga4_big_query_export.dart';
import 'package:algolia_client_ingestion/src/model/source_json.dart';
import 'package:algolia_client_ingestion/src/model/source_search.dart';
import 'package:algolia_client_ingestion/src/model/source_shopify.dart';
import 'package:algolia_client_ingestion/src/model/source_shopify_base.dart';
import 'package:algolia_client_ingestion/src/model/source_sort_keys.dart';
import 'package:algolia_client_ingestion/src/model/source_type.dart';
import 'package:algolia_client_ingestion/src/model/source_update.dart';
import 'package:algolia_client_ingestion/src/model/source_update_algolia_index.dart';
import 'package:algolia_client_ingestion/src/model/source_update_commercetools.dart';
import 'package:algolia_client_ingestion/src/model/source_update_docker.dart';
import 'package:algolia_client_ingestion/src/model/source_update_response.dart';
import 'package:algolia_client_ingestion/src/model/source_update_shopify.dart';
import 'package:algolia_client_ingestion/src/model/streaming_input.dart';
import 'package:algolia_client_ingestion/src/model/streaming_trigger.dart';
import 'package:algolia_client_ingestion/src/model/streaming_trigger_type.dart';
import 'package:algolia_client_ingestion/src/model/subscription_trigger.dart';
import 'package:algolia_client_ingestion/src/model/subscription_trigger_type.dart';
import 'package:algolia_client_ingestion/src/model/task.dart';
import 'package:algolia_client_ingestion/src/model/task_create.dart';
import 'package:algolia_client_ingestion/src/model/task_create_response.dart';
import 'package:algolia_client_ingestion/src/model/task_create_v1.dart';
import 'package:algolia_client_ingestion/src/model/task_replace.dart';
import 'package:algolia_client_ingestion/src/model/task_search.dart';
import 'package:algolia_client_ingestion/src/model/task_sort_keys.dart';
import 'package:algolia_client_ingestion/src/model/task_update.dart';
import 'package:algolia_client_ingestion/src/model/task_update_response.dart';
import 'package:algolia_client_ingestion/src/model/task_update_v1.dart';
import 'package:algolia_client_ingestion/src/model/task_v1.dart';
import 'package:algolia_client_ingestion/src/model/transformation.dart';
import 'package:algolia_client_ingestion/src/model/transformation_code.dart';
import 'package:algolia_client_ingestion/src/model/transformation_create.dart';
import 'package:algolia_client_ingestion/src/model/transformation_create_response.dart';
import 'package:algolia_client_ingestion/src/model/transformation_error.dart';
import 'package:algolia_client_ingestion/src/model/transformation_no_code.dart';
import 'package:algolia_client_ingestion/src/model/transformation_search.dart';
import 'package:algolia_client_ingestion/src/model/transformation_sort_keys.dart';
import 'package:algolia_client_ingestion/src/model/transformation_try.dart';
import 'package:algolia_client_ingestion/src/model/transformation_try_response.dart';
import 'package:algolia_client_ingestion/src/model/transformation_type.dart';
import 'package:algolia_client_ingestion/src/model/transformation_update_response.dart';
import 'package:algolia_client_ingestion/src/model/trigger_type.dart';
import 'package:algolia_client_ingestion/src/model/trigger_update_input.dart';
import 'package:algolia_client_ingestion/src/model/watch_response.dart';
import 'package:algolia_client_ingestion/src/model/window.dart';

final _regList = RegExp(r'^List<(.*)>$');
final _regSet = RegExp(r'^Set<(.*)>$');
final _regMap = RegExp(r'^Map<String,(.*)>$');

ReturnType deserialize<ReturnType, BaseType>(dynamic value, String targetType,
    {bool growable = true}) {
  switch (targetType) {
    case 'String':
      return '$value' as ReturnType;
    case 'int':
      return (value is int ? value : int.parse('$value')) as ReturnType;
    case 'bool':
      if (value is bool) {
        return value as ReturnType;
      }
      final valueString = '$value'.toLowerCase();
      return (valueString == 'true' || valueString == '1') as ReturnType;
    case 'double':
      return (value is double ? value : double.parse('$value')) as ReturnType;
    case 'Action':
      return Action.fromJson(value) as ReturnType;
    case 'ActionType':
      return ActionType.fromJson(value) as ReturnType;
    case 'AuthAPIKey':
      return AuthAPIKey.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'AuthAPIKeyPartial':
      return AuthAPIKeyPartial.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AuthAlgolia':
      return AuthAlgolia.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'AuthAlgoliaInsights':
      return AuthAlgoliaInsights.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AuthAlgoliaInsightsPartial':
      return AuthAlgoliaInsightsPartial.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AuthAlgoliaPartial':
      return AuthAlgoliaPartial.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AuthBasic':
      return AuthBasic.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'AuthBasicPartial':
      return AuthBasicPartial.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AuthGoogleServiceAccount':
      return AuthGoogleServiceAccount.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AuthGoogleServiceAccountPartial':
      return AuthGoogleServiceAccountPartial.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'AuthOAuth':
      return AuthOAuth.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'AuthOAuthPartial':
      return AuthOAuthPartial.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Authentication':
      return Authentication.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AuthenticationCreate':
      return AuthenticationCreate.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AuthenticationCreateResponse':
      return AuthenticationCreateResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'AuthenticationSearch':
      return AuthenticationSearch.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AuthenticationSortKeys':
      return AuthenticationSortKeys.fromJson(value) as ReturnType;
    case 'AuthenticationType':
      return AuthenticationType.fromJson(value) as ReturnType;
    case 'AuthenticationUpdate':
      return AuthenticationUpdate.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AuthenticationUpdateResponse':
      return AuthenticationUpdateResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'BigCommerceChannel':
      return BigCommerceChannel.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BigCommerceMetafield':
      return BigCommerceMetafield.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BigQueryDataType':
      return BigQueryDataType.fromJson(value) as ReturnType;
    case 'CommercetoolsCustomFields':
      return CommercetoolsCustomFields.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DeleteResponse':
      return DeleteResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Destination':
      return Destination.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'DestinationCreate':
      return DestinationCreate.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DestinationCreateResponse':
      return DestinationCreateResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DestinationInput':
      return DestinationInput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DestinationSearch':
      return DestinationSearch.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DestinationSortKeys':
      return DestinationSortKeys.fromJson(value) as ReturnType;
    case 'DestinationType':
      return DestinationType.fromJson(value) as ReturnType;
    case 'DestinationUpdate':
      return DestinationUpdate.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DestinationUpdateInput':
      return DestinationUpdateInput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DestinationUpdateResponse':
      return DestinationUpdateResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DockerStreams':
      return DockerStreams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DockerStreamsInput':
      return DockerStreamsInput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DockerStreamsSyncMode':
      return DockerStreamsSyncMode.fromJson(value) as ReturnType;
    case 'EmailNotifications':
      return EmailNotifications.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'EntityType':
      return EntityType.fromJson(value) as ReturnType;
    case 'ErrorBase':
      return ErrorBase.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Event':
      return Event.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'EventSortKeys':
      return EventSortKeys.fromJson(value) as ReturnType;
    case 'EventStatus':
      return EventStatus.fromJson(value) as ReturnType;
    case 'EventType':
      return EventType.fromJson(value) as ReturnType;
    case 'ListAuthenticationsResponse':
      return ListAuthenticationsResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ListDestinationsResponse':
      return ListDestinationsResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ListEventsResponse':
      return ListEventsResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ListSourcesResponse':
      return ListSourcesResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ListTasksResponse':
      return ListTasksResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ListTasksResponseV1':
      return ListTasksResponseV1.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ListTransformationsResponse':
      return ListTransformationsResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'MappingFieldDirective':
      return MappingFieldDirective.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'MappingFormatSchema':
      return MappingFormatSchema.fromJson(value) as ReturnType;
    case 'MappingInput':
      return MappingInput.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'MappingKitAction':
      return MappingKitAction.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'MappingTypeCSV':
      return MappingTypeCSV.fromJson(value) as ReturnType;
    case 'MethodType':
      return MethodType.fromJson(value) as ReturnType;
    case 'Notifications':
      return Notifications.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'OnDemandTrigger':
      return OnDemandTrigger.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'OnDemandTriggerInput':
      return OnDemandTriggerInput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'OnDemandTriggerType':
      return OnDemandTriggerType.fromJson(value) as ReturnType;
    case 'OrderKeys':
      return OrderKeys.fromJson(value) as ReturnType;
    case 'Pagination':
      return Pagination.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Platform':
      return Platform.fromJson(value) as ReturnType;
    case 'PlatformNone':
      return PlatformNone.fromJson(value) as ReturnType;
    case 'Policies':
      return Policies.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'PushTaskPayload':
      return PushTaskPayload.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'PushTaskRecords':
      return PushTaskRecords.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RecordType':
      return RecordType.fromJson(value) as ReturnType;
    case 'Run':
      return Run.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'RunListResponse':
      return RunListResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RunOutcome':
      return RunOutcome.fromJson(value) as ReturnType;
    case 'RunProgress':
      return RunProgress.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'RunReasonCode':
      return RunReasonCode.fromJson(value) as ReturnType;
    case 'RunResponse':
      return RunResponse.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'RunSortKeys':
      return RunSortKeys.fromJson(value) as ReturnType;
    case 'RunSourcePayload':
      return RunSourcePayload.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RunSourceResponse':
      return RunSourceResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RunStatus':
      return RunStatus.fromJson(value) as ReturnType;
    case 'RunTaskPayload':
      return RunTaskPayload.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RunType':
      return RunType.fromJson(value) as ReturnType;
    case 'ScheduleTrigger':
      return ScheduleTrigger.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ScheduleTriggerInput':
      return ScheduleTriggerInput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ScheduleTriggerType':
      return ScheduleTriggerType.fromJson(value) as ReturnType;
    case 'ShopifyInput':
      return ShopifyInput.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ShopifyMarket':
      return ShopifyMarket.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ShopifyMetafield':
      return ShopifyMetafield.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Source':
      return Source.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SourceAlgoliaIndex':
      return SourceAlgoliaIndex.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceBigCommerce':
      return SourceBigCommerce.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceBigQuery':
      return SourceBigQuery.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceCSV':
      return SourceCSV.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SourceCommercetools':
      return SourceCommercetools.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceCreate':
      return SourceCreate.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SourceCreateResponse':
      return SourceCreateResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceDocker':
      return SourceDocker.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SourceGA4BigQueryExport':
      return SourceGA4BigQueryExport.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceJSON':
      return SourceJSON.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SourceSearch':
      return SourceSearch.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SourceShopify':
      return SourceShopify.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceShopifyBase':
      return SourceShopifyBase.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceSortKeys':
      return SourceSortKeys.fromJson(value) as ReturnType;
    case 'SourceType':
      return SourceType.fromJson(value) as ReturnType;
    case 'SourceUpdate':
      return SourceUpdate.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SourceUpdateAlgoliaIndex':
      return SourceUpdateAlgoliaIndex.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceUpdateCommercetools':
      return SourceUpdateCommercetools.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceUpdateDocker':
      return SourceUpdateDocker.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceUpdateResponse':
      return SourceUpdateResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SourceUpdateShopify':
      return SourceUpdateShopify.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'StreamingInput':
      return StreamingInput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'StreamingTrigger':
      return StreamingTrigger.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'StreamingTriggerType':
      return StreamingTriggerType.fromJson(value) as ReturnType;
    case 'SubscriptionTrigger':
      return SubscriptionTrigger.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SubscriptionTriggerType':
      return SubscriptionTriggerType.fromJson(value) as ReturnType;
    case 'Task':
      return Task.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TaskCreate':
      return TaskCreate.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TaskCreateResponse':
      return TaskCreateResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TaskCreateV1':
      return TaskCreateV1.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TaskReplace':
      return TaskReplace.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TaskSearch':
      return TaskSearch.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TaskSortKeys':
      return TaskSortKeys.fromJson(value) as ReturnType;
    case 'TaskUpdate':
      return TaskUpdate.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TaskUpdateResponse':
      return TaskUpdateResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TaskUpdateV1':
      return TaskUpdateV1.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TaskV1':
      return TaskV1.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Transformation':
      return Transformation.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TransformationCode':
      return TransformationCode.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TransformationCreate':
      return TransformationCreate.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TransformationCreateResponse':
      return TransformationCreateResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'TransformationError':
      return TransformationError.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TransformationNoCode':
      return TransformationNoCode.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TransformationSearch':
      return TransformationSearch.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TransformationSortKeys':
      return TransformationSortKeys.fromJson(value) as ReturnType;
    case 'TransformationTry':
      return TransformationTry.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TransformationTryResponse':
      return TransformationTryResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TransformationType':
      return TransformationType.fromJson(value) as ReturnType;
    case 'TransformationUpdateResponse':
      return TransformationUpdateResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'TriggerType':
      return TriggerType.fromJson(value) as ReturnType;
    case 'TriggerUpdateInput':
      return TriggerUpdateInput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'WatchResponse':
      return WatchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Window':
      return Window.fromJson(value as Map<String, dynamic>) as ReturnType;
    default:
      RegExpMatch? match;

      if (value is List && (match = _regList.firstMatch(targetType)) != null) {
        targetType = match![1]!; // ignore: parameter_assignments
        return value
            .map<BaseType>((dynamic v) => deserialize<BaseType, BaseType>(
                v, targetType,
                growable: growable))
            .toList(growable: growable) as ReturnType;
      }
      if (value is Set && (match = _regSet.firstMatch(targetType)) != null) {
        targetType = match![1]!; // ignore: parameter_assignments
        return value
            .map<BaseType>((dynamic v) => deserialize<BaseType, BaseType>(
                v, targetType,
                growable: growable))
            .toSet() as ReturnType;
      }
      if (value is Map && (match = _regMap.firstMatch(targetType)) != null) {
        targetType = match![1]!; // ignore: parameter_assignments
        return Map<dynamic, BaseType>.fromIterables(
          value.keys,
          value.values.map((dynamic v) => deserialize<BaseType, BaseType>(
              v, targetType,
              growable: growable)),
        ) as ReturnType;
      }
      if (targetType == 'Object') {
        return value;
      }
      break;
  }
  throw Exception('Cannot deserialize');
}
