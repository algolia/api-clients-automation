// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// SupportedLanguage ISO code for a supported language.
type SupportedLanguage string

// List of supportedLanguage.
const (
	SUPPORTED_LANGUAGE_AF    SupportedLanguage = "af"
	SUPPORTED_LANGUAGE_AR    SupportedLanguage = "ar"
	SUPPORTED_LANGUAGE_AZ    SupportedLanguage = "az"
	SUPPORTED_LANGUAGE_BG    SupportedLanguage = "bg"
	SUPPORTED_LANGUAGE_BN    SupportedLanguage = "bn"
	SUPPORTED_LANGUAGE_CA    SupportedLanguage = "ca"
	SUPPORTED_LANGUAGE_CS    SupportedLanguage = "cs"
	SUPPORTED_LANGUAGE_CY    SupportedLanguage = "cy"
	SUPPORTED_LANGUAGE_DA    SupportedLanguage = "da"
	SUPPORTED_LANGUAGE_DE    SupportedLanguage = "de"
	SUPPORTED_LANGUAGE_EL    SupportedLanguage = "el"
	SUPPORTED_LANGUAGE_EN    SupportedLanguage = "en"
	SUPPORTED_LANGUAGE_EO    SupportedLanguage = "eo"
	SUPPORTED_LANGUAGE_ES    SupportedLanguage = "es"
	SUPPORTED_LANGUAGE_ET    SupportedLanguage = "et"
	SUPPORTED_LANGUAGE_EU    SupportedLanguage = "eu"
	SUPPORTED_LANGUAGE_FA    SupportedLanguage = "fa"
	SUPPORTED_LANGUAGE_FI    SupportedLanguage = "fi"
	SUPPORTED_LANGUAGE_FO    SupportedLanguage = "fo"
	SUPPORTED_LANGUAGE_FR    SupportedLanguage = "fr"
	SUPPORTED_LANGUAGE_GA    SupportedLanguage = "ga"
	SUPPORTED_LANGUAGE_GL    SupportedLanguage = "gl"
	SUPPORTED_LANGUAGE_HE    SupportedLanguage = "he"
	SUPPORTED_LANGUAGE_HI    SupportedLanguage = "hi"
	SUPPORTED_LANGUAGE_HU    SupportedLanguage = "hu"
	SUPPORTED_LANGUAGE_HY    SupportedLanguage = "hy"
	SUPPORTED_LANGUAGE_ID    SupportedLanguage = "id"
	SUPPORTED_LANGUAGE_IS    SupportedLanguage = "is"
	SUPPORTED_LANGUAGE_IT    SupportedLanguage = "it"
	SUPPORTED_LANGUAGE_JA    SupportedLanguage = "ja"
	SUPPORTED_LANGUAGE_KA    SupportedLanguage = "ka"
	SUPPORTED_LANGUAGE_KK    SupportedLanguage = "kk"
	SUPPORTED_LANGUAGE_KO    SupportedLanguage = "ko"
	SUPPORTED_LANGUAGE_KU    SupportedLanguage = "ku"
	SUPPORTED_LANGUAGE_KY    SupportedLanguage = "ky"
	SUPPORTED_LANGUAGE_LT    SupportedLanguage = "lt"
	SUPPORTED_LANGUAGE_LV    SupportedLanguage = "lv"
	SUPPORTED_LANGUAGE_MI    SupportedLanguage = "mi"
	SUPPORTED_LANGUAGE_MN    SupportedLanguage = "mn"
	SUPPORTED_LANGUAGE_MR    SupportedLanguage = "mr"
	SUPPORTED_LANGUAGE_MS    SupportedLanguage = "ms"
	SUPPORTED_LANGUAGE_MT    SupportedLanguage = "mt"
	SUPPORTED_LANGUAGE_NB    SupportedLanguage = "nb"
	SUPPORTED_LANGUAGE_NL    SupportedLanguage = "nl"
	SUPPORTED_LANGUAGE_NO    SupportedLanguage = "no"
	SUPPORTED_LANGUAGE_NS    SupportedLanguage = "ns"
	SUPPORTED_LANGUAGE_PL    SupportedLanguage = "pl"
	SUPPORTED_LANGUAGE_PS    SupportedLanguage = "ps"
	SUPPORTED_LANGUAGE_PT    SupportedLanguage = "pt"
	SUPPORTED_LANGUAGE_PT_BR SupportedLanguage = "pt-br"
	SUPPORTED_LANGUAGE_QU    SupportedLanguage = "qu"
	SUPPORTED_LANGUAGE_RO    SupportedLanguage = "ro"
	SUPPORTED_LANGUAGE_RU    SupportedLanguage = "ru"
	SUPPORTED_LANGUAGE_SK    SupportedLanguage = "sk"
	SUPPORTED_LANGUAGE_SQ    SupportedLanguage = "sq"
	SUPPORTED_LANGUAGE_SV    SupportedLanguage = "sv"
	SUPPORTED_LANGUAGE_SW    SupportedLanguage = "sw"
	SUPPORTED_LANGUAGE_TA    SupportedLanguage = "ta"
	SUPPORTED_LANGUAGE_TE    SupportedLanguage = "te"
	SUPPORTED_LANGUAGE_TH    SupportedLanguage = "th"
	SUPPORTED_LANGUAGE_TL    SupportedLanguage = "tl"
	SUPPORTED_LANGUAGE_TN    SupportedLanguage = "tn"
	SUPPORTED_LANGUAGE_TR    SupportedLanguage = "tr"
	SUPPORTED_LANGUAGE_TT    SupportedLanguage = "tt"
	SUPPORTED_LANGUAGE_UK    SupportedLanguage = "uk"
	SUPPORTED_LANGUAGE_UR    SupportedLanguage = "ur"
	SUPPORTED_LANGUAGE_UZ    SupportedLanguage = "uz"
	SUPPORTED_LANGUAGE_ZH    SupportedLanguage = "zh"
)

// All allowed values of SupportedLanguage enum.
var AllowedSupportedLanguageEnumValues = []SupportedLanguage{
	"af",
	"ar",
	"az",
	"bg",
	"bn",
	"ca",
	"cs",
	"cy",
	"da",
	"de",
	"el",
	"en",
	"eo",
	"es",
	"et",
	"eu",
	"fa",
	"fi",
	"fo",
	"fr",
	"ga",
	"gl",
	"he",
	"hi",
	"hu",
	"hy",
	"id",
	"is",
	"it",
	"ja",
	"ka",
	"kk",
	"ko",
	"ku",
	"ky",
	"lt",
	"lv",
	"mi",
	"mn",
	"mr",
	"ms",
	"mt",
	"nb",
	"nl",
	"no",
	"ns",
	"pl",
	"ps",
	"pt",
	"pt-br",
	"qu",
	"ro",
	"ru",
	"sk",
	"sq",
	"sv",
	"sw",
	"ta",
	"te",
	"th",
	"tl",
	"tn",
	"tr",
	"tt",
	"uk",
	"ur",
	"uz",
	"zh",
}

func (v *SupportedLanguage) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'SupportedLanguage': %w", string(src), err)
	}
	enumTypeValue := SupportedLanguage(value)
	for _, existing := range AllowedSupportedLanguageEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid SupportedLanguage", value)
}

// NewSupportedLanguageFromValue returns a pointer to a valid SupportedLanguage
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewSupportedLanguageFromValue(v string) (*SupportedLanguage, error) {
	ev := SupportedLanguage(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for SupportedLanguage: valid values are %v", v, AllowedSupportedLanguageEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v SupportedLanguage) IsValid() bool {
	for _, existing := range AllowedSupportedLanguageEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to supportedLanguage value.
func (v SupportedLanguage) Ptr() *SupportedLanguage {
	return &v
}
