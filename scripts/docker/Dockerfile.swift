# version must stay in sync with config/.swift-version, CI checks the drift
FROM ghcr.io/nicklockwood/swiftformat:0.64.6@sha256:70275dd865936e902a6eb398679a7d08ff1b099f1de97bccca3a85e78086a838 AS swift_format
FROM swift:6.4-jammy@sha256:18a1cdd3e55ee32b0b3e1a15f12a4e1320b67544e542ed96c907629e5e434144

COPY --from=swift_format /usr/bin/swiftformat /usr/bin/swiftformat

# Global dependencies
RUN apt-get update \
  && apt-get install -y --no-install-recommends zlib1g-dev \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

WORKDIR /app
