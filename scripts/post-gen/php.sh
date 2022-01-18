#!/bin/bash
set -e
export GENERATOR=$1
export CLIENT=$(cat openapitools.json | jq -r --arg generator "$GENERATOR" '."generator-cli".generators[$generator].output' | sed 's/#{cwd}\///g')

lint_client() {

    echo "> Linting ${GENERATOR}..."
    cd $CLIENT
    composer install
    PHP_CS_FIXER_IGNORE_ENV=1 php8 vendor/bin/php-cs-fixer fix lib/ -v --using-cache=no --allow-risky=yes

}

lint_client
