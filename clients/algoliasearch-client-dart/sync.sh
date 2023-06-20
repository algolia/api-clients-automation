#!/bin/bash

for dir in packages/*/ ; do
  dir=${dir%/}
  version=$(grep "^version:" "${dir}/pubspec.yaml" | sed 's/version: //') &&
  if [[ "$(uname)" == "Darwin" ]]; then \
    sed -i '' -e "s/^const packageVersion = .*;$/const packageVersion = '$version';/" "${dir}/lib/src/version.dart";
  else
    sed -i -e "s/^const packageVersion = .*;$/const packageVersion = '$version';/" "${dir}/lib/src/version.dart";
  fi;
done
