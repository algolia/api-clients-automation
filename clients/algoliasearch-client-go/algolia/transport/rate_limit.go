package transport

import (
	"context"
	"fmt"
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
	raw := strings.TrimSpace(headerValue(header, "Retry-After"))
	if !retryAfterDigits.MatchString(raw) {
		return defaultRateLimitWait
	}

	seconds, err := strconv.Atoi(raw)
	if err != nil || seconds <= 0 {
		return defaultRateLimitWait
	}

	return time.Duration(seconds) * time.Second
}

func headerValue(header http.Header, name string) string {
	if header == nil {
		return ""
	}

	if v := header.Get(name); v != "" {
		return v
	}

	for key, values := range header {
		if strings.EqualFold(key, name) && len(values) > 0 {
			return values[0]
		}
	}

	return ""
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
		return fmt.Errorf("rate limit wait cancelled: %w", ctx.Err())
	}
}
