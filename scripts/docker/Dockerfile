ARG NODE_VERSION
FROM node:${NODE_VERSION}-bullseye
ARG JAVA_VERSION

SHELL ["/bin/bash", "--login", "-c"]

# SDKMAN
RUN apt-get update \
    && apt-get install -y --no-install-recommends  curl zip unzip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*
RUN curl -s "https://get.sdkman.io" | bash
RUN source "/root/.sdkman/bin/sdkman-init.sh" \
    && sdk install java ${JAVA_VERSION}-tem \
    && sdk install sbt

ADD https://github.com/google/google-java-format/releases/download/v1.19.2/google-java-format-1.19.2-all-deps.jar /tmp/java-formatter.jar
