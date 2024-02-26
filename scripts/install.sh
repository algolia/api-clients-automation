#!/usr/bin/env bash

# This scripts installs the apic cli shortcut, instead of doing `yarn cli ...` which takes a long time to start
# You can install this by running `source scripts/install.sh` or by adding this to your .bashrc/.zshrc:
# [[ -s "$HOME/<path to api-clients-automation>/scripts/install.sh" ]] && source "$HOME/<path to api-clients-automation>/scripts/install.sh"

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)"

apic() {
  (cd scripts && NODE_NO_WARNINGS=1 node dist/scripts/cli/index.js $*)
}

apicb() {
  (cd scripts && yarn build:cli && NODE_NO_WARNINGS=1 node dist/scripts/cli/index.js $*)
}

export apic
export apicb

_list_languages() {
  cat $ROOT/config/clients.config.json | jq -r 'keys[]'
}

_list_languages_all() {
  echo "all $(_list_languages)"
}

_list_clients_for_language() {
  if [[ $1 == "all" ]]; then
    _list_clients
  else
    echo "all $(cat $ROOT/config/clients.config.json | jq -r --arg lang "$1" 'with_entries(select(.key == $lang)) | .[].clients | if (.[0] | type == "object") then .[].name else .[] end')"
  fi
}

_list_clients() {
  echo "all $(cat $ROOT/config/clients.config.json | jq -r 'with_entries(select(.key == "java")) | .[] | .clients[]')"
}

_apic_lang_client_complete() {
  if [[ COMP_CWORD -eq $1 ]]; then
    COMPREPLY=($(compgen -W "$(_list_languages_all)" -- "$cur"))
  elif [[ COMP_CWORD -eq ($1 + 1) ]]; then
    COMPREPLY=($(compgen -W "$(_list_clients_for_language $prev)" -- "$cur"))
  fi
}

_apic_cts_complete() {
  if [[ COMP_CWORD -eq 2 ]]; then
    COMPREPLY=($(compgen -W "generate run server" -- "$cur"))
  else
    second="${COMP_WORDS[2]}"
    if [[ $second == "generate" || $second == "run" ]]; then
      _apic_lang_client_complete 3
    fi
  fi
}

_apic_build_specs_complete() {
  if [[ COMP_CWORD -eq 3 ]]; then
    COMPREPLY=($(compgen -W "algoliasearch $(_list_clients)" -- "$cur"))
  fi
}

_apic_build_complete() {
  if [[ COMP_CWORD -eq 2 ]]; then
    COMPREPLY=($(compgen -W "clients specs" -- "$cur"))
  else
    second="${COMP_WORDS[2]}"
    if [[ $second == "clients" ]]; then
      _apic_lang_client_complete 3
    elif [[ $second == "specs" ]]; then
      _apic_build_specs_complete
    fi
  fi
}

_apic_format_complete() {
  if [[ COMP_CWORD -eq 2 ]]; then
    COMPREPLY=($(compgen -W "$(_list_languages)" -- "$cur"))
  elif [[ COMP_CWORD -eq 3 ]]; then
    COMPREPLY=($(compgen -d -- "$cur"))
  fi
}

_apic_complete() {
  cur="${COMP_WORDS[COMP_CWORD]}"
  prev="${COMP_WORDS[COMP_CWORD-1]}"
  if [[ COMP_CWORD -eq 1 ]]; then
    COMPREPLY=($(compgen -W "generate build cts playground format snippets" -- "$cur"))
  else
    first="${COMP_WORDS[1]}"
    if [[ $first == "generate" || $first == "playground" || $first == "snippets" ]]; then
      _apic_lang_client_complete 2
    elif [[ $first == "format" ]]; then
      _apic_format_complete
    elif [[ $first == "build" ]]; then
      _apic_build_complete
    elif [[ $first == "cts" ]]; then
      _apic_cts_complete
    fi
  fi
}

complete -F _apic_complete apic
complete -F _apic_complete apicb
