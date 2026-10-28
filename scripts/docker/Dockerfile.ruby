# syntax=docker/dockerfile:1.26.0@sha256:ecfaec9ed6d810b56388c508f4121597bfbba70d41a6dfeee4d8cad5f295fc32
# version must stay in sync with config/.ruby-version, CI checks the drift
FROM ruby:4.0.7-trixie@sha256:f5d60242cdd3f17245399384a3f14b83f148cd9c948aed97329f5a0e6dc97a3b

# one pin per platform archive, the build platform picks it below
# renovate: datasource=github-release-attachments depName=fables-tales/rubyfmt asset=rubyfmt-{tag}-Linux-x86_64.tar.gz
ARG RUBYFMT_PIN_X86_64=v0.10.0@c72f5dc2bc320b758cf963e7338d27ab71dc1cff894a4b139e3fdcefb2e23c17
# renovate: datasource=github-release-attachments depName=fables-tales/rubyfmt asset=rubyfmt-{tag}-Linux-aarch64.tar.gz
ARG RUBYFMT_PIN_AARCH64=v0.10.0@619535a281c64874a4fc74dd55ebbdbc5b9d788a063bfca47bc2e25b5c18464a
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
