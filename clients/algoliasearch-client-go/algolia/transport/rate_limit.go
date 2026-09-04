package transport

import (
	"context"
	"net/http"
	"regexp"
	"strconv"
	"strings"
	"time"
)

const (
	// DefaultMaxRateLimitRetries is how many same-host 429 waits a call gets
	// when Configuration.MaxRateLimitRetries is nil.
	DefaultMaxRateLimitRetries = 3
	defaultRateLimitWait       = time.Second
)

var retryAfterDigits = regexp.MustCompile(`^\d+$`)

func parseRetryAfter(header http.Header) time.Duration {
	if header == nil {
		return defaultRateLimitWait
	}

	raw := strings.TrimSpace(header.Get("Retry-After"))
	if !retryAfterDigits.MatchString(raw) {
		return defaultRateLimitWait
	}

	seconds, err := strconv.Atoi(raw)
	if err != nil || seconds <= 0 {
		return defaultRateLimitWait
	}

	return time.Duration(seconds) * time.Second
}

func isRateLimited(code int) bool {
	return code == http.StatusTooManyRequests
}

func resolveMaxRateLimitRetries(configured *int) int {
	if configured == nil {
		return DefaultMaxRateLimitRetries
	}

	if *configured < 0 {
		return 0
	}

	return *configured
}

func defaultSleep(ctx context.Context, d time.Duration) error {
	timer := time.NewTimer(d)
	defer timer.Stop()

	select {
	case <-timer.C:
		return nil
	case <-ctx.Done():
		return ctx.Err()
	}
}
