#!/bin/bash
# always fails when a pinned FROM line is missing its digest, when a tool pin appears twice with
# different values (the docker images vs the CI setup action), when a tool pin or a pinned download
# has no `# renovate:` annotation (see scripts/docker/tool-pins.sh), or when the sdkman or tool pins
# are malformed.
# With DRIFT_CHECK_TAGS=1 it also fails when a pinned FROM tag diverges from its
# config/.*-version file. With DRIFT_CHECK_LIVE=1 it resolves every pinned ref against its
# registry: a tag that does not exist fails, a digest that no longer matches the tag only warns,
# because upstream rebuilds under an unchanged tag and the renovate pinDigests rule is what
# refreshes the pin, not the PR that happens to be open; it also hashes the sdkman archives and the
# tool release assets, which are immutable, and resolves the tool tags to their commits, so a
# mismatch there fails. Both extras run only in the docker jobs.
set -euo pipefail

# shellcheck source=scripts/docker/tool-pins.sh
source scripts/docker/tool-pins.sh

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
  local docker_file=$3
  local docker_regex=$4
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

# every tool pin must be annotated so renovate and the checks below see it; these fail closed, a
# pin or a download that escapes the annotations would silently stop being updated and verified
check_pin_coverage() {
  local file name url line
  local files
  files=$(pin_files)
  # 1. a pin line without the annotation directly above it
  while read -r file name; do
    echo "$file: $name has no \`# renovate:\` annotation above it (see scripts/docker/tool-pins.sh)"
    fail=1
  done < <(
    # shellcheck disable=SC2086
    awk '
      FNR == 1 { ann = 0 }
      /^[[:space:]]*# renovate:/ { ann = 1; next }
      match($0, /[A-Z0-9_]+_PIN[A-Z0-9_]*[=:] ?v[0-9]/) {
        if (!ann) { name = substr($0, RSTART, RLENGTH); sub(/[=:].*/, "", name); print FILENAME, name }
        ann = 0
        next
      }
      { ann = 0 }
    ' $files
  )
  # 2. an annotation renovate would not match: it only accepts this exact shape (see tool-pins.sh)
  while IFS= read -r line; do
    file="${line%%:*}"
    line="${line#*:}"
    if [[ "$line" =~ ^[[:space:]]*'# renovate: datasource=github-tags depName='[^[:space:]]+$ ]]; then
      continue
    fi
    if [[ "$line" =~ ^[[:space:]]*'# renovate: datasource=github-release-attachments depName='[^[:space:]]+' asset='[^[:space:]]+$ ]]; then
      continue
    fi
    echo "$file: invalid annotation \`${line#"${line%%#*}"}\`, expected \`# renovate: datasource=github-tags depName=<owner/repo>\` or \`# renovate: datasource=github-release-attachments depName=<owner/repo> asset=<template>\`, in that order with nothing else on the line (see scripts/docker/tool-pins.sh)"
    fail=1
  done < <(
    # shellcheck disable=SC2086
    { grep -HE '^[[:space:]]*# renovate:' $files || true; }
  )
  # 3. a url that is not built from a pin. a statement is a Dockerfile instruction with its \ continuations
  # joined, or a whole step of the setup action; every http(s) url in it must use variables only, each one
  # either a *_PIN or assigned inside that same statement, and the statement must reference a *_PIN
  local stmt urls var vars ok
  while IFS=$'\t' read -r file stmt; do
    urls=$({ grep -oE "https?://[^\"' )]+" <<< "$stmt" || true; })
    [[ -z "$urls" ]] && continue
    while IFS= read -r url; do
      ok=1
      [[ "$url" == *'$'* ]] || ok=0
      [[ "$stmt" =~ [A-Z0-9_]+_PIN[A-Z0-9_]* ]] || ok=0
      vars=$({ grep -oE '[$][{]?[A-Za-z_][A-Za-z0-9_]*' <<< "$url" || true; } | sed -E 's/^[$][{]?//')
      for var in $vars; do
        [[ "$var" =~ _PIN ]] && continue
        [[ "$stmt" =~ (^|[^A-Za-z0-9_])${var}= ]] && continue
        ok=0
      done
      if [[ "$ok" != "1" ]]; then
        echo "$file: $url is downloaded without a pin, pin it as <tag>@<digest> with a \`# renovate:\` annotation (see scripts/docker/tool-pins.sh)"
        fail=1
      fi
    done <<< "$urls"
  done < <(
    # shellcheck disable=SC2086
    awk '
      function flush() { if (stmt ~ /[^[:space:]]/) print cur "\t" stmt; stmt = ""; cont = 0 }
      FNR == 1 { flush(); cur = FILENAME; yaml = (FILENAME ~ /\.ya?ml$/) }
      /^[[:space:]]*#/ { next }
      yaml && /^[[:space:]]*- (name|uses):/ { flush() }
      {
        line = $0
        if (!yaml) {
          if (!cont) flush()
          cont = sub(/\\[[:space:]]*$/, "", line)
        }
        stmt = stmt " " line
      }
      END { flush() }
    ' $files
  )
}

# the same pin in several files (the docker images and the setup action) must be identical, and
# every pin of the same tool must be on the same tag (rubyfmt has one archive checksum per platform)
check_shared_tool_pins() {
  local rows=$1 name file repo pin
  local seen="" mismatches
  while read -r name file repo _; do
    pin=$(extract_ver "$file" "${name}[=:] ?(v[0-9]+\.[0-9]+\.[0-9]+@[a-f0-9]+)")
    [[ -n "$pin" ]] && seen+="${name} ${file} ${repo} ${pin}"$'\n'
  done <<< "$rows"
  mismatches=$(awk '
    {
      if (($1 in pin) && pin[$1] != $4) print $1 ": " pfile[$1] " has " pin[$1] " but " $2 " has " $4
      if (!($1 in pin)) { pin[$1] = $4; pfile[$1] = $2 }
      tag = $4; sub(/@.*/, "", tag)
      if (($3 in dtag) && dtag[$3] != tag) print $3 ": " dname[$3] " is on " dtag[$3] " but " $1 " in " $2 " is on " tag
      if (!($3 in dtag)) { dtag[$3] = tag; dname[$3] = $1 " in " $2 }
    }
  ' <<< "$seen")
  if [[ -n "$mismatches" ]]; then
    echo "$mismatches"
    echo "  -> keep the same version in every file (scripts/docker/update-pins.sh prints checksums after a bump)"
    echo "  -> on a renovate PR this is a half group: tick its rebase box on the Dependency Dashboard instead of pushing to the branch"
    fail=1
  fi
}

# the tool pins are <release tag>@<commit of that tag> (installer scripts fetched by commit) or
# <release tag>@<sha256 of a release asset>; renovate moves both halves together, so parse them here
# so a mangled pin fails setup, and (when live) resolve them so a stale commit or checksum fails the
# cheap job instead of the image build or a language job
check_tool_pins() {
  local name file repo kind asset digest_re pin tag want got tmp rows
  rows=$(tool_pins)
  if [[ -z "$rows" ]]; then
    echo "no annotated tool pins found (see scripts/docker/tool-pins.sh)"
    fail=1
    return
  fi
  check_shared_tool_pins "$rows"
  while read -r name file repo kind asset; do
    # an invalid annotation is reported by check_pin_coverage
    if [[ "$kind" == "invalid" ]]; then
      continue
    fi
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
        got=$(git ls-remote "https://github.com/${repo}" "refs/tags/${tag}" "refs/tags/${tag}^{}" 2>/dev/null </dev/null \
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
    if curl -sfL --retry 3 -o "$tmp" "https://github.com/${repo}/releases/download/${tag}/${asset}" </dev/null && [[ -s "$tmp" ]]; then
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
  done <<< "$rows"
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

# the ARG that used to keep these two in one renovate manager is gone, and the docker tag and
# the CI source build now resolve from different datasources, so compare them explicitly
check_shared_pin swiftformat 'SWIFTFORMAT_VERSION=([0-9]+\.[0-9]+\.[0-9]+)' scripts/docker/Dockerfile.swift 'swiftformat:([0-9]+\.[0-9]+\.[0-9]+)@'

check_sdkman_pins
check_pin_coverage
check_tool_pins

exit $fail
