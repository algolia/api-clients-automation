ARG SWIFT_VERSION
ARG SWIFTFORMAT_VERSION=0.54.5

FROM ghcr.io/nicklockwood/swiftformat:${SWIFTFORMAT_VERSION} AS swiftFormat
FROM swift:${SWIFT_VERSION}-jammy

COPY --from=swiftFormat /usr/bin/swiftformat /usr/bin/swiftformat

# Global dependencies
RUN apt-get update \
    && apt-get install -y --no-install-recommends zlib1g-dev \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app
