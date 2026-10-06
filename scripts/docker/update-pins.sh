#!/bin/bash
# prints the current image digests and download checksums for everything pinned
# in scripts/docker/ and .github/actions/setup/action.yml, paste them back after a version bump
set -euo pipefail

echo "== docker image digests =="
grep -hE '^FROM ' scripts/docker/Dockerfile.* | awk '{print $2}' | cut -d@ -f1 | sort -u | while read -r ref; do
  # || true so one unresolvable ref does not abort the whole listing under set -e
  digest=$(docker buildx imagetools inspect "$ref" 2>/dev/null | awk '/^Digest:/{print $2}' || true)
  echo "${ref}@${digest:-<unresolved>}"
done

echo
echo "== sdkman archive checksums (scripts/docker/sdkman-install.sh) =="
# the sdkman installer is vendored at scripts/docker/sdkman-install.sh, re-download it from https://get.sdkman.io to update it
# hash a saved body, not a pipe: curl -sfL writes nothing on failure, and shasum of empty stdin is a real digest
# the broker redirects to the sdkman GitHub release assets; the cli zip is the same for every
# platform, the native zip is per platform, so list the platforms the base image is built for
sdkman_version=$(sed -nE 's/^SDKMAN_CLI_PIN="([0-9.]+)@.*/\1/p' scripts/docker/sdkman-install.sh)
sdkman_native_version=$(sed -nE 's/^[[:space:]]*\[linuxx64\]="v([0-9.]+)@.*/\1/p' scripts/docker/sdkman-install.sh)
for target in "sdkman/install/${sdkman_version}/linuxx64" "native/install/${sdkman_native_version}/linuxx64" "native/install/${sdkman_native_version}/linuxarm64"; do
  tmp=$(mktemp)
  if curl -sfL --retry 3 -o "$tmp" "https://api.sdkman.io/2/broker/download/${target}" && [[ -s "$tmp" ]]; then
    sum=$(shasum -a 256 "$tmp" | awk '{print $1}')
  else
    sum="<unresolved>"
  fi
  rm -f "$tmp"
  echo "${sum}  ${target}"
done

echo
echo "== tool pins (scripts/docker/Dockerfile.*, .github/actions/setup/action.yml) =="
# each pin is <release tag>@<commit of that tag> or <release tag>@<sha256 of a release asset>; after
# editing the tag by hand, paste the printed pin back over the whole value in every file that has it
while read -r name file repo kind asset; do
  tag=$(sed -nE "s/.*${name}[=:] ?(v[0-9.]+)@.*/\1/p" "$file" | head -n1)
  if [[ "$kind" == "commit" ]]; then
    digest=$(git ls-remote "https://github.com/${repo}" "refs/tags/${tag}" "refs/tags/${tag}^{}" 2>/dev/null \
      | awk '$2 ~ /\^\{\}$/ {peeled=$1} $2 !~ /\^\{\}$/ {plain=$1} END {print (peeled ? peeled : plain)}' || true)
  else
    asset="${asset//\{tag\}/$tag}"
    asset="${asset//\{version\}/${tag#v}}"
    tmp=$(mktemp)
    if curl -sfL --retry 3 -o "$tmp" "https://github.com/${repo}/releases/download/${tag}/${asset}" && [[ -s "$tmp" ]]; then
      digest=$(shasum -a 256 "$tmp" | awk '{print $1}')
    else
      digest=""
    fi
    rm -f "$tmp"
  fi
  echo "${name}=${tag}@${digest:-<unresolved>}  ${file}"
done <<'PINS'
NVM_PIN scripts/docker/Dockerfile.base nvm-sh/nvm commit -
GOLANGCI_LINT_PIN scripts/docker/Dockerfile.base golangci/golangci-lint commit -
JAVA_FORMATTER_PIN scripts/docker/Dockerfile.base google/google-java-format sha256 google-java-format-{version}-all-deps.jar
RUBYFMT_PIN_X86_64 scripts/docker/Dockerfile.ruby fables-tales/rubyfmt sha256 rubyfmt-{tag}-Linux-x86_64.tar.gz
RUBYFMT_PIN_AARCH64 scripts/docker/Dockerfile.ruby fables-tales/rubyfmt sha256 rubyfmt-{tag}-Linux-aarch64.tar.gz
PINS
