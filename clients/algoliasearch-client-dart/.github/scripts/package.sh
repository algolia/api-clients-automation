#!/bin/bash

TAG_NAME=${GITHUB_REF#refs/tags/}
PACKAGE_NAME=${TAG_NAME%-*}
if [ "$PACKAGE_NAME" = "algoliasearch" ]; then
  echo "package-dir=packages/algoliasearch" >> "$GITHUB_OUTPUT"
else
  echo "package-dir=packages/client_${PACKAGE_NAME}" >> "$GITHUB_OUTPUT"
fi
