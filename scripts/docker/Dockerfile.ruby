ARG RUBY_VERSION
FROM ruby:${RUBY_VERSION}-trixie

ADD https://github.com/fables-tales/rubyfmt/releases/download/v0.10.0/rubyfmt-v0.10.0-Linux-aarch64.tar.gz rubyfmt.tar.gz
RUN tar -xzf rubyfmt.tar.gz && \
  mv tmp/releases/v0.10.0-Linux/rubyfmt /usr/local/bin && \
  rm -rf rubyfmt.tar.gz tmp

WORKDIR /app
