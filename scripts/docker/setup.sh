#! /bin/bash

export NODE_VERSION=$(cat .nvmrc)
find config -name '.*-version' | xargs -I{} sh -c 'l=$(echo "{}" | sed -e "s/-/_/;s/config\/\.//" | tr "[a-z]" "[A-Z]");echo "export $l=$(cat {})"'
docker compose up -d
