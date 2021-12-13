if [[ $__CI__ ]]; then
    exit 0
fi

echo "> Formatting specs..."

yarn specs:format
