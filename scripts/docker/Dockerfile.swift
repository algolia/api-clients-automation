# version must stay in sync with config/.swift-version, CI checks the drift
FROM ghcr.io/nicklockwood/swiftformat:0.64.6@sha256:70275dd865936e902a6eb398679a7d08ff1b099f1de97bccca3a85e78086a838 AS swift_format
FROM swift:5.9-jammy@sha256:006635153a77dfc9d096dfc954b362d9017f1560d74c357100b50429bf5174c7

COPY --from=swift_format /usr/bin/swiftformat /usr/bin/swiftformat

# Global dependencies
RUN apt-get update \
  && apt-get install -y --no-install-recommends zlib1g-dev \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

WORKDIR /app
