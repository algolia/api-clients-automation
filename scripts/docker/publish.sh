#! /bin/bash

export NODE_VERSION=$(cat .nvmrc)
find config -name '.*-version' | xargs -I{} sh -c 'l=$(echo "{}" | sed -e "s/-/_/;s/config\/\.//" | tr "[a-z]" "[A-Z]");echo "export $l=$(cat {})"'

docker buildx build --load \
  --platform linux/amd64 \
  --build-arg CSHARP_VERSION \
  --build-arg DART_VERSION \
  --build-arg GO_VERSION \
  --build-arg JAVA_VERSION \
  --build-arg NODE_VERSION \
  --build-arg PHP_VERSION \
  --build-arg PYTHON_VERSION \
  -t ghcr.io/algolia/apic-base:latest \
  -f scripts/docker/Dockerfile.base . 
