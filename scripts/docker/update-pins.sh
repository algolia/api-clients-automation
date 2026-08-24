#!/bin/bash
# prints the current image digests and download checksums for everything pinned
# in scripts/docker/ and .github/actions/setup/action.yml, paste them back after a version bump
set -euo pipefail

echo "== docker image digests =="
grep -hE '^FROM ' scripts/docker/Dockerfile.* | awk '{print $2}' | cut -d@ -f1 | sort -u | while read -r ref; do
  digest=$(docker buildx imagetools inspect "$ref" 2>/dev/null | awk '/^Digest:/{print $2}')
  echo "${ref}@${digest:-<unresolved>}"
done

echo
echo "== download checksums =="
{
  grep -rhoE 'https://[^" ]+\.(sh|jar|tar\.gz)' scripts/docker/Dockerfile.* .github/actions/setup/action.yml | sort -u
  echo "https://get.sdkman.io"
} | while read -r url; do
  sum=$(curl -sfL --retry 3 "$url" | shasum -a 256 | awk '{print $1}')
  echo "$sum  $url"
done
