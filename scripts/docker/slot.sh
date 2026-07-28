#!/bin/bash
# Worktree slot management for multi-worktree Docker isolation.
# Each worktree gets a unique slot number (0, 1, 2, ...) that determines:
# - the per-slot port block offset: slot * PORTS_PER_SLOT
# - the Docker Compose project name (so containers/networks don't collide)
#
# Slot assignments live in a central registry at ~/.config/apic/worktree-slots.json,
# keyed by absolute worktree path. There is no per-worktree file.

REGISTRY_DIR="$HOME/.config/apic"
REGISTRY_FILE="$REGISTRY_DIR/worktree-slots.json"
LOCK_DIR="$REGISTRY_DIR/.slot-lock"

# scripts/cts/testServer/ports.ts is the single source of truth for the port block.
# PORTS_PER_SLOT = number of entries; DEBUG_PORT = the `debug` entry's value.
# Both are also read by the scripts that source this file (setup.sh).
SLOT_SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PORTS_FILE="$SLOT_SCRIPT_DIR/../cts/testServer/ports.ts"
PORTS_PER_SLOT=$(grep -cE '^[[:space:]]+[A-Za-z0-9_]+:[[:space:]]*[0-9]+,' "$PORTS_FILE")
# shellcheck disable=SC2034  # consumed by setup.sh after sourcing
DEBUG_PORT=$(grep -oE 'debug:[[:space:]]*[0-9]+' "$PORTS_FILE" | grep -oE '[0-9]+')

acquire_lock() {
  local max_attempts=30
  local attempt=0

  if [ -d "$LOCK_DIR" ]; then
    local lock_age
    lock_age=$(( $(date +%s) - $(stat -f %m "$LOCK_DIR" 2>/dev/null || stat -c %Y "$LOCK_DIR" 2>/dev/null || echo 0) ))
    if [ "$lock_age" -gt 60 ]; then
      echo "Removing stale lock (${lock_age}s old)"
      rmdir "$LOCK_DIR" 2>/dev/null
    fi
  fi

  while ! mkdir "$LOCK_DIR" 2>/dev/null; do
    attempt=$((attempt + 1))
    if [ "$attempt" -ge "$max_attempts" ]; then
      echo "Error: Could not acquire slot lock after ${max_attempts}s" >&2
      exit 1
    fi
    sleep 1
  done
  trap 'rmdir "$LOCK_DIR" 2>/dev/null' EXIT
}

release_lock() {
  rmdir "$LOCK_DIR" 2>/dev/null
  trap - EXIT
}

ensure_registry() {
  mkdir -p "$REGISTRY_DIR"
  if [ ! -f "$REGISTRY_FILE" ]; then
    echo '{}' > "$REGISTRY_FILE"
  fi
}

cleanup_stale_entries() {
  local paths
  paths=$(jq -r 'keys[]' "$REGISTRY_FILE")

  local tmp_file
  tmp_file=$(mktemp)
  cp "$REGISTRY_FILE" "$tmp_file"

  while IFS= read -r p; do
    [ -z "$p" ] && continue
    if [ ! -d "$p" ] || { [ ! -d "$p/.git" ] && [ ! -f "$p/.git" ]; }; then
      jq --arg path "$p" 'del(.[$path])' "$tmp_file" > "${tmp_file}.new" && mv "${tmp_file}.new" "$tmp_file"
      echo "Cleaned stale slot entry: $p"
    fi
  done <<< "$paths"

  mv "$tmp_file" "$REGISTRY_FILE"
}

# Claim the lowest available slot, recording it in the central registry.
claim_slot() {
  local worktree_path
  worktree_path=$(pwd -P)

  ensure_registry
  acquire_lock
  cleanup_stale_entries

  local existing
  existing=$(jq -r --arg path "$worktree_path" '.[$path] // empty' "$REGISTRY_FILE")
  if [ -n "$existing" ]; then
    release_lock
    return
  fi

  local used_slots slot
  used_slots=$(jq -r 'values[]' "$REGISTRY_FILE" | sort -n)
  slot=0
  while echo "$used_slots" | grep -q "^${slot}$"; do
    slot=$((slot + 1))
  done

  jq --arg path "$worktree_path" --argjson slot "$slot" '. + {($path): $slot}' "$REGISTRY_FILE" > "${REGISTRY_FILE}.tmp" \
    && mv "${REGISTRY_FILE}.tmp" "$REGISTRY_FILE"

  release_lock
  echo "Claimed slot $slot (port offset: $((slot * PORTS_PER_SLOT)))"
}

# Read the current worktree's slot from the registry. Returns 0 when unregistered (e.g. CI).
read_slot() {
  if [ -f "$REGISTRY_FILE" ]; then
    jq -r --arg path "$(pwd -P)" '.[$path] // 0' "$REGISTRY_FILE"
  else
    echo "0"
  fi
}

# Release the current worktree's slot from the registry.
release_slot() {
  local worktree_path
  worktree_path=$(pwd -P)

  ensure_registry
  acquire_lock

  jq --arg path "$worktree_path" 'del(.[$path])' "$REGISTRY_FILE" > "${REGISTRY_FILE}.tmp" \
    && mv "${REGISTRY_FILE}.tmp" "$REGISTRY_FILE"

  release_lock

  echo "Released slot for $worktree_path"
}
