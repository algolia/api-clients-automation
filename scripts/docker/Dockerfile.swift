ARG SWIFT_VERSION

FROM ghcr.io/nicklockwood/swiftformat:latest as swiftFormat
FROM swift:${SWIFT_VERSION}-jammy

COPY --from=swiftFormat /usr/bin/swiftformat /usr/bin/swiftformat

# Global dependencies
RUN apt-get update \
    && apt-get install -y --no-install-recommends zlib1g-dev \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app
