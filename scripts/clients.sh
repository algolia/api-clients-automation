#!/bin/bash

# Break on non-zero code
set -e

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)"
# Move to the root (easier to locate other scripts)
cd ${DIR}/..

lang=$1
client=$2
package=$3

# Commands are based on the lang
build_client(){
    if [[ $lang == 'javascript' ]]; then
        local generator="$lang-$client"

        echo "> Building $generator..."

        yarn workspace $package build
    fi
}

if [[ ! $package ]]; then
    echo "Unknown package ${package}"
    exit 1
fi

build_client
