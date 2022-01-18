#!/bin/bash
set -e
export GENERATOR=$1
export CLIENT=$(cat openapitools.json | jq -r --arg generator "$GENERATOR" '."generator-cli".generators[$generator].output' | sed 's/#{cwd}\///g')

#Move Configuration file
mv ./$CLIENT/lib/Configuration.php ./$CLIENT/lib/Configuration/

lint_client() {

    echo "> Linting ${GENERATOR}..."
    cd $CLIENT
    composer update
    composer dump-autoload
    PHP_CS_FIXER_IGNORE_ENV=1 php8 vendor/bin/php-cs-fixer fix lib/ -v --using-cache=no --allow-risky=yes

}

lint_client
