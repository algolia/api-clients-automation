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
echo "== download checksums =="
# the sdkman installer is vendored at scripts/docker/sdkman-install.sh, re-download it from https://get.sdkman.io to update it
# hash a saved body, not a pipe: curl -sfL writes nothing on failure, and shasum of empty stdin is a real digest
grep -rhoE 'https://[^" ]+\.(sh|jar|tar\.gz)' scripts/docker/Dockerfile.* .github/actions/setup/action.yml | sort -u | while read -r url; do
  tmp=$(mktemp)
  if curl -sfL --retry 3 -o "$tmp" "$url" && [[ -s "$tmp" ]]; then
    sum=$(shasum -a 256 "$tmp" | awk '{print $1}')
  else
    sum="<unresolved>"
  fi
  rm -f "$tmp"
  echo "${sum}  $url"
done
