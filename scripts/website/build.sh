#!/bin/bash

FILE=website/yarn.lock

# create lock file if not found
if [[ ! -f "$FILE" ]]; then
  touch $FILE
fi

# build doc specs
yarn website:build-specs

# install website deps and build
cd website && yarn install && yarn build
