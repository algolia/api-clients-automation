#!/bin/bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
source "$SCRIPT_DIR/slot.sh"

DIR_NAME=$(basename "$(pwd)" | tr '[:upper:]' '[:lower:]' | sed 's/[^a-z0-9_-]/-/g')
export COMPOSE_PROJECT_NAME="apic-${DIR_NAME}"

echo "Stopping containers for project: $COMPOSE_PROJECT_NAME"
docker compose --env-file .env.docker down --remove-orphans

WORKTREE_COUNT=$(git worktree list 2>/dev/null | wc -l | tr -d ' ')
if [ "$WORKTREE_COUNT" -gt 1 ]; then
  release_slot
fi

rm -f .env.docker

echo "Containers removed. Shared images preserved."
echo "To also remove images: docker image rm \$(docker images 'apic-*' -q) 2>/dev/null"
