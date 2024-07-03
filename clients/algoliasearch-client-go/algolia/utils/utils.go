//nolint:wrapcheck
package utils

import (
	"encoding/json"
	"reflect"
	"time"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/errs"
)

// ToPtr is a helper routine that returns a pointer to the given value.
func ToPtr[T any](v T) *T {
	return &v
}

type Nullable[T any] struct {
	value *T
	isSet bool
}

func (v Nullable[T]) Get() *T {
	return v.value
}

func (v *Nullable[T]) Set(val *T) {
	v.value = val
	v.isSet = true
}

func (v Nullable[T]) IsSet() bool {
	return v.isSet
}

func (v *Nullable[T]) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullable[T any](val *T) *Nullable[T] {
	return &Nullable[T]{value: val, isSet: true}
}

func (v Nullable[T]) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *Nullable[T]) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

// IsNilOrEmpty checks if an input is nil or empty.
func IsNilOrEmpty(i any) bool {
	if i == nil {
		return true
	}
	switch reflect.TypeOf(i).Kind() {
	case reflect.Chan, reflect.Func, reflect.Map, reflect.Ptr, reflect.UnsafePointer, reflect.Interface, reflect.Slice:
		return reflect.ValueOf(i).IsNil()
	case reflect.Bool:
		return false
	default:
		return reflect.ValueOf(i).IsZero()
	}
}

type IterableOptions[T any] struct {
	Aggregator  func(*T, error)
	Timeout     func() time.Duration
	IterableErr *IterableError[T]
}

type IterableOption[T any] func(*IterableOptions[T])

func WithAggregator[T any](aggregator func(*T, error)) IterableOption[T] {
	return func(options *IterableOptions[T]) {
		options.Aggregator = aggregator
	}
}

func WithTimeout[T any](timeout func() time.Duration) IterableOption[T] {
	return func(options *IterableOptions[T]) {
		options.Timeout = timeout
	}
}

func WithIterableError[T any](iterableErr *IterableError[T]) IterableOption[T] {
	return func(options *IterableOptions[T]) {
		options.IterableErr = iterableErr
	}
}

type IterableError[T any] struct {
	Validate func(*T, error) bool
	Message  func(*T, error) string
}

func CreateIterable[T any](execute func(*T, error) (*T, error), validate func(*T, error) bool, opts ...IterableOption[T]) (*T, error) {
	options := IterableOptions[T]{
		Aggregator: nil,
		Timeout: func() time.Duration {
			return 1 * time.Second
		},
		IterableErr: nil,
	}

	for _, opt := range opts {
		opt(&options)
	}
	var executor func(*T, error) (*T, error)

	executor = func(previousResponse *T, previousError error) (*T, error) {
		response, responseErr := execute(previousResponse, previousError)

		if options.Aggregator != nil {
			options.Aggregator(response, responseErr)
		}

		if validate(response, responseErr) {
			return response, responseErr
		}

		if options.IterableErr != nil && options.IterableErr.Validate(response, responseErr) {
			if options.IterableErr.Message != nil {
				return nil, errs.NewWaitError(options.IterableErr.Message(response, responseErr))
			}

			return nil, errs.NewWaitError("an error occurred")
		}

		time.Sleep(options.Timeout())

		return executor(response, responseErr)
	}

	return executor(nil, nil)
}
