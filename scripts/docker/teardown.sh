#!/bin/bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
source "$SCRIPT_DIR/slot.sh"

if [ ! -f .env.docker ]; then
  echo "Error: .env.docker not found. Run 'yarn docker:setup' first." >&2
  exit 1
fi

# shellcheck disable=SC2046
export $(grep '^COMPOSE_PROJECT_NAME=' .env.docker)

echo "Stopping containers for project: $COMPOSE_PROJECT_NAME"
docker compose --env-file .env.docker down --remove-orphans

release_slot

rm -f .env.docker

echo "Containers removed. Shared images preserved."
echo "To also remove images: docker image rm \$(docker images 'apic-*' -q) 2>/dev/null"
