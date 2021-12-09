CLIENT_FOLDER=$1


find $CLIENT_FOLDER -type f -name "*.java" | xargs sed -i '' -e 's/= {}/= new Object()/g'

echo "package com.algolia.model;public class OneOfintegerstring {}" > $CLIENT_FOLDER/algoliasearch-core/com/algolia/model/OneOfintegerstring.java

# Download the formatter if not present
javaFormatter="google-java-format-1.13.0-all-deps.jar"
if [[ ! -f "dist/$javaFormatter" ]]; then
    mkdir dist
    curl -L "https://github.com/google/google-java-format/releases/download/v1.13.0/$javaFormatter" > dist/$javaFormatter
fi
find $CLIENT_FOLDER -type f -name "*.java" | xargs java -jar dist/$javaFormatter -r

yarn prettier --write $CLIENT_FOLDER/**/*.java
