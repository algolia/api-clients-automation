# syntax=docker/dockerfile:1.28.0@sha256:bb22d9815c728170f72750f4e5b0d672e06176142e1d602c7e66c050100b7e5b
# version must stay in sync with config/.ruby-version, CI checks the drift
FROM ruby:4.0.9-trixie@sha256:07042b74555ff2eef7365abd72d39cba6e499ab63e2d2942fd34d4778338495b

# one pin per platform archive, the build platform picks it below
# renovate: datasource=github-release-attachments depName=fables-tales/rubyfmt asset=rubyfmt-{tag}-Linux-x86_64.tar.gz
ARG RUBYFMT_PIN_X86_64=v0.14.1@9590cc3b8b2ed37a250a5f7c22a542ce014f13954f613c93a72230de8a74fbbd
# renovate: datasource=github-release-attachments depName=fables-tales/rubyfmt asset=rubyfmt-{tag}-Linux-aarch64.tar.gz
ARG RUBYFMT_PIN_AARCH64=v0.14.1@fc429195d1315bb96b25beb6898bf2bec749e3f8d3c9b8dbb3be37c25752c3bd
RUN arch="$(uname -m)" && \
  case "$arch" in \
    x86_64) pin="$RUBYFMT_PIN_X86_64" ;; \
    aarch64) pin="$RUBYFMT_PIN_AARCH64" ;; \
    *) echo "no rubyfmt archive for $arch" && exit 1 ;; \
  esac && \
  version="${pin%@*}" && \
  curl -sSfL --retry 3 -o rubyfmt.tar.gz "https://github.com/fables-tales/rubyfmt/releases/download/${version}/rubyfmt-${version}-Linux-${arch}.tar.gz" && \
  echo "${pin#*@}  rubyfmt.tar.gz" | sha256sum -c - && \
  tar -xzf rubyfmt.tar.gz && \
  mv "tmp/releases/${version}-Linux/rubyfmt" /usr/local/bin && \
  rm -rf rubyfmt.tar.gz tmp

WORKDIR /app
