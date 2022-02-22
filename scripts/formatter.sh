#!/bin/bash

# Break on non-zero code
set -e

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)"
# Move to the root (easier to locate other scripts)
cd ${DIR}/..

LANGUAGE=$1
FOLDER=$2

if [[ ! -d "$FOLDER" ]]; then 
    echo "Output folder does not exist for $LANGUAGE, skipping..."
    exit 0 
fi

if [[ $LANGUAGE == 'javascript' ]]; then
    # jsdoc/require-hyphen-before-param-description fails to lint more than
    # 6 parameters, we re-run the script if failed to lint the rest
    CMD="yarn eslint --ext=ts,js ${FOLDER} --fix || yarn eslint --ext=ts,js ${FOLDER} --fix"
elif [[ $LANGUAGE == 'php' ]]; then
    FIXER="clients/algoliasearch-client-php/vendor/bin/php-cs-fixer"
    if [[ $CI ]]; then
        FIXCMD="PHP_CS_FIXER_IGNORE_ENV=1 php $FIXER fix $FOLDER --using-cache=no --allow-risky=yes"
    else
        FIXCMD="PHP_CS_FIXER_IGNORE_ENV=1 php8 $FIXER fix $FOLDER --using-cache=no --allow-risky=yes"
    fi
    CMD="composer update --working-dir=clients/algoliasearch-client-php \
          && composer dump-autoload --working-dir=clients/algoliasearch-client-php \
          && $FIXCMD"
elif [[ $LANGUAGE == 'java' ]]; then
    CMD="find $FOLDER -type f -name \"*.java\" | xargs java --add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED \
                                                     --add-exports jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED \
                                                     --add-exports jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED \
                                                     --add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED \
                                                     --add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED \
                                                     -jar /tmp/java-formatter.jar -r \
        && yarn prettier --write $FOLDER"
else
    echo "Cannot format unknow language $LANGUAGE"
    exit 1
fi

echo "> Formatting ${LANGUAGE} in ${FOLDER}..."

if [[ $VERBOSE == "true" ]]; then
    # CAREFUL WITH EVAL (not safe)
    eval $CMD
else
    set +e
    log=$(eval $CMD)

    if [[ $? != 0 ]]; then
        echo "$log"
        exit 1
    fi
    set -e
fi
