#! /bin/bash

# Authenticate to the GitHub Container Registry so private images can be pulled.
# Skips when already logged in, and degrades gracefully when gh is missing or unauthenticated.
if ! command -v gh >/dev/null 2>&1; then
  echo "Skipping ghcr.io login: gh (GitHub CLI) is not installed."
else
  docker_config="${DOCKER_CONFIG:-$HOME/.docker}/config.json"
  if [ -f "$docker_config" ] && jq -e '(.auths // {}) | has("ghcr.io")' "$docker_config" >/dev/null 2>&1; then
    echo "Already logged in to ghcr.io, skipping docker login."
  elif ! gh auth status >/dev/null 2>&1; then
    echo "Skipping ghcr.io login: not authenticated with gh (run 'gh auth login')."
  else
    gh auth token | docker login ghcr.io -u "$(gh api user --jq .login)" --password-stdin
  fi
fi

export NODE_VERSION=$(cat .nvmrc)

while read line; do
  arr=($line)
  export $(echo ${arr[1]} | sed -e "s/-/_/;s/config\/\.//" | tr "[a-z]" "[A-Z]")=${arr[0]}
done < <(find config -name '.*-version' -exec jq --raw-input -r '. + " " + input_filename' {} \;)

docker compose up -d --build
