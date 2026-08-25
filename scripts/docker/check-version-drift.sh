#!/bin/bash
# fails when a pinned FROM tag in scripts/docker/ diverges from its config/.*-version file
set -euo pipefail

get_tag() {
  grep -Eo "FROM $2:[^@ ]+" "scripts/docker/$1" | head -1 | sed -E "s,FROM $2:,,;s,-(alpine|trixie|jammy)$,,"
}

fail=0
check() {
  local tag expected
  tag=$(get_tag "$1" "$2")
  expected=$(cat "config/$3")
  if [[ "$tag" != "$expected" ]]; then
    echo "$1: $2 is pinned to $tag but config/$3 says $expected"
    echo "  -> update the FROM line in scripts/docker/$1 (scripts/docker/update-pins.sh prints the new digest)"
    fail=1
  fi
}

check Dockerfile.base dart .dart-version
check Dockerfile.base mcr.microsoft.com/dotnet/sdk .csharp-version
check Dockerfile.base golang .go-version
check Dockerfile.base python .python-version
check Dockerfile.base php .php-version
check Dockerfile.ruby ruby .ruby-version
check Dockerfile.swift swift .swift-version

exit $fail
