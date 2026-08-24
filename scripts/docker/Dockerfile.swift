# version must stay in sync with config/.swift-version, CI checks the drift
FROM ghcr.io/nicklockwood/swiftformat:0.62.1@sha256:24fda6ca91dfec3f7a4ecab9f8996fd75d5310f30c870c02303b78a1c8a821e4 AS swift_format
FROM swift:5.9-jammy@sha256:006635153a77dfc9d096dfc954b362d9017f1560d74c357100b50429bf5174c7

COPY --from=swift_format /usr/bin/swiftformat /usr/bin/swiftformat

# Global dependencies
RUN apt-get update \
  && apt-get install -y --no-install-recommends zlib1g-dev \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

WORKDIR /app
