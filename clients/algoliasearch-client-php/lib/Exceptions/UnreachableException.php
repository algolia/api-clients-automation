<?php

namespace Algolia\AlgoliaSearch\Exceptions;

final class UnreachableException extends AlgoliaException
{
    /**
     * @var array<int, array{host: string, error: \Exception}>
     */
    private $errors;

    public function __construct($message = '', $code = 0, $previous = null, array $errors = [])
    {
        if (!$message) {
            $message
                = 'Unreachable hosts. If the error persists, please visit our help center https://alg.li/support-unreachable-hosts or reach out to the Algolia Support team: https://alg.li/support';
        }

        $lastError = end($errors);
        if (false !== $lastError) {
            $message .= ' Last error for '.$lastError['host'].': '.$lastError['error']->getMessage();
        }

        parent::__construct($message, $code, $previous);
        $this->errors = $errors;
    }

    /**
     * @return array<int, array{host: string, error: \Exception}>
     */
    public function getErrors()
    {
        return $this->errors;
    }
}
