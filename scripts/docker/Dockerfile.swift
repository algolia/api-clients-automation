# version must stay in sync with config/.swift-version, CI checks the drift
FROM ghcr.io/nicklockwood/swiftformat:0.63.1@sha256:da830ccad5ccc3c82610d1fb42817029a77ad42dfa3d6782a43101a5beecba63 AS swift_format
FROM swift:5.9-jammy@sha256:006635153a77dfc9d096dfc954b362d9017f1560d74c357100b50429bf5174c7

COPY --from=swift_format /usr/bin/swiftformat /usr/bin/swiftformat

# Global dependencies
RUN apt-get update \
  && apt-get install -y --no-install-recommends zlib1g-dev \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

WORKDIR /app
