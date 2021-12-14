client=$1
export CLIENT=$(cat openapitools.json | yarn json "generator-cli.generators.java-${client}.output" | sed 's/#{cwd}\///g')

# Restore the oneOf spec
mv ./specs/search/paths/search/search.yml.bak ./specs/search/paths/search/search.yml

find $CLIENT -type f -name "*.java" | xargs sed -i '' -e 's/= {}/= new Object()/g'

echo "package com.algolia.model;public class OneOfintegerstring {}" > $CLIENT/algoliasearch-core/com/algolia/model/OneOfintegerstring.java

# Download the formatter if not present
javaFormatter="google-java-format-1.13.0-all-deps.jar"
if [[ ! -f "dist/$javaFormatter" ]]; then
    echo "Downloading formatter dependency"
    mkdir dist
    curl -L "https://github.com/google/google-java-format/releases/download/v1.13.0/$javaFormatter" > dist/$javaFormatter
fi
find $CLIENT -type f -name "*.java" | xargs java -jar dist/$javaFormatter -r

yarn prettier --write $CLIENT/**/*.java
