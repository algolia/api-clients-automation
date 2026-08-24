# version must stay in sync with config/.ruby-version, CI checks the drift
FROM ruby:4.0.6-trixie@sha256:72e26fdc615b21e9fa0a811f3c7572103a5adafd8ad34735ac316789cd74267f

ADD --checksum=sha256:619535a281c64874a4fc74dd55ebbdbc5b9d788a063bfca47bc2e25b5c18464a https://github.com/fables-tales/rubyfmt/releases/download/v0.10.0/rubyfmt-v0.10.0-Linux-aarch64.tar.gz rubyfmt.tar.gz
RUN tar -xzf rubyfmt.tar.gz && \
  mv tmp/releases/v0.10.0-Linux/rubyfmt /usr/local/bin && \
  rm -rf rubyfmt.tar.gz tmp

WORKDIR /app
