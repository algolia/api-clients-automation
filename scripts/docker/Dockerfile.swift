# version must stay in sync with config/.swift-version, CI checks the drift
FROM ghcr.io/nicklockwood/swiftformat:0.64.6@sha256:70275dd865936e902a6eb398679a7d08ff1b099f1de97bccca3a85e78086a838 AS swift_format
FROM swift:5.10-jammy@sha256:ffc42e399ad0cad324f68d58f65e4d5f2c22eb9df73c4dfa249e898d497254b3

COPY --from=swift_format /usr/bin/swiftformat /usr/bin/swiftformat

# Global dependencies
RUN apt-get update \
  && apt-get install -y --no-install-recommends zlib1g-dev \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

WORKDIR /app
