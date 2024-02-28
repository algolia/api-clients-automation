#!/bin/bash

# treat website as independant yarn project
touch website/yarn.lock

# Generate the file with constants
mkdir -p website/src/generated
cat config/clients.config.json | jq -r '"export const versions = \(map_values(.packageVersion))"' > website/src/generated/variables.js

# install website deps and build
cd website && yarn install && yarn build
