#! /bin/bash

export NODE_VERSION=$(cat .nvmrc)
while read line; do
  arr=($line)
  export $(echo ${arr[1]} | sed -e "s/-/_/;s/config\/\.//" | tr "[a-z]" "[A-Z]")=${arr[0]}
done < <(find config -name '.*-version' -exec jq --raw-input -r '. + " " + input_filename' {} \;)

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
