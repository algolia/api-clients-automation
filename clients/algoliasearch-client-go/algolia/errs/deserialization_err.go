package errs

import "fmt"

// DeserializationError is returned when a successful response body cannot be
// decoded into the expected type.
type DeserializationError struct {
	err           error
	correlationID string
}

func NewDeserializationError(err error, correlationID string) *DeserializationError {
	return &DeserializationError{
		err:           err,
		correlationID: correlationID,
	}
}

// CorrelationID is the Correlation-ID header of the response whose body
// failed to decode, when present. Quote it when contacting Algolia support.
func (e *DeserializationError) CorrelationID() string {
	return e.correlationID
}

func (e *DeserializationError) Error() string {
	if e.correlationID != "" {
		return fmt.Sprintf("cannot decode result: %v (Correlation-ID: %s)", e.err, e.correlationID)
	}

	return fmt.Sprintf("cannot decode result: %v", e.err)
}

func (e *DeserializationError) Unwrap() error {
	return e.err
}
