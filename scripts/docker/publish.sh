#! /bin/bash

export NODE_VERSION=$(cat .nvmrc)
eval $(find config -name '.*-version' | xargs -I{} sh -c 'l=$(echo "{}" | sed -e "s/-/_/;s/config\/\.//" | tr "[a-z]" "[A-Z]");echo "export $l=$(cat {})"')

docker buildx build --push \
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

docker buildx build --push \
  --platform linux/amd64 \
  --build-arg RUBY_VERSION \
  --build-arg JAVA_VERSION \
  --build-arg NODE_VERSION \
  -t ghcr.io/algolia/apic-ruby:latest \
  -f scripts/docker/Dockerfile.ruby . 

docker buildx build --push \
  --platform linux/arm64 \
  --build-arg SWIFT_VERSION \
  --build-arg JAVA_VERSION \
  --build-arg NODE_VERSION \
  -t ghcr.io/algolia/apic-swift:latest \
  -f scripts/docker/Dockerfile.swift .
