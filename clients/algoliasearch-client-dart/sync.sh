#!/bin/bash

for dir in packages/*/ ; do \
  dir=${dir%/} \
  version=$(grep "^version:" "${dir}/pubspec.yaml" | sed 's/version: //') && \
  awk -v ver="$version" '{gsub(/const packageVersion = .*;/, "const packageVersion = \047"ver"\047;"); print}' "${dir}/lib/src/version.dart" > temp && mv temp "${dir}/lib/src/version.dart"; \
done
