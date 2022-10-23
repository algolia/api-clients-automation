ARG NODE_VERSION=16.13.1

FROM node:$NODE_VERSION-alpine

ENV DOCKER=true

RUN apk update
RUN apk add openjdk11 jq bash perl build-base python3
ENV JAVA_HOME=/usr/lib/jvm/default-jvm

# Java formatter
ADD https://github.com/google/google-java-format/releases/download/v1.15.0/google-java-format-1.15.0-all-deps.jar /tmp/java-formatter.jar

# PHP dependencies
RUN apk add composer php8 php8-tokenizer php8-dom php8-xml php8-xmlwriter

# Go
RUN apk add go

WORKDIR /app

CMD ["bash"]
