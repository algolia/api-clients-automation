ARG NODE_IMAGE=node:16.13.0-alpine

FROM $NODE_IMAGE

RUN apk add openjdk11 maven jq bash yamllint perl curl

WORKDIR /app

COPY package.json yarn.lock .yarnrc.yml ./
COPY .yarn .yarn
RUN yarn install

RUN mkdir dist
RUN curl -L "https://github.com/google/google-java-format/releases/download/v1.13.0/google-java-format-1.13.0-all-deps.jar" > dist/google-java-format-1.13.0-all-deps.jar

COPY . .

CMD ["bash"]
