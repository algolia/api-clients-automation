import 'package:algolia_client_agent_studio/src/model/advanced_syntax_features.dart';
import 'package:algolia_client_agent_studio/src/model/agent_completion_algolia_params.dart';
import 'package:algolia_client_agent_studio/src/model/agent_completion_request.dart';
import 'package:algolia_client_agent_studio/src/model/agent_config_create.dart';
import 'package:algolia_client_agent_studio/src/model/agent_config_update.dart';
import 'package:algolia_client_agent_studio/src/model/agent_status.dart';
import 'package:algolia_client_agent_studio/src/model/agent_test_configuration.dart';
import 'package:algolia_client_agent_studio/src/model/agent_with_version_response.dart';
import 'package:algolia_client_agent_studio/src/model/algolia_display_results_tool_config.dart';
import 'package:algolia_client_agent_studio/src/model/algolia_recommend_tool_config_input.dart';
import 'package:algolia_client_agent_studio/src/model/algolia_recommend_tool_index_config.dart';
import 'package:algolia_client_agent_studio/src/model/algolia_search_tool_config.dart';
import 'package:algolia_client_agent_studio/src/model/algolia_search_tool_index_config.dart';
import 'package:algolia_client_agent_studio/src/model/allowed_domain_bulk_delete.dart';
import 'package:algolia_client_agent_studio/src/model/allowed_domain_bulk_insert.dart';
import 'package:algolia_client_agent_studio/src/model/allowed_domain_create.dart';
import 'package:algolia_client_agent_studio/src/model/allowed_domain_list_response.dart';
import 'package:algolia_client_agent_studio/src/model/allowed_domain_response.dart';
import 'package:algolia_client_agent_studio/src/model/alternatives_as_exact.dart';
import 'package:algolia_client_agent_studio/src/model/anthropic_provider_input.dart';
import 'package:algolia_client_agent_studio/src/model/application_config_patch.dart';
import 'package:algolia_client_agent_studio/src/model/application_config_response.dart';
import 'package:algolia_client_agent_studio/src/model/assistant_message_v4.dart';
import 'package:algolia_client_agent_studio/src/model/assistant_message_v5.dart';
import 'package:algolia_client_agent_studio/src/model/azure_open_ai_provider_input.dart';
import 'package:algolia_client_agent_studio/src/model/base_provider_input.dart';
import 'package:algolia_client_agent_studio/src/model/client_side_tool_config.dart';
import 'package:algolia_client_agent_studio/src/model/client_tools_args_schema.dart';
import 'package:algolia_client_agent_studio/src/model/compatibility_mode.dart';
import 'package:algolia_client_agent_studio/src/model/conversation_base_response.dart';
import 'package:algolia_client_agent_studio/src/model/conversation_full_response.dart';
import 'package:algolia_client_agent_studio/src/model/conversation_metadata.dart';
import 'package:algolia_client_agent_studio/src/model/episode.dart';
import 'package:algolia_client_agent_studio/src/model/error_base.dart';
import 'package:algolia_client_agent_studio/src/model/exact_on_single_word_query.dart';
import 'package:algolia_client_agent_studio/src/model/facets.dart';
import 'package:algolia_client_agent_studio/src/model/facets_param.dart';
import 'package:algolia_client_agent_studio/src/model/feedback_creation_request.dart';
import 'package:algolia_client_agent_studio/src/model/feedback_response.dart';
import 'package:algolia_client_agent_studio/src/model/http_validation_error.dart';
import 'package:algolia_client_agent_studio/src/model/index_search_parameters.dart';
import 'package:algolia_client_agent_studio/src/model/mcp_server_tool_config.dart';
import 'package:algolia_client_agent_studio/src/model/mcp_tool_config.dart';
import 'package:algolia_client_agent_studio/src/model/memory_record.dart';
import 'package:algolia_client_agent_studio/src/model/memory_type.dart';
import 'package:algolia_client_agent_studio/src/model/message_response.dart';
import 'package:algolia_client_agent_studio/src/model/message_role.dart';
import 'package:algolia_client_agent_studio/src/model/number_param.dart';
import 'package:algolia_client_agent_studio/src/model/number_param_constraint.dart';
import 'package:algolia_client_agent_studio/src/model/open_ai_compatible_provider_input.dart';
import 'package:algolia_client_agent_studio/src/model/open_ai_provider_input.dart';
import 'package:algolia_client_agent_studio/src/model/paginated_agents_response.dart';
import 'package:algolia_client_agent_studio/src/model/paginated_conversations_response.dart';
import 'package:algolia_client_agent_studio/src/model/paginated_provider_authentications_response.dart';
import 'package:algolia_client_agent_studio/src/model/paginated_secret_keys_response.dart';
import 'package:algolia_client_agent_studio/src/model/pagination_metadata.dart';
import 'package:algolia_client_agent_studio/src/model/provider_authentication_create.dart';
import 'package:algolia_client_agent_studio/src/model/provider_authentication_patch.dart';
import 'package:algolia_client_agent_studio/src/model/provider_authentication_response.dart';
import 'package:algolia_client_agent_studio/src/model/provider_name.dart';
import 'package:algolia_client_agent_studio/src/model/query_type.dart';
import 'package:algolia_client_agent_studio/src/model/reasoning_part.dart';
import 'package:algolia_client_agent_studio/src/model/reasoning_part_v4.dart';
import 'package:algolia_client_agent_studio/src/model/reasoning_part_v5.dart';
import 'package:algolia_client_agent_studio/src/model/remove_words_if_no_results.dart';
import 'package:algolia_client_agent_studio/src/model/search_parameters.dart';
import 'package:algolia_client_agent_studio/src/model/search_parameters_overrides.dart';
import 'package:algolia_client_agent_studio/src/model/secret_key_create.dart';
import 'package:algolia_client_agent_studio/src/model/secret_key_patch.dart';
import 'package:algolia_client_agent_studio/src/model/secret_key_response.dart';
import 'package:algolia_client_agent_studio/src/model/start_part.dart';
import 'package:algolia_client_agent_studio/src/model/start_step_part.dart';
import 'package:algolia_client_agent_studio/src/model/step_start_part_v4.dart';
import 'package:algolia_client_agent_studio/src/model/step_start_part_v5.dart';
import 'package:algolia_client_agent_studio/src/model/string_array_param.dart';
import 'package:algolia_client_agent_studio/src/model/string_array_param_constraint.dart';
import 'package:algolia_client_agent_studio/src/model/supported_language.dart';
import 'package:algolia_client_agent_studio/src/model/text_param.dart';
import 'package:algolia_client_agent_studio/src/model/text_part.dart';
import 'package:algolia_client_agent_studio/src/model/text_part_v4.dart';
import 'package:algolia_client_agent_studio/src/model/text_part_v5.dart';
import 'package:algolia_client_agent_studio/src/model/tool_approval_request_part.dart';
import 'package:algolia_client_agent_studio/src/model/tool_call_part.dart';
import 'package:algolia_client_agent_studio/src/model/tool_invocation_part_v4.dart';
import 'package:algolia_client_agent_studio/src/model/tool_invocation_v4.dart';
import 'package:algolia_client_agent_studio/src/model/tool_part_v5.dart';
import 'package:algolia_client_agent_studio/src/model/tool_result_output.dart';
import 'package:algolia_client_agent_studio/src/model/tool_result_output_type.dart';
import 'package:algolia_client_agent_studio/src/model/tool_result_part.dart';
import 'package:algolia_client_agent_studio/src/model/tool_state.dart';
import 'package:algolia_client_agent_studio/src/model/typo_tolerance_enum.dart';
import 'package:algolia_client_agent_studio/src/model/unknown_tool_config.dart';
import 'package:algolia_client_agent_studio/src/model/user_data_response.dart';
import 'package:algolia_client_agent_studio/src/model/user_message_metadata_v5.dart';
import 'package:algolia_client_agent_studio/src/model/user_message_v4.dart';
import 'package:algolia_client_agent_studio/src/model/user_message_v5.dart';
import 'package:algolia_client_agent_studio/src/model/validation_error.dart';
import 'package:algolia_client_agent_studio/src/model/vote_enum.dart';

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
    case 'AdvancedSyntaxFeatures':
      return AdvancedSyntaxFeatures.fromJson(value) as ReturnType;
    case 'AgentCompletionAlgoliaParams':
      return AgentCompletionAlgoliaParams.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'AgentCompletionRequest':
      return AgentCompletionRequest.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AgentConfigCreate':
      return AgentConfigCreate.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AgentConfigUpdate':
      return AgentConfigUpdate.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AgentStatus':
      return AgentStatus.fromJson(value) as ReturnType;
    case 'AgentTestConfiguration':
      return AgentTestConfiguration.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AgentWithVersionResponse':
      return AgentWithVersionResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AlgoliaDisplayResultsToolConfig':
      return AlgoliaDisplayResultsToolConfig.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'AlgoliaRecommendToolConfigInput':
      return AlgoliaRecommendToolConfigInput.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'AlgoliaRecommendToolIndexConfig':
      return AlgoliaRecommendToolIndexConfig.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'AlgoliaSearchToolConfig':
      return AlgoliaSearchToolConfig.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AlgoliaSearchToolIndexConfig':
      return AlgoliaSearchToolIndexConfig.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'AllowedDomainBulkDelete':
      return AllowedDomainBulkDelete.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AllowedDomainBulkInsert':
      return AllowedDomainBulkInsert.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AllowedDomainCreate':
      return AllowedDomainCreate.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AllowedDomainListResponse':
      return AllowedDomainListResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AllowedDomainResponse':
      return AllowedDomainResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AlternativesAsExact':
      return AlternativesAsExact.fromJson(value) as ReturnType;
    case 'AnthropicProviderInput':
      return AnthropicProviderInput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ApplicationConfigPatch':
      return ApplicationConfigPatch.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ApplicationConfigResponse':
      return ApplicationConfigResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AssistantMessageV4':
      return AssistantMessageV4.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AssistantMessageV5':
      return AssistantMessageV5.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'AzureOpenAIProviderInput':
      return AzureOpenAIProviderInput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BaseProviderInput':
      return BaseProviderInput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ClientSideToolConfig':
      return ClientSideToolConfig.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ClientToolsArgsSchema':
      return ClientToolsArgsSchema.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompatibilityMode':
      return CompatibilityMode.fromJson(value) as ReturnType;
    case 'ConversationBaseResponse':
      return ConversationBaseResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ConversationFullResponse':
      return ConversationFullResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ConversationMetadata':
      return ConversationMetadata.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Episode':
      return Episode.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ErrorBase':
      return ErrorBase.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ExactOnSingleWordQuery':
      return ExactOnSingleWordQuery.fromJson(value) as ReturnType;
    case 'Facets':
      return Facets.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'FacetsParam':
      return FacetsParam.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'FeedbackCreationRequest':
      return FeedbackCreationRequest.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'FeedbackResponse':
      return FeedbackResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'HTTPValidationError':
      return HTTPValidationError.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'IndexSearchParameters':
      return IndexSearchParameters.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'McpServerToolConfig':
      return McpServerToolConfig.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'McpToolConfig':
      return McpToolConfig.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'MemoryRecord':
      return MemoryRecord.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'MemoryType':
      return MemoryType.fromJson(value) as ReturnType;
    case 'MessageResponse':
      return MessageResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'MessageRole':
      return MessageRole.fromJson(value) as ReturnType;
    case 'NumberParam':
      return NumberParam.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'NumberParamConstraint':
      return NumberParamConstraint.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'OpenAICompatibleProviderInput':
      return OpenAICompatibleProviderInput.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'OpenAIProviderInput':
      return OpenAIProviderInput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'PaginatedAgentsResponse':
      return PaginatedAgentsResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'PaginatedConversationsResponse':
      return PaginatedConversationsResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'PaginatedProviderAuthenticationsResponse':
      return PaginatedProviderAuthenticationsResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'PaginatedSecretKeysResponse':
      return PaginatedSecretKeysResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'PaginationMetadata':
      return PaginationMetadata.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ProviderAuthenticationCreate':
      return ProviderAuthenticationCreate.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'ProviderAuthenticationPatch':
      return ProviderAuthenticationPatch.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ProviderAuthenticationResponse':
      return ProviderAuthenticationResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'ProviderName':
      return ProviderName.fromJson(value) as ReturnType;
    case 'QueryType':
      return QueryType.fromJson(value) as ReturnType;
    case 'ReasoningPart':
      return ReasoningPart.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ReasoningPartV4':
      return ReasoningPartV4.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ReasoningPartV5':
      return ReasoningPartV5.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RemoveWordsIfNoResults':
      return RemoveWordsIfNoResults.fromJson(value) as ReturnType;
    case 'SearchParameters':
      return SearchParameters.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchParametersOverrides':
      return SearchParametersOverrides.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SecretKeyCreate':
      return SecretKeyCreate.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SecretKeyPatch':
      return SecretKeyPatch.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SecretKeyResponse':
      return SecretKeyResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'StartPart':
      return StartPart.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'StartStepPart':
      return StartStepPart.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'StepStartPartV4':
      return StepStartPartV4.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'StepStartPartV5':
      return StepStartPartV5.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'StringArrayParam':
      return StringArrayParam.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'StringArrayParamConstraint':
      return StringArrayParamConstraint.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SupportedLanguage':
      return SupportedLanguage.fromJson(value) as ReturnType;
    case 'TextParam':
      return TextParam.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TextPart':
      return TextPart.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TextPartV4':
      return TextPartV4.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TextPartV5':
      return TextPartV5.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ToolApprovalRequestPart':
      return ToolApprovalRequestPart.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ToolCallPart':
      return ToolCallPart.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ToolInvocationPartV4':
      return ToolInvocationPartV4.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ToolInvocationV4':
      return ToolInvocationV4.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ToolPartV5':
      return ToolPartV5.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ToolResultOutput':
      return ToolResultOutput.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ToolResultOutputType':
      return ToolResultOutputType.fromJson(value) as ReturnType;
    case 'ToolResultPart':
      return ToolResultPart.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ToolState':
      return ToolState.fromJson(value) as ReturnType;
    case 'TypoToleranceEnum':
      return TypoToleranceEnum.fromJson(value) as ReturnType;
    case 'UnknownToolConfig':
      return UnknownToolConfig.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'UserDataResponse':
      return UserDataResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'UserMessageMetadataV5':
      return UserMessageMetadataV5.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'UserMessageV4':
      return UserMessageV4.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'UserMessageV5':
      return UserMessageV5.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ValidationError':
      return ValidationError.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'VoteEnum':
      return VoteEnum.fromJson(value) as ReturnType;
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
