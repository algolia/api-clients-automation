#!/bin/bash
# fails when a pinned FROM tag in scripts/docker/ diverges from its config/.*-version file,
# or when the digest next to that tag is not what the tag currently resolves to
set -euo pipefail

get_from() {
  local match
  match=$(grep -Eo "FROM $2:[^ ]+" "scripts/docker/$1" | head -1) || true
  if [[ -z "$match" ]]; then
    echo "no FROM $2 found in scripts/docker/$1" >&2
    return 1
  fi
  echo "${match#FROM }"
}

tag_of() {
  local ref="${1%%@*}"
  local tag="${ref#*:}"
  sed -E 's/-(alpine|trixie|jammy)$//' <<< "$tag"
}

have_docker=0
if command -v docker >/dev/null 2>&1; then
  have_docker=1
else
  echo "docker not found; skipping tag/digest resolution" >&2
fi

fail=0
check() {
  local from ref tag expected pinned live
  if ! from=$(get_from "$1" "$2"); then
    fail=1
    return
  fi
  ref="${from%%@*}"
  pinned=""
  if [[ "$from" == *@* ]]; then
    pinned="${from#*@}"
  fi
  tag=$(tag_of "$from")
  expected=$(cat "config/$3")
  if [[ "$tag" != "$expected" ]]; then
    echo "$1: $2 is pinned to $tag but config/$3 says $expected"
    echo "  -> update the FROM line in scripts/docker/$1 (scripts/docker/update-pins.sh prints the new digest)"
    fail=1
  fi
  if [[ -z "$pinned" ]]; then
    echo "$1: $2 FROM line has no digest"
    fail=1
    return
  fi
  if [[ "$have_docker" -eq 0 ]]; then
    return
  fi
  live=$(docker buildx imagetools inspect "$ref" 2>/dev/null | awk '/^Digest:/{print $2; exit}') || true
  if [[ -z "$live" ]]; then
    echo "$1: could not resolve $ref (docker buildx imagetools inspect)"
    fail=1
    return
  fi
  if [[ "$live" != "$pinned" ]]; then
    echo "$1: $ref resolves to $live but the Dockerfile pins $pinned"
    echo "  -> run scripts/docker/update-pins.sh and paste the new digest"
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
