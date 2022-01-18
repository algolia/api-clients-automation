<?php

namespace Algolia\AlgoliaSearch\Configuration;

abstract class AbstractConfig
{
    protected $config;

    protected $defaultReadTimeout = 5;

    protected $defaultWriteTimeout = 30;

    protected $defaultConnectTimeout = 2;

    public function __construct(array $config = [])
    {
        $config += $this->getDefaultConfiguration();
        $this->config = $config;
    }

    public static function create($appId = null, $apiKey = null)
    {
        $config = [
            'appId' => null !== $appId ? $appId : getenv('ALGOLIA_APP_ID'),
            'apiKey' => null !== $apiKey ? $apiKey : getenv('ALGOLIA_API_KEY'),
        ];

        return new static($config);
    }

    public function getDefaultConfiguration()
    {
        return [
            'appId' => '',
            'apiKey' => '',
            'hosts' => null,
            'readTimeout' => $this->defaultReadTimeout,
            'writeTimeout' => $this->defaultWriteTimeout,
            'connectTimeout' => $this->defaultConnectTimeout,
            'defaultHeaders' => [],
        ];
    }

    public function getAppId()
    {
        return $this->config['appId'];
    }

    public function setAppId($appId)
    {
        $this->config['appId'] = $appId;

        return $this;
    }

    public function getAlgolliaApiKey()
    {
        return $this->config['apiKey'];
    }

    public function setAlgoliaApiKey($apiKey)
    {
        $this->config['apiKey'] = $apiKey;

        return $this;
    }

    public function getHosts()
    {
        return $this->config['hosts'];
    }

    public function setHosts($hosts)
    {
        $this->config['hosts'] = $hosts;

        return $this;
    }

    public function getReadTimeout()
    {
        return $this->config['readTimeout'];
    }

    public function setReadTimeout($readTimeout)
    {
        $this->config['readTimeout'] = $readTimeout;

        return $this;
    }

    public function getWriteTimeout()
    {
        return $this->config['writeTimeout'];
    }

    public function setWriteTimeout($writeTimeout)
    {
        $this->config['writeTimeout'] = $writeTimeout;

        return $this;
    }

    public function getConnectTimeout()
    {
        return $this->config['connectTimeout'];
    }

    public function setConnectTimeout($connectTimeout)
    {
        $this->config['connectTimeout'] = $connectTimeout;

        return $this;
    }

    public function getDefaultHeaders()
    {
        return $this->config['defaultHeaders'];
    }

    public function setDefaultHeaders(array $defaultHeaders)
    {
        $this->config['defaultHeaders'] = $defaultHeaders;

        return $this;
    }
}
