#!/bin/bash

# treat website as independant yarn project
touch website/yarn.lock

# Generate the file with constants
cat config/clients.config.json | jq -r 'del(."$schema") | "export const versions = \(map_values(.packageVersion))"' > website/src/generated/variables.js

# install website deps and build, with yarn supply-chain checks on CI
if [ -n "$CI" ]; then
  export YARN_ENABLE_HARDENED_MODE=1
fi
cd website && yarn install && yarn build
