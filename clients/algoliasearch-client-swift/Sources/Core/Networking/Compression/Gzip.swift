//
//  Gzip.swift
//
//
//  Created by Algolia on 16/02/2024.
//

import Foundation
import zlib

public extension Data {
    func gzip() throws -> Data? {
        var gzipData = Data()

        // GZip header
        let header: [UInt8] = [0x1F, 0x8B, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x03]
        gzipData.append(Data(header))

        // Deflate data
        guard let deflatedBody = try self.compress() else {
            return nil
        }
        try gzipData.append(deflatedBody)

        // Calculate and append CRC32 checksum (little-endian)
        let crc32 = self.computeChecksum()
        gzipData.append(Data([
            UInt8(crc32 & 0xFF),
            UInt8((crc32 >> 8) & 0xFF),
            UInt8((crc32 >> 16) & 0xFF),
            UInt8((crc32 >> 24) & 0xFF),
        ]))

        // Append uncompressed size (little-endian)
        let uncompressedSize = UInt32(self.count)
        gzipData.append(Data([
            UInt8(uncompressedSize & 0xFF),
            UInt8((uncompressedSize >> 8) & 0xFF),
            UInt8((uncompressedSize >> 16) & 0xFF),
            UInt8((uncompressedSize >> 24) & 0xFF),
        ]))

        return gzipData
    }

    func compress() throws -> Data? {
        let chunkSize = 4096
        let strategy: Int32 = 0
        let compressionLevel: Int32 = -1
        let memoryLevel: Int32 = 8

        // do the dual-buffer thing
        var inBuffer = [UInt8](repeating: 0, count: chunkSize)
        let inBufferPointer = UnsafeMutableBufferPointer(start: &inBuffer, count: chunkSize)
        var outBuffer = [UInt8](repeating: 0, count: chunkSize)
        let outBufferPointer = UnsafeMutableBufferPointer(start: &outBuffer, count: chunkSize)

        // pre-fill the inBuffer
        let countInBuffer: Int = Swift.min(chunkSize, self.count)
        let copiedByteCount: Int = self.copyBytes(to: inBufferPointer, from: 0 ..< countInBuffer)

        // init the stream
        var stream = z_stream(
            next_in: inBufferPointer.baseAddress,
            avail_in: UInt32(copiedByteCount),
            total_in: 0,
            next_out: nil,
            avail_out: 0,
            total_out: 0,
            msg: nil,
            state: nil,
            zalloc: nil,
            zfree: nil,
            opaque: nil,
            data_type: 0,
            adler: 0,
            reserved: 0
        )
        let windowBits: Int32 = -MAX_WBITS
        let result = deflateInit2_(
            &stream,
            compressionLevel,
            Z_DEFLATED,
            windowBits,
            memoryLevel,
            strategy,
            ZLIB_VERSION,
            Int32(MemoryLayout<z_stream>.size)
        )
        // check for init errors
        if result != Z_OK {
            throw AlgoliaError.runtimeError("Unable to compress data: \(result)")
        }
        // defer clean up
        defer {
            deflateEnd(&stream)
        }

        // loop over buffers
        var compressedData = Data()
        var streamStatus: Int32 = Z_OK
        while streamStatus == Z_OK {
            // always provide at least a whole buffer of data
            let readBytes = Int(stream.total_in)
            let countInBuffer: Int = Swift.min(chunkSize, self.count - readBytes)
            let copiedByteCount: Int = self.copyBytes(
                to: inBufferPointer,
                from: readBytes ..< (readBytes + countInBuffer)
            )
            stream.next_in = inBufferPointer.baseAddress
            stream.avail_in = UInt32(copiedByteCount)
            stream.next_out = outBufferPointer.baseAddress
            stream.avail_out = UInt32(chunkSize)
            // actual deflation
            let previousTotalOut = Int(stream.total_out)
            streamStatus = deflate(&stream, copiedByteCount > 0 ? Z_NO_FLUSH : Z_FINISH)
            // check for errors
            if streamStatus != Z_OK, streamStatus != Z_STREAM_END, streamStatus != Z_BUF_ERROR {
                throw AlgoliaError.runtimeError("Failure while compressing data stream: \(streamStatus)")
            }
            let readByteCount: Int = copiedByteCount - Int(stream.avail_in)
            // always copy out all written bytes
            let newOutByteCount = Int(stream.total_out) - previousTotalOut
            compressedData.append(&outBuffer, count: newOutByteCount)
        }
        inBuffer = []
        outBuffer = []

        return compressedData
    }

    func computeChecksum() -> UInt {
        self.withUnsafeBytes { (ptr: UnsafeRawBufferPointer) -> UInt in
            crc32(0, ptr.baseAddress, numericCast(ptr.count))
        }
    }
}
