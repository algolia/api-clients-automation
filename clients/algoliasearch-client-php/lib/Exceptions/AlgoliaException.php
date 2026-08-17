<?php

namespace Algolia\AlgoliaSearch\Exceptions;

class AlgoliaException extends \Exception
{
    /**
     * @var null|string
     */
    protected $correlationId;

    /**
     * @param string          $message
     * @param int             $code
     * @param null|\Throwable $previous
     * @param null|string     $correlationId the `Correlation-ID` returned by the failing response
     */
    public function __construct($message = '', $code = 0, $previous = null, $correlationId = null)
    {
        $this->correlationId = $correlationId;

        if (null !== $correlationId && '' !== $correlationId) {
            $message .= ' (Correlation-ID: '.$correlationId.')';
        }

        parent::__construct($message, $code, $previous);
    }

    /**
     * @return null|string the `Correlation-ID` of the failing response, null when the server sent none
     */
    public function getCorrelationId()
    {
        return $this->correlationId;
    }
}
