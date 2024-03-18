// This comes from the MIT licensed Flight-School/AnyCodable excellent package.
// It is copied here because of Podspec incompatibilties.

import Foundation

/// A type-erased `Codable` value.
///
/// The `AnyCodable` type forwards encoding and decoding responsibilities
/// to an underlying value, hiding its specific underlying type.
///
/// You can encode or decode mixed-type values in dictionaries
/// and other collections that require `Encodable` or `Decodable` conformance
/// by declaring their contained type to be `AnyCodable`.
///
/// - SeeAlso: `AnyEncodable`
/// - SeeAlso: `AnyDecodable`
@frozen
public struct AnyCodable: Codable {
    public let value: Any

    public init(_ value: (some Any)?) {
        self.value = value ?? ()
    }
}

extension AnyCodable: _AnyEncodable, _AnyDecodable {}

extension AnyCodable: Equatable {
    public static func ==(lhs: AnyCodable, rhs: AnyCodable) -> Bool {
        switch (lhs.value, rhs.value) {
        case is (Void, Void):
            true
        case let (lhs as Bool, rhs as Bool):
            lhs == rhs
        case let (lhs as Int, rhs as Int):
            lhs == rhs
        case let (lhs as Int8, rhs as Int8):
            lhs == rhs
        case let (lhs as Int16, rhs as Int16):
            lhs == rhs
        case let (lhs as Int32, rhs as Int32):
            lhs == rhs
        case let (lhs as Int64, rhs as Int64):
            lhs == rhs
        case let (lhs as UInt, rhs as UInt):
            lhs == rhs
        case let (lhs as UInt8, rhs as UInt8):
            lhs == rhs
        case let (lhs as UInt16, rhs as UInt16):
            lhs == rhs
        case let (lhs as UInt32, rhs as UInt32):
            lhs == rhs
        case let (lhs as UInt64, rhs as UInt64):
            lhs == rhs
        case let (lhs as Float, rhs as Float):
            lhs == rhs
        case let (lhs as Double, rhs as Double):
            lhs == rhs
        case let (lhs as String, rhs as String):
            lhs == rhs
        case let (lhs as [String: AnyCodable], rhs as [String: AnyCodable]):
            lhs == rhs
        case let (lhs as [AnyCodable], rhs as [AnyCodable]):
            lhs == rhs
        case let (lhs as [String: Any], rhs as [String: Any]):
            NSDictionary(dictionary: lhs) == NSDictionary(dictionary: rhs)
        case let (lhs as [Any], rhs as [Any]):
            NSArray(array: lhs) == NSArray(array: rhs)
        case is (NSNull, NSNull):
            true
        default:
            false
        }
    }
}

extension AnyCodable: CustomStringConvertible {
    public var description: String {
        switch self.value {
        case is Void:
            String(describing: nil as Any?)
        case let value as CustomStringConvertible:
            value.description
        default:
            String(describing: self.value)
        }
    }
}

extension AnyCodable: CustomDebugStringConvertible {
    public var debugDescription: String {
        switch self.value {
        case let value as CustomDebugStringConvertible:
            "AnyCodable(\(value.debugDescription))"
        default:
            "AnyCodable(\(self.description))"
        }
    }
}

extension AnyCodable: ExpressibleByNilLiteral {}
extension AnyCodable: ExpressibleByBooleanLiteral {}
extension AnyCodable: ExpressibleByIntegerLiteral {}
extension AnyCodable: ExpressibleByFloatLiteral {}
extension AnyCodable: ExpressibleByStringLiteral {}
extension AnyCodable: ExpressibleByStringInterpolation {}
extension AnyCodable: ExpressibleByArrayLiteral {}
extension AnyCodable: ExpressibleByDictionaryLiteral {}

extension AnyCodable: Hashable {
    public func hash(into hasher: inout Hasher) {
        switch self.value {
        case let value as Bool:
            hasher.combine(value)
        case let value as Int:
            hasher.combine(value)
        case let value as Int8:
            hasher.combine(value)
        case let value as Int16:
            hasher.combine(value)
        case let value as Int32:
            hasher.combine(value)
        case let value as Int64:
            hasher.combine(value)
        case let value as UInt:
            hasher.combine(value)
        case let value as UInt8:
            hasher.combine(value)
        case let value as UInt16:
            hasher.combine(value)
        case let value as UInt32:
            hasher.combine(value)
        case let value as UInt64:
            hasher.combine(value)
        case let value as Float:
            hasher.combine(value)
        case let value as Double:
            hasher.combine(value)
        case let value as String:
            hasher.combine(value)
        case let value as [String: AnyCodable]:
            hasher.combine(value)
        case let value as [AnyCodable]:
            hasher.combine(value)
        default:
            break
        }
    }
}
