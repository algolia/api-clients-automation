#!/bin/bash
# always fails when a pinned FROM line is missing its digest, when a shared tool pin in the
# docker images diverges from the CI setup action, or when the sdkman or tool pins are malformed.
# With DRIFT_CHECK_TAGS=1 it also fails when a pinned FROM tag diverges from its
# config/.*-version file. With DRIFT_CHECK_LIVE=1 it resolves every pinned ref against its
# registry: a tag that does not exist fails, a digest that no longer matches the tag only warns,
# because upstream rebuilds under an unchanged tag and the renovate pinDigests rule is what
# refreshes the pin, not the PR that happens to be open; it also hashes the sdkman archives and the
# tool release assets, which are immutable, and resolves the tool tags to their commits, so a
# mismatch there fails. Both extras run only in the docker jobs.
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
# validated (DRIFT_CHECK_LIVE=1 in the docker_digests job); a registry rate limit must not fail
# unrelated CI runs
check_live=${DRIFT_CHECK_LIVE:-0}
# tag-vs-config comparison only runs where a docker change is being validated
# (DRIFT_CHECK_TAGS=1): renovate groups a config/.*-version bump with the matching Dockerfile
# tag, but the image can publish after the upstream release, so the group PR may briefly carry
# only the config half, and that must not fail the setup job every other job needs
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
  warn_if_stale "$1" "$ref" "$pinned" "$live"
}

# upstream rebuilt the tag since it was pinned; not this PR's doing, renovate refreshes the digest
warn_if_stale() {
  local file=$1 ref=$2 pinned=$3 live=$4
  if [[ "$live" != "$pinned" ]]; then
    echo "::warning file=scripts/docker/$file::$ref resolves to $live but the Dockerfile pins $pinned, renovate will refresh it (or run scripts/docker/update-pins.sh)"
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
      echo "  -> on a renovate PR this is a half group: tick its rebase box on the Dependency Dashboard instead of pushing to the branch"
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
  warn_if_stale "$1" "$ref" "$pinned" "$live"
}

# a tool pinned in both the docker images and the setup action must point at the same release in
# both files, otherwise CI and the local images silently run different versions of it
check_shared_pin() {
  local name=$1
  local regex=$2
  local docker_file=${3:-scripts/docker/Dockerfile.base}
  local docker_regex=${4:-$regex}
  local action_ver docker_ver
  action_ver=$(extract_ver .github/actions/setup/action.yml "$regex")
  docker_ver=$(extract_ver "$docker_file" "$docker_regex")
  # fail closed: every pair below is a pin this script asserts exists, so a missing match means
  # the pin was removed or renamed, which would otherwise silently disable its comparison
  if [[ -z "$action_ver" ]]; then
    echo "$name: no pinned version found in .github/actions/setup/action.yml"
    fail=1
    return
  fi
  if [[ -z "$docker_ver" ]]; then
    echo "$name: no pinned version found in $docker_file"
    fail=1
    return
  fi
  if [[ "$action_ver" != "$docker_ver" ]]; then
    echo "$name: .github/actions/setup/action.yml has $action_ver but $docker_file has $docker_ver"
    echo "  -> keep the same version in both (scripts/docker/update-pins.sh prints checksums after a bump)"
    echo "  -> on a renovate PR this is a half group: tick its rebase box on the Dependency Dashboard instead of pushing to the branch"
    fail=1
  fi
}

# the installer verifies these at build time, deep inside the base image build; parse them here so a
# mangled pin fails setup, and (when live) hash the archives so a stale checksum fails the cheap job
check_sdkman_pins() {
  local file=scripts/docker/sdkman-install.sh
  local cli native_x64 native_arm64 native_version target expected tmp sum
  cli=$(sed -nE 's/^SDKMAN_CLI_PIN="([0-9.]+@[a-f0-9]{64})"$/\1/p' "$file")
  native_x64=$(sed -nE 's/^[[:space:]]*\[linuxx64\]="(v[0-9.]+@[a-f0-9]{64})"$/\1/p' "$file")
  native_arm64=$(sed -nE 's/^[[:space:]]*\[linuxarm64\]="(v[0-9.]+@[a-f0-9]{64})"$/\1/p' "$file")
  if [[ -z "$cli" || -z "$native_x64" || -z "$native_arm64" ]]; then
    echo "$file: expected SDKMAN_CLI_PIN and the linuxx64/linuxarm64 native pins as <tag>@<sha256>"
    fail=1
    return
  fi
  if [[ "${native_x64%%@*}" != "${native_arm64%%@*}" ]]; then
    echo "$file: the native pins disagree (linuxx64 ${native_x64%%@*}, linuxarm64 ${native_arm64%%@*})"
    fail=1
    return
  fi
  if [[ "$check_live" != "1" ]]; then
    return
  fi
  native_version="${native_x64%%@*}"
  native_version="${native_version#v}"
  while read -r target expected; do
    tmp=$(mktemp)
    if curl -sfL --retry 3 -o "$tmp" "https://api.sdkman.io/2/broker/download/${target}" && [[ -s "$tmp" ]]; then
      sum=$(sha256sum "$tmp" | awk '{print $1}')
      if [[ "$sum" != "$expected" ]]; then
        echo "$file: ${target} hashes to ${sum} but the pin says ${expected}"
        echo "  -> refresh the pin (scripts/docker/update-pins.sh prints it)"
        fail=1
      fi
    else
      echo "$file: could not download ${target}"
      fail=1
    fi
    rm -f "$tmp"
  done <<EOF
sdkman/install/${cli%%@*}/linuxx64 ${cli#*@}
native/install/${native_version}/linuxx64 ${native_x64#*@}
native/install/${native_version}/linuxarm64 ${native_arm64#*@}
EOF
}

# the tool pins are <release tag>@<commit of that tag> (installer scripts fetched by commit) or
# <release tag>@<sha256 of a release asset>; renovate moves both halves together, so parse them here
# so a mangled pin fails setup, and (when live) resolve them so a stale commit or checksum fails the
# cheap job instead of the image build or a language job
check_tool_pins() {
  local name file repo kind asset digest_re pin tag want got tmp
  while read -r name file repo kind asset; do
    if [[ "$kind" == "commit" ]]; then digest_re='[a-f0-9]{40}'; else digest_re='[a-f0-9]{64}'; fi
    pin=$(extract_ver "$file" "${name}[=:] ?(v[0-9]+\.[0-9]+\.[0-9]+@${digest_re})")
    if [[ -z "$pin" ]]; then
      echo "$file: expected ${name} as <tag>@<${kind}>"
      fail=1
      continue
    fi
    if [[ "$check_live" != "1" ]]; then
      continue
    fi
    tag="${pin%@*}"
    want="${pin#*@}"
    if [[ "$kind" == "commit" ]]; then
      # an annotated tag lists its commit on the peeled ^{} line, a lightweight tag only has the plain line;
      # retried like the curl downloads so a network blip does not fail the job
      got=""
      for _ in 1 2 3; do
        got=$(git ls-remote "https://github.com/${repo}" "refs/tags/${tag}" "refs/tags/${tag}^{}" 2>/dev/null \
          | awk '$2 ~ /\^\{\}$/ {peeled=$1} $2 !~ /\^\{\}$/ {plain=$1} END {print (peeled ? peeled : plain)}') || true
        [[ -n "$got" ]] && break
        sleep 2
      done
      if [[ -z "$got" ]]; then
        echo "$file: could not resolve ${repo} tag ${tag}"
        fail=1
      elif [[ "$got" != "$want" ]]; then
        echo "$file: ${name} ${tag} points at ${got} but the pin says ${want}"
        echo "  -> refresh the pin (scripts/docker/update-pins.sh prints it)"
        fail=1
      fi
      continue
    fi
    asset="${asset//\{tag\}/$tag}"
    asset="${asset//\{version\}/${tag#v}}"
    tmp=$(mktemp)
    if curl -sfL --retry 3 -o "$tmp" "https://github.com/${repo}/releases/download/${tag}/${asset}" && [[ -s "$tmp" ]]; then
      got=$(sha256sum "$tmp" | awk '{print $1}')
      if [[ "$got" != "$want" ]]; then
        echo "$file: ${asset} hashes to ${got} but the pin says ${want}"
        echo "  -> refresh the pin (scripts/docker/update-pins.sh prints it)"
        fail=1
      fi
    else
      echo "$file: could not download ${repo} ${tag} ${asset}"
      fail=1
    fi
    rm -f "$tmp"
  done <<'EOF'
NVM_PIN scripts/docker/Dockerfile.base nvm-sh/nvm commit -
GOLANGCI_LINT_PIN scripts/docker/Dockerfile.base golangci/golangci-lint commit -
GOLANGCI_LINT_PIN .github/actions/setup/action.yml golangci/golangci-lint commit -
JAVA_FORMATTER_PIN scripts/docker/Dockerfile.base google/google-java-format sha256 google-java-format-{version}-all-deps.jar
JAVA_FORMATTER_PIN .github/actions/setup/action.yml google/google-java-format sha256 google-java-format-{version}-all-deps.jar
RUBYFMT_PIN_X86_64 scripts/docker/Dockerfile.ruby fables-tales/rubyfmt sha256 rubyfmt-{tag}-Linux-x86_64.tar.gz
RUBYFMT_PIN_AARCH64 scripts/docker/Dockerfile.ruby fables-tales/rubyfmt sha256 rubyfmt-{tag}-Linux-aarch64.tar.gz
RUBYFMT_PIN_X86_64 .github/actions/setup/action.yml fables-tales/rubyfmt sha256 rubyfmt-{tag}-Linux-x86_64.tar.gz
EOF
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

check_shared_pin golangci-lint 'GOLANGCI_LINT_PIN[=:] ?(v[0-9]+\.[0-9]+\.[0-9]+@[a-f0-9]{40})'
check_shared_pin google-java-format 'JAVA_FORMATTER_PIN[=:] ?(v[0-9]+\.[0-9]+\.[0-9]+@[a-f0-9]{64})'
check_shared_pin rubyfmt 'RUBYFMT_PIN_X86_64[=:] ?(v[0-9]+\.[0-9]+\.[0-9]+@[a-f0-9]{64})' scripts/docker/Dockerfile.ruby
# the aarch64 archive is only used by the image, its own checksum differs, so only the tag has to agree
check_shared_pin rubyfmt-aarch64 'RUBYFMT_PIN_X86_64[=:] ?(v[0-9]+\.[0-9]+\.[0-9]+)@' scripts/docker/Dockerfile.ruby 'RUBYFMT_PIN_AARCH64[=:] ?(v[0-9]+\.[0-9]+\.[0-9]+)@'
# the ARG that used to keep these two in one renovate manager is gone, and the docker tag and
# the CI source build now resolve from different datasources, so compare them explicitly
check_shared_pin swiftformat 'SWIFTFORMAT_VERSION=([0-9]+\.[0-9]+\.[0-9]+)' scripts/docker/Dockerfile.swift 'swiftformat:([0-9]+\.[0-9]+\.[0-9]+)@'

check_sdkman_pins
check_tool_pins

exit $fail
