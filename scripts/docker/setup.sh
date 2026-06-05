#!/bin/bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
source "$SCRIPT_DIR/slot.sh"

export NODE_VERSION=$(cat .nvmrc)

while read line; do
  arr=($line)
  export $(echo ${arr[1]} | sed -e "s/-/_/;s/config\/\.//" | tr "[a-z]" "[A-Z]")=${arr[0]}
done < <(find config -name '.*-version' -exec jq --raw-input -r '. + " " + input_filename' {} \;)

VERSIONS_HASH=$(echo "${JAVA_VERSION}|${PYTHON_VERSION}|${GO_VERSION}|${PHP_VERSION}|${DART_VERSION}|${CSHARP_VERSION}|${NODE_VERSION}" \
  | shasum -a 256 | cut -c1-12)
RUBY_HASH=$(echo "${JAVA_VERSION}|${NODE_VERSION}|${RUBY_VERSION}" | shasum -a 256 | cut -c1-12)
SWIFT_HASH=$(echo "${JAVA_VERSION}|${NODE_VERSION}|${SWIFT_VERSION}" | shasum -a 256 | cut -c1-12)

export APIC_BASE_TAG="apic-base:${VERSIONS_HASH}"
export APIC_RUBY_TAG="apic-ruby:${RUBY_HASH}"
export APIC_SWIFT_TAG="apic-swift:${SWIFT_HASH}"

PREVIOUS_SLOT=""
if [ -f "$SLOT_FILE" ]; then
  PREVIOUS_SLOT=$(cat "$SLOT_FILE")
fi

WORKTREE_COUNT=$(git worktree list 2>/dev/null | wc -l | tr -d ' ')
if [ "$WORKTREE_COUNT" -gt 1 ]; then
  claim_slot
fi
SLOT=$(read_slot)

if [ -n "$PREVIOUS_SLOT" ] && [ "$PREVIOUS_SLOT" != "$SLOT" ]; then
  echo ""
  echo "WARNING: Slot changed from $PREVIOUS_SLOT to $SLOT."
  echo "         Re-run 'yarn cli cts generate' to update generated test ports."
  echo ""
fi

DIR_NAME=$(basename "$(pwd)" | tr '[:upper:]' '[:lower:]' | sed 's/[^a-z0-9_-]/-/g')
export COMPOSE_PROJECT_NAME="apic-${DIR_NAME}"
APIC_DEBUG_PORT=$((5009 + SLOT * PORTS_PER_SLOT))
export CTS_PORT_OFFSET=$((SLOT * PORTS_PER_SLOT))

cat > .env.docker <<EOF
COMPOSE_PROJECT_NAME=${COMPOSE_PROJECT_NAME}
CTS_PORT_OFFSET=${CTS_PORT_OFFSET}
APIC_BASE_TAG=${APIC_BASE_TAG}
APIC_RUBY_TAG=${APIC_RUBY_TAG}
APIC_SWIFT_TAG=${APIC_SWIFT_TAG}
APIC_DEBUG_PORT=${APIC_DEBUG_PORT}
JAVA_VERSION=${JAVA_VERSION}
NODE_VERSION=${NODE_VERSION}
PYTHON_VERSION=${PYTHON_VERSION}
GO_VERSION=${GO_VERSION}
PHP_VERSION=${PHP_VERSION}
DART_VERSION=${DART_VERSION}
CSHARP_VERSION=${CSHARP_VERSION}
RUBY_VERSION=${RUBY_VERSION}
SWIFT_VERSION=${SWIFT_VERSION}
EOF

needs_build=false
for tag in "$APIC_BASE_TAG" "$APIC_RUBY_TAG" "$APIC_SWIFT_TAG"; do
  if ! docker image inspect "$tag" &>/dev/null; then
    needs_build=true
    break
  fi
done

if [ "$needs_build" = true ]; then
  echo "Building Docker images..."
  docker compose build
fi

docker compose up -d

echo ""
echo "Worktree slot: $SLOT (port offset: $((SLOT * PORTS_PER_SLOT)))"
echo "Debug port: $APIC_DEBUG_PORT"
echo "Project: $COMPOSE_PROJECT_NAME"
echo "Images: $APIC_BASE_TAG | $APIC_RUBY_TAG | $APIC_SWIFT_TAG"
