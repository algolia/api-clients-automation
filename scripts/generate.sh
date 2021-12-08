#!/bin/bash

# Break on non-zero code
set -e

LANGUAGE=$1
CLIENT=$2

LANGUAGES=(javascript)
CLIENTS=(search recommend personalization)

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)"
# Move to the root (easier to locate other scripts)
cd ${DIR}/..

generate_client() {
    local lang=$1
    local client=$2
    echo "Generating code for ${lang}-${client}"
    yarn openapi-generator-cli generate --generator-key "${lang}-${client}"
    
    # run the post generation script if it exists (linting and additional files)
    local postgen="./scripts/post-gen/${lang}.sh"
    if [[ -f "$postgen" ]]; then
        $postgen $client
    fi
}

if [[ $LANGUAGE == "all" ]]; then
    LANGUAGE=("${LANGUAGES[@]}")
elif [[ " ${LANGUAGES[*]} " =~ " ${LANGUAGE} " ]]; then
    LANGUAGE=($LANGUAGE)
else
    echo "Unknown language ${LANGUAGE}"
    exit 1
fi

if [[ $CLIENT == "all" ]]; then
    CLIENT=("${CLIENTS[@]}")
elif [[ " ${CLIENTS[*]} " =~ " ${CLIENT} " ]]; then
    CLIENT=($CLIENT)
else
    echo "Unknown client ${CLIENT}"
    exit 1
fi

for lang in "${LANGUAGE[@]}"; do
    for client in "${CLIENT[@]}"; do
        generate_client $lang $client
    done
done
