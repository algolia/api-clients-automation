ARG SWIFT_VERSION
ARG SWIFTFORMAT_VERSION=0.58.1

FROM ghcr.io/nicklockwood/swiftformat:${SWIFTFORMAT_VERSION} AS swift_format
FROM swift:${SWIFT_VERSION}-jammy

COPY --from=swift_format /usr/bin/swiftformat /usr/bin/swiftformat

# Global dependencies
RUN apt-get update \
  && apt-get install -y --no-install-recommends zlib1g-dev \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

WORKDIR /app
