LANGUAGE=$1
BASE_CHANGED=$2
BASE_BRANCH=$3

clients=$(cat openapitools.json | jq --arg lang $LANGUAGE -c '."generator-cli".generators 
                                | with_entries(
                                    if (.key | test($lang + "-.*")) then 
                                        ({key:.key,value:.value}) 
                                    else 
                                        empty 
                                    end
                                ) 
                                | to_entries 
                                | map({
                                    client:.key | sub($lang + "-";""),
                                    folder:.value.output | sub("#{cwd}/";"")
                                }) 
                                | .[]')

echo $clients

to_test='{"client": []}'
for pair in $clients; do
    client=$(echo $pair | jq '.client')
    folder=$(echo $pair | jq '.folder')
    spec_changed=$(git diff --shortstat origin/$BASE_BRANCH..HEAD -- specs/$client | wc -l)
    client_changed=$(git diff --shortstat origin/$BASE_BRANCH..HEAD -- $folder | wc -l)

    echo $spec_changed
    echo $client_changed
    echo "why"
    if [[ $BASE_CHANGED || $spec_changed > 0 || $client_changed > 0 ]]; then
        to_test=$(echo $to_test | jq --argjson pair $pair '.client |= .+ [$pair]')
    fi
done

# Convert the array to json for the matrix
if [[ $(echo $to_test | jq '.client | length') == 0 ]]; then
    # client cannot be empty or the matrix will fail
    matrix='{"client":["no-run"]}'
    run="false"
else
    matrix=$(echo $to_test | jq -c)
    run="true"
fi

echo $matrix
echo $run
