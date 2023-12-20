#!/usr/bin/env bash

# This scripts installs the apic cli shortcut, instead of doing `yarn docker ...` which takes a long time to start
# You can install this by running `source scripts/install.sh` or by adding this to your .bashrc/.zshrc:
# [[ -s "$HOME/<path to api-clients-automation>/scripts/install.sh" ]] && source "$HOME/<path to api-clients-automation>/scripts/install.sh"

export apic() {
  docker exec -it api-clients-automation bash -lc "cd scripts && NODE_NO_WARNINGS=1 node dist/scripts/cli/index.js $*";
}

