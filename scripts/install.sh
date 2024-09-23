#!/usr/bin/env bash

# This scripts installs the apic cli shortcut, instead of doing `yarn cli ...` which takes a long time to start
# You can install this by running `source scripts/install.sh` or by adding this to your .bashrc/.zshrc:
# [[ -s "$HOME/<path to api-clients-automation>/scripts/install.sh" ]] && source "$HOME/<path to api-clients-automation>/scripts/install.sh"

# for extra DX you could also add the following shortcuts to your .bashrc/.zshrc:
# alias ag="apic generate"
# alias acg="apic cts generate"
# alias acr="apic cts run"

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)"

apic() {
  # this is the same as `yarn start` but without the overhead of yarn
  (cd $ROOT/scripts && NODE_NO_WARNINGS=1 node --experimental-strip-types cli/index.ts $*)
}

export apic

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
    echo "$(cat $ROOT/config/clients.config.json | jq -r --arg lang "$1" 'with_entries(select(.key == $lang)) | .[].clients | if (.[0] | type == "object") then .[].name else .[] end')"
  fi
}

_list_clients_for_language_all() {
  echo "all $(_list_clients_for_language $1)"
}

_list_clients() {
  echo "all $(cat $ROOT/config/clients.config.json | jq -r 'with_entries(select(.key == "java")) | .[] | .clients[]')"
}

_apic_lang_client_complete() {
  if [[ COMP_CWORD -eq $1 ]]; then
    COMPREPLY=($(compgen -W "$(_list_languages_all)" -- "$cur"))
  elif [[ COMP_CWORD -ge ($1 + 1) ]]; then
    lang="${COMP_WORDS[$1]}"
    COMPREPLY=($(compgen -W "$(_list_clients_for_language_all $lang)" -- "$cur"))
  fi
}

_apic_playground_complete() {
  if [[ COMP_CWORD -eq 2 ]]; then
    COMPREPLY=($(compgen -W "$(_list_languages)" -- "$cur"))
  elif [[ COMP_CWORD -eq 3 ]]; then
    COMPREPLY=($(compgen -W "$(_list_clients_for_language $lang)" -- "$cur"))
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
  if [[ COMP_CWORD -ge 3 ]]; then
    COMPREPLY=($(compgen -W "algoliasearch $(_list_clients)" -- "$cur"))
  fi
}

_apic_build_complete() {
  if [[ COMP_CWORD -eq 2 ]]; then
    COMPREPLY=($(compgen -W "clients playground snippets specs" -- "$cur"))
  else
    second="${COMP_WORDS[2]}"
    if [[ $second == "clients" ]]; then
      _apic_lang_client_complete 3
    elif [[ $second == "specs" ]]; then
      _apic_build_specs_complete
    elif [[ COMP_CWORD -eq 3 ]]; then
      COMPREPLY=($(compgen -W "$(_list_languages_all)" -- "$cur"))
    fi
  fi
}

_apic_format_complete() {
  if [[ COMP_CWORD -eq 2 ]]; then
    COMPREPLY=($(compgen -W "$(_list_languages)" -- "$cur"))
  elif [[ COMP_CWORD -eq 3 ]]; then
    COMPREPLY=($(compgen -d -S / -- "$cur"))
  fi
}

_apic_complete() {
  cur="${COMP_WORDS[COMP_CWORD]}"
  lang="${COMP_WORDS[COMP_CWORD-1]}" # initial guess, but it might be before in some commands
  if [[ COMP_CWORD -eq 1 ]]; then
    COMPREPLY=($(compgen -W "build cts exec format generate playground release snippets" -- "$cur"))
  else
    first="${COMP_WORDS[1]}"
    if [[ $first == "generate" || $first == "snippets" ]]; then
      _apic_lang_client_complete 2
    elif [[ $first == "playground" ]]; then
      _apic_playground_complete
    elif [[ $first == "format" ]]; then
      _apic_format_complete
    elif [[ $first == "build" ]]; then
      _apic_build_complete
    elif [[ $first == "cts" ]]; then
      _apic_cts_complete
    elif [[ $first == "release" && COMP_CWORD -eq 2 ]]; then
      COMPREPLY=($(compgen -W "$(_list_languages_all)" -- "$cur"))
    elif [[ $first == "exec" && COMP_CWORD -eq 2 ]]; then
      COMPREPLY=($(compgen -W "$(_list_languages)" -- "$cur"))
    fi
  fi
}

complete -F _apic_complete apic
