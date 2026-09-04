#!/bin/bash
# always fails when a pinned FROM line is missing its digest, or when a shared tool pin in the
# docker images diverges from the CI setup action.
# With DRIFT_CHECK_TAGS=1 it also fails when a pinned FROM tag diverges from its
# config/.*-version file, and with DRIFT_CHECK_LIVE=1 when a pinned digest is not what the tag
# currently resolves to. Both extras run only in the docker jobs.
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

# live digest resolution hits the registries, so it only runs where docker changes are being
# validated (DRIFT_CHECK_LIVE=1 in the docker_images job); an upstream re-push or a registry
# rate limit must not fail unrelated CI runs
check_live=${DRIFT_CHECK_LIVE:-0}
# tag-vs-config comparison only runs where a docker change is being validated
# (DRIFT_CHECK_TAGS=1): a renovate bump of config/.*-version legitimately lands before the
# Dockerfile tag is refreshed, and that must not fail the setup job every other job needs
check_tags=${DRIFT_CHECK_TAGS:-0}
if [[ "$check_live" == "1" ]] && ! command -v docker >/dev/null 2>&1; then
  echo "DRIFT_CHECK_LIVE=1 requires docker" >&2
  exit 1
fi

extract_ver() {
  local file=$1
  local regex=$2
  local content
  content=$(cat "$file")
  if [[ $content =~ $regex ]]; then
    echo "${BASH_REMATCH[1]}"
  fi
}

fail=0

# digest-only: the ref carries no config/.*-version file, so only verify it is pinned
# and (when live) that the pin still matches what the tag resolves to
check_digest() {
  local from ref pinned live
  if ! from=$(get_from "$1" "$2"); then
    fail=1
    return
  fi
  ref="${from%%@*}"
  if [[ "$from" != *@* ]]; then
    echo "$1: $2 FROM line has no digest"
    fail=1
    return
  fi
  pinned="${from#*@}"
  if [[ "$check_live" != "1" ]]; then
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
  if [[ "$check_tags" == "1" ]]; then
    tag=$(tag_of "$from")
    expected=$(cat "config/$3")
    if [[ "$tag" != "$expected" ]]; then
      echo "$1: $2 is pinned to $tag but config/$3 says $expected"
      echo "  -> update the FROM line in scripts/docker/$1 (scripts/docker/update-pins.sh prints the new digest)"
      fail=1
    fi
  fi
  if [[ -z "$pinned" ]]; then
    echo "$1: $2 FROM line has no digest"
    fail=1
    return
  fi
  if [[ "$check_live" != "1" ]]; then
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

# exact x.y.z pins only; skip a pair when action.yml still has a floating install
check_shared_pin() {
  local name=$1
  local regex=$2
  local docker_file=${3:-scripts/docker/Dockerfile.base}
  local docker_regex=${4:-$regex}
  local action_ver docker_ver
  action_ver=$(extract_ver .github/actions/setup/action.yml "$regex")
  docker_ver=$(extract_ver "$docker_file" "$docker_regex")
  if [[ -z "$action_ver" || -z "$docker_ver" ]]; then
    return
  fi
  if [[ "$action_ver" != "$docker_ver" ]]; then
    echo "$name: .github/actions/setup/action.yml has $action_ver but $docker_file has $docker_ver"
    echo "  -> keep the same version in both (scripts/docker/update-pins.sh prints checksums after a bump)"
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

# no config/.*-version file governs these two, renovate owns their versions
check_digest Dockerfile.base composer
check_digest Dockerfile.swift ghcr.io/nicklockwood/swiftformat

check_shared_pin melos 'dart pub global activate melos ([0-9]+\.[0-9]+\.[0-9]+)'
check_shared_pin poetry 'pipx install poetry==([0-9]+\.[0-9]+\.[0-9]+)'
check_shared_pin golangci-lint 'golangci-lint/v([0-9]+\.[0-9]+\.[0-9]+)/install\.sh'
check_shared_pin google-java-format 'google-java-format/releases/download/v([0-9]+\.[0-9]+\.[0-9]+)/'
check_shared_pin rubyfmt 'rubyfmt/releases/download/v([0-9]+\.[0-9]+\.[0-9]+)/' scripts/docker/Dockerfile.ruby
# the ARG that used to keep these two in one renovate manager is gone, and the docker tag and
# the CI source build now resolve from different datasources, so compare them explicitly
check_shared_pin sbt 'sbt-runner-version: ([0-9]+\.[0-9]+\.[0-9]+)' scripts/docker/Dockerfile.base 'sdk install sbt ([0-9]+\.[0-9]+\.[0-9]+)'
check_shared_pin swiftformat 'SWIFTFORMAT_VERSION=([0-9]+\.[0-9]+\.[0-9]+)' scripts/docker/Dockerfile.swift 'swiftformat:([0-9]+\.[0-9]+\.[0-9]+)@'

exit $fail
