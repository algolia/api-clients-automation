#!/bin/bash

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)/../.."

docker run -d -it --name api-client --mount type=bind,source=$ROOT/,target=/app api-clients-automation
