#!/bin/bash

# Break on non-zero code
set -e

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)"
# Move to the root (easier to locate other scripts)
cd ${DIR}/..

LANGUAGE=$1
FOLDER=$2

if [[ $LANGUAGE == 'javascript' ]]; then
    # jsdoc/require-hyphen-before-param-description fails to lint more than
    # 6 parameters, we re-run the script if failed to lint the rest
    CMD="yarn eslint --ext=ts ${FOLDER} --fix || yarn eslint --ext=ts ${FOLDER} --fix"
elif [[ $LANGUAGE == 'java' ]]; then
    # Download the formatter if not present and run it
    javaFormatter="google-java-format-1.13.0-all-deps.jar"

    if [[ ! -f "dist/$javaFormatter" ]]; then
        echo "Downloading formatter dependency"
        mkdir dist
        curl -L "https://github.com/google/google-java-format/releases/download/v1.13.0/$javaFormatter" > dist/$javaFormatter
    fi

    CMD="find $FOLDER -type f -name \"*.java\" | xargs java --add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED \
                                                     --add-exports jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED \
                                                     --add-exports jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED \
                                                     --add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED \
                                                     --add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED \
                                                     -jar dist/$javaFormatter -r \
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
