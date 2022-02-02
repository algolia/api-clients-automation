#!/bin/bash

if [[ ! $CI ]] && [[ ! $DOCKER ]]; then
    echo "You should run scripts via the docker container, see README.md"

    exit 1
fi

# Break on non-zero code
set -e

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)"
# Move to the root (easier to locate other scripts)
cd ${DIR}/../..

CLIENT=$1
OUTPUT=$2

mkdir -p specs/dist

stitch_global() {
    local file="specs/dist/global-ref.yml"
    # copy any header, we don't use it
    cat specs/abtesting/spec.yml | sed -n '/paths/q;p' > $file
    echo "paths:" >> $file
    # copy the paths and edit the ref because we are in dist
    for client in $CLIENTS; do
        cat specs/$client/spec.yml | sed -n '/paths:/,$p' | tail -n +2 | sed "s/\$ref: paths/\$ref: ..\/$client\/paths/" >> $file
    done
}

check_format_spec() {
    local client=$1
    echo "> Checking format of $client spec"
    yarn specs:lint $client
    echo ""
}

build_spec() {
    local client=$1
    yarn openapi bundle specs/$client/spec.yml -o specs/dist/${client}.${OUTPUT} --ext ${OUTPUT}
    echo ""
}

validate_output_spec() {
    local client=$1
    yarn openapi lint specs/dist/${client}.${OUTPUT}
    echo ""
}

CLIENTS=$(find specs/*/spec.yml | awk -F / '{ print $(NF-1) }')

if [[ $CLIENT == "all" ]]; then
    : # no-op
elif [[ $CLIENT == "global" ]]; then
    echo "> Building global spec"
    stitch_global

    yarn openapi bundle specs/dist/global-ref.yml -o specs/dist/global.${OUTPUT} --ext ${OUTPUT}
    yarn openapi lint specs/dist/global.${OUTPUT}

    exit 0
elif [[ ${CLIENTS[*]} =~ ${CLIENT} ]]; then
    CLIENTS=($CLIENT)
else
    echo "Unknown spec ${CLIENT}"
    exit 1
fi

if [[ $OUTPUT != "yml" ]] && [[ $OUTPUT != "json" ]]; then
    echo "Unknown output ${OUTPUT}"
    exit 1
fi

for client in $CLIENTS; do
    check_format_spec $client
    build_spec $client
    validate_output_spec $client
done
