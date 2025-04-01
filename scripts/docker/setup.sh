#! /bin/bash

export NODE_VERSION=$(cat .nvmrc)

while read line; do
  arr=($line)
  export $(echo ${arr[1]} | sed -e "s/-/_/;s/config\/\.//" | tr "[a-z]" "[A-Z]")=${arr[0]}
done < <(find config -name '.*-version' -exec jq --raw-input -r '. + " " + input_filename' {} \;)

docker compose up -d --build
