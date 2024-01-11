#!/bin/bash

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)/../.."

if ! test -f ".env"; then
    cp .env.example .env
fi

cd $ROOT

JAVA_VERSION=$(cat config/.java-version)
NODE_VERSION=$(cat .nvmrc | sed -E -n 's/v?([0-9]+)\..*/\1/p')
PHP_VERSION=$(cat config/.php-version)
GO_VERSION=$(cat config/.go-version)
DART_VERSION=$(cat config/.dart-version)
PYTHON_VERSION=$(cat config/.python-version)
RUBY_VERSION=$(cat config/.ruby-version)
CSHARP_VERSION=$(cat config/.csharp-version)
SWIFT_VERSION=$(cat config/.swift-version)

docker build \
  --build-arg JAVA_VERSION=$JAVA_VERSION \
  --build-arg NODE_VERSION=$NODE_VERSION \
  --build-arg PHP_VERSION=$PHP_VERSION \
  --build-arg GO_VERSION=$GO_VERSION \
  --build-arg DART_VERSION=$DART_VERSION \
  --build-arg PYTHON_VERSION=$PYTHON_VERSION \
  --build-arg RUBY_VERSION=$RUBY_VERSION \
  --build-arg CSHARP_VERSION=$CSHARP_VERSION \
  --build-arg SWIFT_VERSION=$SWIFT_VERSION \
  -t api-clients-automation .
