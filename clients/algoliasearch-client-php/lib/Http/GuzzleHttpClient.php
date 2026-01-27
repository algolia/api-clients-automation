<?php

namespace Algolia\AlgoliaSearch\Http;

use Algolia\AlgoliaSearch\Http\Psr7\Response;
use GuzzleHttp\Client as GuzzleClient;
use GuzzleHttp\Exception\ConnectException;
use GuzzleHttp\Exception\RequestException;
use GuzzleHttp\HandlerStack;
use GuzzleHttp\Middleware;
use Psr\Http\Message\RequestInterface;

final class GuzzleHttpClient implements HttpClientInterface
{
    private $client;

    public function __construct(?GuzzleClient $client = null)
    {
        $this->client = $client ?: self::buildClient();
    }

    public function sendRequest(
        RequestInterface $request,
        $timeout,
        $connectTimeout
    ) {
        try {
            $response = $this->client->send($request, [
                'timeout' => $timeout,
                'connect_timeout' => $connectTimeout,
            ]);
        } catch (RequestException $e) {
            if ($e->hasResponse()) {
                return $e->getResponse();
            }

            return new Response(0, [], null, '1.1', $e->getMessage());
        } catch (ConnectException $e) {
            $context = $e->getHandlerContext();
            $curlError = $context['errno'] ?? null;

            if (null !== $curlError) {
                $isTimeout = (CURLE_OPERATION_TIMEDOUT === $curlError);
            } else {
                // fallback to message checking (if not cURL)
                $isTimeout = str_contains(strtolower($e->getMessage()), 'timeout')
                  || str_contains(strtolower($e->getMessage()), 'timed out');
            }

            return new Response(
                0,
                ['X-Timeout' => $isTimeout ? 'true' : 'false'],
                null,
                '1.1',
                $e->getMessage()
            );
        }

        return $response;
    }

    private static function buildClient(array $config = [])
    {
        $handlerStack = new HandlerStack(\GuzzleHttp\choose_handler());
        $handlerStack->push(Middleware::prepareBody(), 'prepare_body');
        $config = array_merge(['handler' => $handlerStack], $config);

        return new GuzzleClient($config);
    }
}
