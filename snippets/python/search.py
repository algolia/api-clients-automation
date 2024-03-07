from algoliasearch.search.client import SearchClient


async def snippet_for_add_api_key():
    """
    Snippet for the addApiKey method.

    addApiKey0
    """
    # >SEPARATOR addApiKey
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.add_api_key(
        api_key={
            "acl": [
                "search",
                "addObject",
            ],
            "description": "my new api key",
            "validity": 300,
            "maxQueriesPerIPPerHour": 100,
            "maxHitsPerQuery": 20,
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_add_or_update_object():
    """
    Snippet for the addOrUpdateObject method.

    addOrUpdateObject0
    """
    # >SEPARATOR addOrUpdateObject
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.add_or_update_object(
        index_name="indexName",
        object_id="uniqueID",
        body={
            "key": "value",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_append_source():
    """
    Snippet for the appendSource method.

    appendSource0
    """
    # >SEPARATOR appendSource
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.append_source(
        source={
            "source": "theSource",
            "description": "theDescription",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_assign_user_id():
    """
    Snippet for the assignUserId method.

    assignUserId0
    """
    # >SEPARATOR assignUserId
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.assign_user_id(
        x_algolia_user_id="userID",
        assign_user_id_params={
            "cluster": "theCluster",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_batch():
    """
    Snippet for the batch method.

    allows batch method with `addObject` action
    """
    # >SEPARATOR batch
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.batch(
        index_name="theIndexName",
        batch_write_params={
            "requests": [
                {
                    "action": "addObject",
                    "body": {
                        "key": "value",
                    },
                },
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_batch_assign_user_ids():
    """
    Snippet for the batchAssignUserIds method.

    batchAssignUserIds0
    """
    # >SEPARATOR batchAssignUserIds
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.batch_assign_user_ids(
        x_algolia_user_id="userID",
        batch_assign_user_ids_params={
            "cluster": "theCluster",
            "users": [
                "user1",
                "user2",
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_batch_dictionary_entries():
    """
    Snippet for the batchDictionaryEntries method.

    get batchDictionaryEntries results with minimal parameters
    """
    # >SEPARATOR batchDictionaryEntries
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.batch_dictionary_entries(
        dictionary_name="compounds",
        batch_dictionary_entries_params={
            "requests": [
                {
                    "action": "addEntry",
                    "body": {
                        "objectID": "1",
                        "language": "en",
                    },
                },
                {
                    "action": "deleteEntry",
                    "body": {
                        "objectID": "2",
                        "language": "fr",
                    },
                },
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_browse():
    """
    Snippet for the browse method.

    browse with minimal parameters
    """
    # >SEPARATOR browse
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.browse(
        index_name="cts_e2e_browse",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_clear_objects():
    """
    Snippet for the clearObjects method.

    clearObjects0
    """
    # >SEPARATOR clearObjects
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.clear_objects(
        index_name="theIndexName",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_clear_rules():
    """
    Snippet for the clearRules method.

    clearRules0
    """
    # >SEPARATOR clearRules
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.clear_rules(
        index_name="indexName",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_clear_synonyms():
    """
    Snippet for the clearSynonyms method.

    clearSynonyms0
    """
    # >SEPARATOR clearSynonyms
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.clear_synonyms(
        index_name="indexName",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_custom_delete():
    """
    Snippet for the customDelete method.

    allow del method for a custom path with minimal parameters
    """
    # >SEPARATOR customDelete
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.custom_delete(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_custom_get():
    """
    Snippet for the customGet method.

    allow get method for a custom path with minimal parameters
    """
    # >SEPARATOR customGet
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.custom_get(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_custom_post():
    """
    Snippet for the customPost method.

    allow post method for a custom path with minimal parameters
    """
    # >SEPARATOR customPost
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.custom_post(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_custom_put():
    """
    Snippet for the customPut method.

    allow put method for a custom path with minimal parameters
    """
    # >SEPARATOR customPut
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.custom_put(
        path="/test/minimal",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_api_key():
    """
    Snippet for the deleteApiKey method.

    deleteApiKey0
    """
    # >SEPARATOR deleteApiKey
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.delete_api_key(
        key="myTestApiKey",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_by():
    """
    Snippet for the deleteBy method.

    deleteBy0
    """
    # >SEPARATOR deleteBy
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.delete_by(
        index_name="theIndexName",
        delete_by_params={
            "filters": "brand:brandName",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_index():
    """
    Snippet for the deleteIndex method.

    deleteIndex0
    """
    # >SEPARATOR deleteIndex
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.delete_index(
        index_name="theIndexName",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_object():
    """
    Snippet for the deleteObject method.

    deleteObject0
    """
    # >SEPARATOR deleteObject
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.delete_object(
        index_name="theIndexName",
        object_id="uniqueID",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_rule():
    """
    Snippet for the deleteRule method.

    delete rule simple case
    """
    # >SEPARATOR deleteRule
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.delete_rule(
        index_name="indexName",
        object_id="id1",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_source():
    """
    Snippet for the deleteSource method.

    deleteSource0
    """
    # >SEPARATOR deleteSource
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.delete_source(
        source="theSource",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_delete_synonym():
    """
    Snippet for the deleteSynonym method.

    deleteSynonym0
    """
    # >SEPARATOR deleteSynonym
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.delete_synonym(
        index_name="indexName",
        object_id="id1",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_api_key():
    """
    Snippet for the getApiKey method.

    getApiKey0
    """
    # >SEPARATOR getApiKey
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_api_key(
        key="myTestApiKey",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_dictionary_languages():
    """
    Snippet for the getDictionaryLanguages method.

    get getDictionaryLanguages
    """
    # >SEPARATOR getDictionaryLanguages
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_dictionary_languages()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_dictionary_settings():
    """
    Snippet for the getDictionarySettings method.

    get getDictionarySettings results
    """
    # >SEPARATOR getDictionarySettings
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_dictionary_settings()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_logs():
    """
    Snippet for the getLogs method.

    getLogs with minimal parameters
    """
    # >SEPARATOR getLogs
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_logs()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_object():
    """
    Snippet for the getObject method.

    getObject0
    """
    # >SEPARATOR getObject
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_object(
        index_name="theIndexName",
        object_id="uniqueID",
        attributes_to_retrieve=[
            "attr1",
            "attr2",
        ],
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_objects():
    """
    Snippet for the getObjects method.

    getObjects0
    """
    # >SEPARATOR getObjects
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_objects(
        get_objects_params={
            "requests": [
                {
                    "attributesToRetrieve": [
                        "attr1",
                        "attr2",
                    ],
                    "objectID": "uniqueID",
                    "indexName": "theIndexName",
                },
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_rule():
    """
    Snippet for the getRule method.

    getRule0
    """
    # >SEPARATOR getRule
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_rule(
        index_name="indexName",
        object_id="id1",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_settings():
    """
    Snippet for the getSettings method.

    getSettings0
    """
    # >SEPARATOR getSettings
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_settings(
        index_name="cts_e2e_settings",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_sources():
    """
    Snippet for the getSources method.

    getSources0
    """
    # >SEPARATOR getSources
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_sources()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_synonym():
    """
    Snippet for the getSynonym method.

    getSynonym0
    """
    # >SEPARATOR getSynonym
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_synonym(
        index_name="indexName",
        object_id="id1",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_task():
    """
    Snippet for the getTask method.

    getTask0
    """
    # >SEPARATOR getTask
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_task(
        index_name="theIndexName",
        task_id=123,
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_top_user_ids():
    """
    Snippet for the getTopUserIds method.

    getTopUserIds0
    """
    # >SEPARATOR getTopUserIds
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_top_user_ids()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_get_user_id():
    """
    Snippet for the getUserId method.

    getUserId0
    """
    # >SEPARATOR getUserId
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.get_user_id(
        user_id="uniqueID",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_has_pending_mappings():
    """
    Snippet for the hasPendingMappings method.

    hasPendingMappings with minimal parameters
    """
    # >SEPARATOR hasPendingMappings
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.has_pending_mappings()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_list_api_keys():
    """
    Snippet for the listApiKeys method.

    listApiKeys0
    """
    # >SEPARATOR listApiKeys
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.list_api_keys()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_list_clusters():
    """
    Snippet for the listClusters method.

    listClusters0
    """
    # >SEPARATOR listClusters
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.list_clusters()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_list_indices():
    """
    Snippet for the listIndices method.

    listIndices with minimal parameters
    """
    # >SEPARATOR listIndices
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.list_indices()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_list_user_ids():
    """
    Snippet for the listUserIds method.

    listUserIds with minimal parameters
    """
    # >SEPARATOR listUserIds
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.list_user_ids()

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_multiple_batch():
    """
    Snippet for the multipleBatch method.

    multipleBatch0
    """
    # >SEPARATOR multipleBatch
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.multiple_batch(
        batch_params={
            "requests": [
                {
                    "action": "addObject",
                    "body": {
                        "key": "value",
                    },
                    "indexName": "theIndexName",
                },
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_operation_index():
    """
    Snippet for the operationIndex method.

    operationIndex0
    """
    # >SEPARATOR operationIndex
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.operation_index(
        index_name="theIndexName",
        operation_index_params={
            "operation": "copy",
            "destination": "dest",
            "scope": [
                "rules",
                "settings",
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_partial_update_object():
    """
    Snippet for the partialUpdateObject method.

    partialUpdateObject0
    """
    # >SEPARATOR partialUpdateObject
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.partial_update_object(
        index_name="theIndexName",
        object_id="uniqueID",
        attributes_to_update={
            "id1": "test",
            "id2": {
                "_operation": "AddUnique",
                "value": "test2",
            },
        },
        create_if_not_exists=True,
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_remove_user_id():
    """
    Snippet for the removeUserId method.

    removeUserId0
    """
    # >SEPARATOR removeUserId
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.remove_user_id(
        user_id="uniqueID",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_replace_sources():
    """
    Snippet for the replaceSources method.

    replaceSources0
    """
    # >SEPARATOR replaceSources
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.replace_sources(
        source=[
            {
                "source": "theSource",
                "description": "theDescription",
            },
        ],
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_restore_api_key():
    """
    Snippet for the restoreApiKey method.

    restoreApiKey0
    """
    # >SEPARATOR restoreApiKey
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.restore_api_key(
        key="myApiKey",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_save_object():
    """
    Snippet for the saveObject method.

    saveObject0
    """
    # >SEPARATOR saveObject
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.save_object(
        index_name="theIndexName",
        body={
            "objectID": "id",
            "test": "val",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_save_rule():
    """
    Snippet for the saveRule method.

    saveRule with minimal parameters
    """
    # >SEPARATOR saveRule
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.save_rule(
        index_name="indexName",
        object_id="id1",
        rule={
            "objectID": "id1",
            "conditions": [
                {
                    "pattern": "apple",
                    "anchoring": "contains",
                },
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_save_rules():
    """
    Snippet for the saveRules method.

    saveRules with minimal parameters
    """
    # >SEPARATOR saveRules
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.save_rules(
        index_name="indexName",
        rules=[
            {
                "objectID": "a-rule-id",
                "conditions": [
                    {
                        "pattern": "smartphone",
                        "anchoring": "contains",
                    },
                ],
            },
            {
                "objectID": "a-second-rule-id",
                "conditions": [
                    {
                        "pattern": "apple",
                        "anchoring": "contains",
                    },
                ],
            },
        ],
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_save_synonym():
    """
    Snippet for the saveSynonym method.

    saveSynonym0
    """
    # >SEPARATOR saveSynonym
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.save_synonym(
        index_name="indexName",
        object_id="id1",
        synonym_hit={
            "objectID": "id1",
            "type": "synonym",
            "synonyms": [
                "car",
                "vehicule",
                "auto",
            ],
        },
        forward_to_replicas=True,
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_save_synonyms():
    """
    Snippet for the saveSynonyms method.

    saveSynonyms0
    """
    # >SEPARATOR saveSynonyms
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.save_synonyms(
        index_name="indexName",
        synonym_hit=[
            {
                "objectID": "id1",
                "type": "synonym",
                "synonyms": [
                    "car",
                    "vehicule",
                    "auto",
                ],
            },
            {
                "objectID": "id2",
                "type": "onewaysynonym",
                "input": "iphone",
                "synonyms": [
                    "ephone",
                    "aphone",
                    "yphone",
                ],
            },
        ],
        forward_to_replicas=True,
        replace_existing_synonyms=False,
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_search():
    """
    Snippet for the search method.

    search for a single hits request with minimal parameters
    """
    # >SEPARATOR search
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.search(
        search_method_params={
            "requests": [
                {
                    "indexName": "cts_e2e_search_empty_index",
                },
            ],
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_search_dictionary_entries():
    """
    Snippet for the searchDictionaryEntries method.

    get searchDictionaryEntries results with minimal parameters
    """
    # >SEPARATOR searchDictionaryEntries
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.search_dictionary_entries(
        dictionary_name="compounds",
        search_dictionary_entries_params={
            "query": "foo",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_search_for_facet_values():
    """
    Snippet for the searchForFacetValues method.

    get searchForFacetValues results with minimal parameters
    """
    # >SEPARATOR searchForFacetValues
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.search_for_facet_values(
        index_name="indexName",
        facet_name="facetName",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_search_rules():
    """
    Snippet for the searchRules method.

    searchRules0
    """
    # >SEPARATOR searchRules
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.search_rules(
        index_name="indexName",
        search_rules_params={
            "query": "something",
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_search_single_index():
    """
    Snippet for the searchSingleIndex method.

    search with minimal parameters
    """
    # >SEPARATOR searchSingleIndex
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.search_single_index(
        index_name="indexName",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_search_synonyms():
    """
    Snippet for the searchSynonyms method.

    searchSynonyms with minimal parameters
    """
    # >SEPARATOR searchSynonyms
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.search_synonyms(
        index_name="indexName",
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_search_user_ids():
    """
    Snippet for the searchUserIds method.

    searchUserIds0
    """
    # >SEPARATOR searchUserIds
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.search_user_ids(
        search_user_ids_params={
            "query": "test",
            "clusterName": "theClusterName",
            "page": 5,
            "hitsPerPage": 10,
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_set_dictionary_settings():
    """
    Snippet for the setDictionarySettings method.

    get setDictionarySettings results with minimal parameters
    """
    # >SEPARATOR setDictionarySettings
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.set_dictionary_settings(
        dictionary_settings_params={
            "disableStandardEntries": {
                "plurals": {
                    "fr": False,
                    "en": False,
                    "ru": True,
                },
            },
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_set_settings():
    """
    Snippet for the setSettings method.

    setSettings with minimal parameters
    """
    # >SEPARATOR setSettings
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.set_settings(
        index_name="cts_e2e_settings",
        index_settings={
            "paginationLimitedTo": 10,
        },
        forward_to_replicas=True,
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<


async def snippet_for_update_api_key():
    """
    Snippet for the updateApiKey method.

    updateApiKey0
    """
    # >SEPARATOR updateApiKey
    # Initialize the client
    _client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

    # Call the API
    resp = await _client.update_api_key(
        key="myApiKey",
        api_key={
            "acl": [
                "search",
                "addObject",
            ],
            "validity": 300,
            "maxQueriesPerIPPerHour": 100,
            "maxHitsPerQuery": 20,
        },
    )

    # use the class directly
    print(resp)

    # print the JSON response
    print(resp.to_json())
    # SEPARATOR<
