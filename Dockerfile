ARG NODE_VERSION=16.13.1

FROM node:$NODE_VERSION-alpine

ENV DOCKER=true

RUN apk add openjdk11 maven jq bash perl curl

WORKDIR /app

COPY package.json yarn.lock .yarnrc.yml ./
COPY clients/ ./clients/
COPY .yarn .yarn
RUN yarn install

COPY . .

CMD ["bash"]
