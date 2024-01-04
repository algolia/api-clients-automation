ARG DART_VERSION
ARG GO_VERSION
ARG NODE_VERSION
ARG PHP_VERSION
ARG PYTHON_VERSION
ARG CSHARP_VERSION
ARG SWIFT_VERSION

FROM dart:${DART_VERSION} AS dart-builder
FROM mcr.microsoft.com/dotnet/sdk:${CSHARP_VERSION} AS csharp-builder
FROM golang:${GO_VERSION}-bullseye AS go-builder
FROM swift:${SWIFT_VERSION}-jammy AS builder

ENV DOCKER=true

# use bash for subsequent commands
SHELL ["/bin/bash", "--login", "-c"]

# Global (and librairies for ruby)
RUN apt-get update && apt-get install -y --no-install-recommends \
    curl zip unzip git openssh-server ca-certificates \
    build-essential bison zlib1g-dev libyaml-dev libssl-dev openssl libgdbm-dev libreadline-dev libncurses5-dev libffi-dev

# JavaScript
RUN mkdir -p /etc/apt/keyrings \
    && curl -sL https://deb.nodesource.com/gpgkey/nodesource.gpg.key | gpg --dearmor | tee /etc/apt/keyrings/nodesource.gpg >/dev/null \
    && NODE_MAJOR=$(echo $NODE_VERSION | sed -E -n 's/v?([0-9]+)\..*/\1/p') \
    && echo "deb [signed-by=/etc/apt/keyrings/nodesource.gpg] https://deb.nodesource.com/node_${NODE_MAJOR}.x jammy main" | tee /etc/apt/sources.list.d/nodesource.list \
    && apt-get update && apt-get install -y --no-install-recommends nodejs
RUN npm install -g yarn

# Python
RUN curl -L "https://www.python.org/ftp/python/$PYTHON_VERSION/Python-$PYTHON_VERSION.tgz" -o python.tgz \
    && tar -xvf python.tgz && cd Python-$PYTHON_VERSION \
    && ./configure --enable-optimizations \
    && make install \
    && cd .. && rm -rf Python-$PYTHON_VERSION python.tgz \
    && ln -s /usr/local/bin/pip3 /usr/bin/pip \
    && ln -s /usr/local/bin/python3 /usr/bin/python \
    && pip install --upgrade pip pipx && pipx ensurepath \
    && pipx install poetry


# Go
COPY --from=go-builder /usr/local/go/ /usr/local/go/
RUN echo "export PATH=$PATH:/usr/local/go/bin:/root/go/bin" >> ~/.profile
RUN curl -sSfL https://raw.githubusercontent.com/golangci/golangci-lint/master/install.sh | sh -s -- -b $(go env GOPATH)/bin v1.55.2
RUN go install golang.org/x/tools/cmd/goimports@latest

# Dart
COPY --from=dart-builder /usr/lib/dart/ /usr/lib/dart/
RUN echo "export PATH=/usr/lib/dart/bin:/root/.pub-cache/bin:$PATH" >> ~/.profile && source ~/.profile \
    && dart pub global activate melos

# PHP
COPY --from=composer:latest /usr/bin/composer /usr/local/bin/composer
RUN apt-get update && apt-get install -y --no-install-recommends \
    php${PHP_VERSION}-cli php${PHP_VERSION}-curl php${PHP_VERSION}-mbstring php${PHP_VERSION}-xml php${PHP_VERSION}-zip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# SDKMAN
RUN curl -s "https://get.sdkman.io" | bash
RUN echo "source $HOME/.sdkman/bin/sdkman-init.sh" >> ~/.profile && source ~/.profile

# Java
ARG JAVA_VERSION
RUN sdk install java ${JAVA_VERSION}-tem
ADD https://github.com/google/google-java-format/releases/download/v1.19.1/google-java-format-1.19.1-all-deps.jar /tmp/java-formatter.jar

# Scala
RUN sdk install sbt

# Ruby with RVM, because it's too difficult with the image, dependencies are splattered everywhere
ARG RUBY_VERSION
RUN echo "export PATH=$PATH:/opt/rubies/ruby-${RUBY_VERSION}/bin" >> ~/.profile && source ~/.profile
RUN curl -L -o ruby.tar.gz https://github.com/postmodern/ruby-install/releases/download/v0.9.2/ruby-install-0.9.2.tar.gz \
    && tar -xzvf ruby.tar.gz && cd ruby-install-0.9.2 && make install && ruby-install ruby ${RUBY_VERSION} && gem install bundler

# C#
COPY --from=csharp-builder /usr/share/dotnet /usr/share/dotnet
RUN echo "export PATH=$PATH:/usr/share/dotnet" >> ~/.profile && source ~/.profile

# Swift
RUN git clone https://github.com/apple/swift-format.git \
  && cd swift-format \
  && git checkout "release/$SWIFT_VERSION" \
  && swift build -c release \
  && swift test --parallel \
  && mv .build/release/swift-format /usr/bin \
  && cd .. \
  && rm -rf swift-format

# Clean up
RUN apt-get clean \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

CMD bash
