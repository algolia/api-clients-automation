package errs

type WaitError struct{}

func (e *WaitError) Error() string {
	return "wait error"
}
