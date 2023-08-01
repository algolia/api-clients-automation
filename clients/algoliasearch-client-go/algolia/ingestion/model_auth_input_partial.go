// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// AuthInputPartial - struct for AuthInputPartial
type AuthInputPartial struct {
	AuthAPIKeyPartial               *AuthAPIKeyPartial
	AuthAlgoliaPartial              *AuthAlgoliaPartial
	AuthBasicPartial                *AuthBasicPartial
	AuthGoogleServiceAccountPartial *AuthGoogleServiceAccountPartial
	AuthOAuthPartial                *AuthOAuthPartial
}

// AuthAPIKeyPartialAsAuthInputPartial is a convenience function that returns AuthAPIKeyPartial wrapped in AuthInputPartial
func AuthAPIKeyPartialAsAuthInputPartial(v *AuthAPIKeyPartial) AuthInputPartial {
	return AuthInputPartial{
		AuthAPIKeyPartial: v,
	}
}

// AuthAlgoliaPartialAsAuthInputPartial is a convenience function that returns AuthAlgoliaPartial wrapped in AuthInputPartial
func AuthAlgoliaPartialAsAuthInputPartial(v *AuthAlgoliaPartial) AuthInputPartial {
	return AuthInputPartial{
		AuthAlgoliaPartial: v,
	}
}

// AuthBasicPartialAsAuthInputPartial is a convenience function that returns AuthBasicPartial wrapped in AuthInputPartial
func AuthBasicPartialAsAuthInputPartial(v *AuthBasicPartial) AuthInputPartial {
	return AuthInputPartial{
		AuthBasicPartial: v,
	}
}

// AuthGoogleServiceAccountPartialAsAuthInputPartial is a convenience function that returns AuthGoogleServiceAccountPartial wrapped in AuthInputPartial
func AuthGoogleServiceAccountPartialAsAuthInputPartial(v *AuthGoogleServiceAccountPartial) AuthInputPartial {
	return AuthInputPartial{
		AuthGoogleServiceAccountPartial: v,
	}
}

// AuthOAuthPartialAsAuthInputPartial is a convenience function that returns AuthOAuthPartial wrapped in AuthInputPartial
func AuthOAuthPartialAsAuthInputPartial(v *AuthOAuthPartial) AuthInputPartial {
	return AuthInputPartial{
		AuthOAuthPartial: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct
func (dst *AuthInputPartial) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into AuthAPIKeyPartial
	err = newStrictDecoder(data).Decode(&dst.AuthAPIKeyPartial)
	if err == nil && validateStruct(dst.AuthAPIKeyPartial) == nil {
		jsonAuthAPIKeyPartial, _ := json.Marshal(dst.AuthAPIKeyPartial)
		if string(jsonAuthAPIKeyPartial) == "{}" { // empty struct
			dst.AuthAPIKeyPartial = nil
		} else {
			return nil
		}
	} else {
		dst.AuthAPIKeyPartial = nil
	}

	// try to unmarshal data into AuthAlgoliaPartial
	err = newStrictDecoder(data).Decode(&dst.AuthAlgoliaPartial)
	if err == nil && validateStruct(dst.AuthAlgoliaPartial) == nil {
		jsonAuthAlgoliaPartial, _ := json.Marshal(dst.AuthAlgoliaPartial)
		if string(jsonAuthAlgoliaPartial) == "{}" { // empty struct
			dst.AuthAlgoliaPartial = nil
		} else {
			return nil
		}
	} else {
		dst.AuthAlgoliaPartial = nil
	}

	// try to unmarshal data into AuthBasicPartial
	err = newStrictDecoder(data).Decode(&dst.AuthBasicPartial)
	if err == nil && validateStruct(dst.AuthBasicPartial) == nil {
		jsonAuthBasicPartial, _ := json.Marshal(dst.AuthBasicPartial)
		if string(jsonAuthBasicPartial) == "{}" { // empty struct
			dst.AuthBasicPartial = nil
		} else {
			return nil
		}
	} else {
		dst.AuthBasicPartial = nil
	}

	// try to unmarshal data into AuthGoogleServiceAccountPartial
	err = newStrictDecoder(data).Decode(&dst.AuthGoogleServiceAccountPartial)
	if err == nil && validateStruct(dst.AuthGoogleServiceAccountPartial) == nil {
		jsonAuthGoogleServiceAccountPartial, _ := json.Marshal(dst.AuthGoogleServiceAccountPartial)
		if string(jsonAuthGoogleServiceAccountPartial) == "{}" { // empty struct
			dst.AuthGoogleServiceAccountPartial = nil
		} else {
			return nil
		}
	} else {
		dst.AuthGoogleServiceAccountPartial = nil
	}

	// try to unmarshal data into AuthOAuthPartial
	err = newStrictDecoder(data).Decode(&dst.AuthOAuthPartial)
	if err == nil && validateStruct(dst.AuthOAuthPartial) == nil {
		jsonAuthOAuthPartial, _ := json.Marshal(dst.AuthOAuthPartial)
		if string(jsonAuthOAuthPartial) == "{}" { // empty struct
			dst.AuthOAuthPartial = nil
		} else {
			return nil
		}
	} else {
		dst.AuthOAuthPartial = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(AuthInputPartial)")
}

// Marshal data from the first non-nil pointers in the struct to JSON
func (src AuthInputPartial) MarshalJSON() ([]byte, error) {
	if src.AuthAPIKeyPartial != nil {
		return json.Marshal(&src.AuthAPIKeyPartial)
	}

	if src.AuthAlgoliaPartial != nil {
		return json.Marshal(&src.AuthAlgoliaPartial)
	}

	if src.AuthBasicPartial != nil {
		return json.Marshal(&src.AuthBasicPartial)
	}

	if src.AuthGoogleServiceAccountPartial != nil {
		return json.Marshal(&src.AuthGoogleServiceAccountPartial)
	}

	if src.AuthOAuthPartial != nil {
		return json.Marshal(&src.AuthOAuthPartial)
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance
func (obj *AuthInputPartial) GetActualInstance() any {
	if obj == nil {
		return nil
	}
	if obj.AuthAPIKeyPartial != nil {
		return obj.AuthAPIKeyPartial
	}

	if obj.AuthAlgoliaPartial != nil {
		return obj.AuthAlgoliaPartial
	}

	if obj.AuthBasicPartial != nil {
		return obj.AuthBasicPartial
	}

	if obj.AuthGoogleServiceAccountPartial != nil {
		return obj.AuthGoogleServiceAccountPartial
	}

	if obj.AuthOAuthPartial != nil {
		return obj.AuthOAuthPartial
	}

	// all schemas are nil
	return nil
}

type NullableAuthInputPartial struct {
	value *AuthInputPartial
	isSet bool
}

func (v NullableAuthInputPartial) Get() *AuthInputPartial {
	return v.value
}

func (v *NullableAuthInputPartial) Set(val *AuthInputPartial) {
	v.value = val
	v.isSet = true
}

func (v NullableAuthInputPartial) IsSet() bool {
	return v.isSet
}

func (v *NullableAuthInputPartial) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAuthInputPartial(val *AuthInputPartial) *NullableAuthInputPartial {
	return &NullableAuthInputPartial{value: val, isSet: true}
}

func (v NullableAuthInputPartial) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableAuthInputPartial) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
