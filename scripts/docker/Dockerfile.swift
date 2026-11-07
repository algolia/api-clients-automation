# version must stay in sync with config/.swift-version, CI checks the drift
FROM ghcr.io/nicklockwood/swiftformat:0.63.1@sha256:da830ccad5ccc3c82610d1fb42817029a77ad42dfa3d6782a43101a5beecba63 AS swift_format
FROM swift:5.10-jammy@sha256:ffc42e399ad0cad324f68d58f65e4d5f2c22eb9df73c4dfa249e898d497254b3

COPY --from=swift_format /usr/bin/swiftformat /usr/bin/swiftformat

# Global dependencies
RUN apt-get update \
  && apt-get install -y --no-install-recommends zlib1g-dev \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

WORKDIR /app
