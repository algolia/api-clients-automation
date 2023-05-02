#!/bin/bash

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)/../.."

docker run -d -p 1043:1043 -it --name api-clients-automation --mount type=bind,source=$ROOT/,target=/app api-clients-automation
