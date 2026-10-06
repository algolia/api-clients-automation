# syntax=docker/dockerfile:1.26.0@sha256:ecfaec9ed6d810b56388c508f4121597bfbba70d41a6dfeee4d8cad5f295fc32
# version must stay in sync with config/.ruby-version, CI checks the drift
FROM ruby:4.0.6-trixie@sha256:8dc3950712ad2078bdd275b890419ba2fd3aab5a0653b291a7325f0d8a24ca05

# one <release tag>@<sha256 of the archive> per platform, on one line each so renovate (github-release-attachments) moves
# the tag and the checksum together; both tags must match RUBYFMT_PIN_X86_64 in .github/actions/setup/action.yml
ARG RUBYFMT_PIN_X86_64=v0.10.0@c72f5dc2bc320b758cf963e7338d27ab71dc1cff894a4b139e3fdcefb2e23c17
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
