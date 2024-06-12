// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

public struct Version {
    public let major: Int
    public let minor: Int
    public let patch: Int
    public let prereleaseIdentifier: String?

    public init(major: Int, minor: Int, patch: Int = 0, prereleaseIdentifier: String? = nil) {
        self.major = major
        self.minor = minor
        self.patch = patch
        self.prereleaseIdentifier = prereleaseIdentifier
    }

    public init(version: String) {
        let components = version.components(separatedBy: ".")

        guard components.count >= 3 else {
            fatalError("version is not formatted correctly")
        }

        self.major = Int(components[0]) ?? 0
        self.minor = Int(components[1]) ?? 0

        if components.count == 4 {
            let prereleaseComponents = components[2].components(separatedBy: "-")

            self.patch = Int(prereleaseComponents[0]) ?? 0
            self.prereleaseIdentifier = "\(prereleaseComponents[1]).\(components[3])"
        } else {
            self.patch = Int(components[2]) ?? 0
            self.prereleaseIdentifier = nil
        }
    }
}

extension Version: CustomStringConvertible {
    public var description: String {
        let main = [major, minor, patch].map(String.init).joined(separator: ".")
        if let prereleaseIdentifier {
            return main + "-\(prereleaseIdentifier)"
        } else {
            return main
        }
    }
}

public extension Version {
    static let current: Version = .init(version: "9.0.0-beta.3")
}
