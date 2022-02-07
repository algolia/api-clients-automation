#!/bin/bash

# Break on non-zero code
set -e

FOLDER=$1
GENERATOR=$2

# Generator does not allow new files, so we use existing ones to generate
# our `node` and `browser` build files.

destination=$FOLDER/builds

mkdir -p $destination

mv $FOLDER/api.ts $destination/node.ts
mv $FOLDER/src/apis.ts $destination/browser.ts

apiName=$(cat openapitools.json | jq -r --arg generator "$GENERATOR" '."generator-cli".generators[$generator].additionalProperties.apiName' | sed 's/#{cwd}\///g')
api="$apiName"Api
createApiName=create$(cat openapitools.json | jq -r --arg generator "$GENERATOR" '."generator-cli".generators[$generator].additionalProperties.capitalizedApiName' | sed 's/#{cwd}\///g')Api

echo -e "// eslint-disable-next-line import/extensions\nimport { $api, $createApiName } from './dist/$apiName.esm.js';\n\nexport { $api, $createApiName };" > $FOLDER/index.js
echo -e "/* eslint-disable import/no-unresolved*/\nexport * from './dist/builds/node';" > $FOLDER/index.d.ts
