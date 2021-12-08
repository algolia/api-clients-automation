CLIENT_FOLDER=$1

find $CLIENT_FOLDER -type f -name "*.java" | xargs sed -i '' -e 's/= {}/= new Object()/g'

echo "package com.algolia.model;public class OneOfintegerstring {}" > $CLIENT_FOLDER/algoliasearch-core/com/algolia/model/OneOfintegerstring.java

prettier --write $CLIENT_FOLDER/**/*.java
