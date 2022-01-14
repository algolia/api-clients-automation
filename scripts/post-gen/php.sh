#!/bin/bash

export GENERATOR=$1
export CLIENT=$(cat openapitools.json | jq -r --arg generator "$GENERATOR" '."generator-cli".generators[$generator].output' | sed 's/#{cwd}\///g')

lint_client() {
    set +e

    echo "> Linting ${GENERATOR}..."
    cd $CLIENT
    composer install
    PHP_CS_FIXER_IGNORE_ENV=1 php vendor/bin/php-cs-fixer fix lib/ -v --using-cache=no --allow-risky=yes

    set -e
}

lint_client
