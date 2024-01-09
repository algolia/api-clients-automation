version_number=$1
if [ -z "${version_number}" ]
then
 version_number=`git describe --tags $(git rev-list --tags --max-count=1)`
fi
IFS='-' read -a components <<< "${version_number}"
IFS='.' read -a version_components <<< "${components[0]}"
prerelease_components=${components[1]}
major=${version_components[0]}
minor=${version_components[1]}
patch=${version_components[2]}
if [ -z "${prerelease_components}" ]
then
 prereleaseIdentifier="nil"
else
 prereleaseIdentifier=\"${prerelease_components}\"
fi
version_file=Sources/Core/Helpers/Version+Current.swift
> $version_file
echo "// This is generated file. Don't modify it manually." >> $version_file
echo "public extension Version { static let current: Version = .init(major: $major, minor: $minor, patch: $patch, prereleaseIdentifier: $prereleaseIdentifier) }" >> $version_file
