ARG SWIFT_VERSION

FROM ghcr.io/nicklockwood/swiftformat:latest as swiftFormat
FROM swift:${SWIFT_VERSION}-jammy

COPY --from=swiftFormat /usr/bin/swiftformat /usr/bin/swiftformat

WORKDIR /app
