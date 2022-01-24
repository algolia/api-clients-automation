ARG NODE_VERSION=16.13.1

FROM node:$NODE_VERSION-alpine

ENV DOCKER=true

RUN apk add openjdk11 maven jq bash perl curl

# PHP dependencies
RUN apk add composer php8 php8-tokenizer

WORKDIR /app

CMD ["bash"]
