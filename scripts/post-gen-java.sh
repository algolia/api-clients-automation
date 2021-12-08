CLIENT_FOLDER=$1

find $CLIENT_FOLDER -type f -name "*.java" | xargs sed -i '' -e 's/= {}/= new Object()/g'
