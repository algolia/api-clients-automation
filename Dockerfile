# renovate: datasource=github-tags depName=nodejs/node versioning=node
ARG NODE_VERSION=18.16.1
# renovate: datasource=java-version depName=java
ARG JAVA_VERSION=11.0.19+7
# renovate: datasource=github-tags depName=php/php-sec
ARG PHP_VERSION=8.2.8
# renovate: datasource=golang-version depName=golang
ARG GO_VERSION=1.20.6
# renovate: datasource=dart-version depName=dart
ARG DART_VERSION=3.0.6

FROM golang:${GO_VERSION}-bullseye as go-builder

FROM dart:${DART_VERSION} as dart-builder

# PHP is so complicated (and long) to install that we use the docker image directly
FROM php:${PHP_VERSION}-bullseye

ARG NODE_VERSION
ARG JAVA_VERSION

ENV DOCKER=true

# use bash for subsequent commands
SHELL ["/bin/bash", "--login", "-c"]

# PHP composer
COPY --from=composer:latest /usr/bin/composer /usr/local/bin/composer

RUN apt-get update && apt-get install -y \
    curl \
    zip \
    unzip \
    # python is used by nvm to install some packages
    python3 \
    git \
    && rm -rf /var/lib/apt/lists/*

# Javascript (node)
RUN curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.3/install.sh | bash
RUN nvm install ${NODE_VERSION}
RUN npm install -g yarn 

# Java
RUN curl -s "https://get.sdkman.io" | bash
RUN source "$HOME/.sdkman/bin/sdkman-init.sh"
RUN sdk install java ${JAVA_VERSION}-zulu

# Java formatter
ADD https://github.com/google/google-java-format/releases/download/v1.17.0/google-java-format-1.17.0-all-deps.jar /tmp/java-formatter.jar

# Go
COPY --from=go-builder /usr/local/go/ /usr/local/go/
RUN echo "export PATH=$PATH:/usr/local/go/bin" >> ~/.profile && source ~/.profile

# Dart
COPY --from=dart-builder /usr/lib/dart/ /usr/lib/dart/
RUN echo "export PATH=/usr/lib/dart/bin:/root/.pub-cache/bin:$PATH" >>  ~/.profile && \
    source ~/.profile && \
    dart pub global activate melos

# use bash for subsequent commands

WORKDIR /app

CMD bash
