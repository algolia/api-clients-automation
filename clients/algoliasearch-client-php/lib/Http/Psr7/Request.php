<?php

namespace Algolia\AlgoliaSearch\Http\Psr7;

require_once 'functions.php';

use Psr\Http\Message\MessageInterface;
use Psr\Http\Message\RequestInterface;
use Psr\Http\Message\StreamInterface;
use Psr\Http\Message\UriInterface;

/**
 * PSR-7 request implementation.
 *
 * @internal
 */
class Request implements RequestInterface
{
    /** @var string */
    private $method;

    /** @var null|string */
    private $requestTarget;

    /** @var UriInterface */
    private $uri;

    /** @var array Map of all registered headers, as original name => array of values */
    private $headers = [];

    /** @var array Map of lowercase header name => original name at registration */
    private $headerNames = [];

    /** @var string */
    private $protocol = '1.1';

    /** @var StreamInterface */
    private $stream;

    /**
     * @param string                               $method  HTTP method
     * @param string|UriInterface                  $uri     URI
     * @param array                                $headers Request headers
     * @param null|resource|StreamInterface|string $body    Request body
     * @param string                               $version Protocol version
     */
    public function __construct(
        $method,
        $uri,
        array $headers = [],
        $body = null,
        $version = '1.1'
    ) {
        if (!$uri instanceof UriInterface) {
            $uri = new Uri($uri);
        }

        $this->method = mb_strtoupper($method);
        $this->uri = $uri;
        $this->setHeaders($headers);
        $this->protocol = $version;

        if (!$this->hasHeader('Host')) {
            $this->updateHostFromUri();
        }

        if ('' !== $body && null !== $body) {
            $this->stream = stream_for($body);
        }
    }

    public function getRequestTarget(): string
    {
        if (null !== $this->requestTarget) {
            return $this->requestTarget;
        }

        $target = $this->uri->getPath();
        if ('' === $target) {
            $target = '/';
        }
        if ('' !== $this->uri->getQuery()) {
            $target .= '?'.$this->uri->getQuery();
        }

        return $target;
    }

    public function withRequestTarget(string $requestTarget): RequestInterface
    {
        if (preg_match('#\s#', $requestTarget)) {
            throw new \InvalidArgumentException('Invalid request target provided; cannot contain whitespace');
        }

        $new = clone $this;
        $new->requestTarget = $requestTarget;

        return $new;
    }

    public function getMethod(): string
    {
        return $this->method;
    }

    public function withMethod(string $method): RequestInterface
    {
        $new = clone $this;
        $new->method = mb_strtoupper($method);

        return $new;
    }

    public function getUri(): UriInterface
    {
        return $this->uri;
    }

    public function withUri(UriInterface $uri, $preserveHost = false): RequestInterface
    {
        if ($uri === $this->uri) {
            return $this;
        }

        $new = clone $this;
        $new->uri = $uri;

        if (!$preserveHost) {
            $new->updateHostFromUri();
        }

        return $new;
    }

    public function getProtocolVersion(): string
    {
        return $this->protocol;
    }

    public function withProtocolVersion(string $version): RequestInterface
    {
        if ($this->protocol === $version) {
            return $this;
        }
        $new = clone $this;
        $new->protocol = $version;

        return $new;
    }

    public function getHeaders(): array
    {
        return $this->headers;
    }

    public function hasHeader(string $name): bool
    {
        return isset($this->headerNames[mb_strtolower($name)]);
    }

    public function getHeader(string $name): array
    {
        $name = mb_strtolower($name);
        if (!isset($this->headerNames[$name])) {
            return [];
        }
        $name = $this->headerNames[$name];

        return $this->headers[$name];
    }

    public function getHeaderLine(string $header): string
    {
        return implode(', ', $this->getHeader($header));
    }

    public function withHeader(string $header, $value): MessageInterface
    {
        if (!is_array($value)) {
            $value = [$value];
        }
        $value = $this->trimHeaderValues($value);
        $normalized = mb_strtolower($header);
        $new = clone $this;
        if (isset($new->headerNames[$normalized])) {
            unset($new->headers[$new->headerNames[$normalized]]);
        }
        $new->headerNames[$normalized] = $header;
        $new->headers[$header] = $value;

        return $new;
    }

    public function withAddedHeader(string $header, $value): MessageInterface
    {
        if (!is_array($value)) {
            $value = [$value];
        }
        $value = $this->trimHeaderValues($value);
        $normalized = mb_strtolower($header);
        $new = clone $this;
        if (isset($new->headerNames[$normalized])) {
            $header = $this->headerNames[$normalized];
            $new->headers[$header] = array_merge(
                $this->headers[$header],
                $value
            );
        } else {
            $new->headerNames[$normalized] = $header;
            $new->headers[$header] = $value;
        }

        return $new;
    }

    public function withoutHeader(string $header): MessageInterface
    {
        $normalized = mb_strtolower($header);
        if (!isset($this->headerNames[$normalized])) {
            return $this;
        }
        $header = $this->headerNames[$normalized];
        $new = clone $this;
        unset($new->headers[$header], $new->headerNames[$normalized]);

        return $new;
    }

    public function getBody(): StreamInterface
    {
        if (!$this->stream) {
            $this->stream = stream_for('');
        }

        return $this->stream;
    }

    public function withBody(StreamInterface $body): MessageInterface
    {
        if ($body === $this->stream) {
            return $this;
        }
        $new = clone $this;
        $new->stream = $body;

        return $new;
    }

    private function updateHostFromUri()
    {
        $host = $this->uri->getHost();

        if ('' === $host) {
            return;
        }

        if (null !== ($port = $this->uri->getPort())) {
            $host .= ':'.$port;
        }

        if (isset($this->headerNames['host'])) {
            $header = $this->headerNames['host'];
        } else {
            $header = 'Host';
            $this->headerNames['host'] = 'Host';
        }
        // Ensure Host is the first header.
        // See: http://tools.ietf.org/html/rfc7230#section-5.4
        $this->headers = [$header => [$host]] + $this->headers;
    }

    private function setHeaders(array $headers)
    {
        $this->headerNames = $this->headers = [];
        foreach ($headers as $header => $value) {
            if (!is_array($value)) {
                $value = [$value];
            }
            $value = $this->trimHeaderValues($value);
            $normalized = mb_strtolower($header);
            if (isset($this->headerNames[$normalized])) {
                $header = $this->headerNames[$normalized];
                $this->headers[$header] = array_merge(
                    $this->headers[$header],
                    $value
                );
            } else {
                $this->headerNames[$normalized] = $header;
                $this->headers[$header] = $value;
            }
        }
    }

    /**
     * Trims whitespace from the header values.
     *
     * Spaces and tabs ought to be excluded by parsers when extracting the field value from a header field.
     *
     * header-field = field-name ":" OWS field-value OWS
     * OWS          = *( SP / HTAB )
     *
     * @param string[] $values Header values
     *
     * @return string[] Trimmed header values
     *
     * @see https://tools.ietf.org/html/rfc7230#section-3.2.4
     */
    private function trimHeaderValues(array $values)
    {
        return array_map(function ($value) {
            return trim($value, " \t");
        }, $values);
    }
}
