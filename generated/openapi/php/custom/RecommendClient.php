<?php

namespace NewApiClient\Client;

use OpenAPI\Client\Api\DefaultApi;

class RecommendClient extends DefaultApi
{
    /**
     * @inheritDoc
     */
    public function getRecommendations($inline_object, $x_algolia_application_id = null, $x_algolia_api_key = null)
    {
        if ($x_algolia_application_id === null && $this->getConfig()->getAppId() !== null) {
            $x_algolia_application_id = $this->getConfig()->getAppId();
        }

        if ($x_algolia_api_key === null && $this->getConfig()->getAlgoliaApiKey() !== null) {
            $x_algolia_api_key = $this->getConfig()->getAlgoliaApiKey();
        }

        return parent::getRecommendations(["requests" => $inline_object], $x_algolia_application_id, $x_algolia_api_key);
    }
}