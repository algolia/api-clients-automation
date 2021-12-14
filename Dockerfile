FROM ubuntu:20.04

WORKDIR /api-clients-automation
ADD . /api-clients-automation/

ENV NVM_DIR /root/.nvm
ENV DEBIAN_FRONTEND=noninteractive 

# Setup
RUN \
  apt update && \
  apt upgrade -y && \
  apt install -y curl gnupg2 build-essential jq yamllint openjdk-11-jdk

# Install Node
RUN curl --silent -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash

RUN /bin/bash -c "source $NVM_DIR/nvm.sh; nvm install"
RUN alias node=nodejs

# Install yarn
RUN curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -
RUN echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list

RUN \
  apt update && \
  apt install -y --no-install-recommends yarn

RUN /bin/bash -c "source /root/.bashrc"

RUN command -v yarn
