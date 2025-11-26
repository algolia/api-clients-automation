#!/bin/bash

# This script updates the JIRA_TOKEN secret in the GitHub repository
# Usage: ./scripts/update_jira_token.sh <jira_email> <new_jira_token>

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <jira_email> <new_jira_token>"
    exit 1
fi

EMAIL="$1"
TOKEN="$2"
ENCRYPED_TOKEN=$(echo -n "$EMAIL:$TOKEN" | base64)

repositories=(
  "algolia/api-clients-automation"
  "algolia/algoliasearch-client-csharp"
  "algolia/algoliasearch-client-dart"
  "algolia/algoliasearch-client-go"
  "algolia/algoliasearch-client-java"
  "algolia/algoliasearch-client-javascript"
  "algolia/algoliasearch-client-kotlin"
  "algolia/algoliasearch-client-php"
  "algolia/algoliasearch-client-python"
  "algolia/algoliasearch-client-ruby"
  "algolia/algoliasearch-client-scala"
  "algolia/algoliasearch-client-swift"
  "algolia/algoliasearch-django"
  "algolia/scout-extended"
  "algolia/search-bundle"
  "algolia/firestore-algolia-search"
  "algolia/algoliasearch-rails"
)

for repo in "${repositories[@]}"; do
  gh -R "$repo" secret set JIRA_TOKEN --body "$ENCRYPED_TOKEN"
done
