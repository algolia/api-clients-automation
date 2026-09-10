# version must stay in sync with config/.swift-version, CI checks the drift
FROM ghcr.io/nicklockwood/swiftformat:0.63.0@sha256:cb50a33496b4f5123b99241437f24f154a68085398cfda1412ed3b6bab9c02ec AS swift_format
FROM swift:5.9-jammy@sha256:006635153a77dfc9d096dfc954b362d9017f1560d74c357100b50429bf5174c7

COPY --from=swift_format /usr/bin/swiftformat /usr/bin/swiftformat

# Global dependencies
RUN apt-get update \
  && apt-get install -y --no-install-recommends zlib1g-dev \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

WORKDIR /app
