<?php

namespace Algolia\AlgoliaSearch\Exceptions;

final class UnreachableException extends AlgoliaException
{
    public function __construct($message = '', $code = 0, $previous = null)
    {
        if (!$message) {
            $message =
                'Impossible to connect, please check your Algolia Application Id. If the error persists, please visit our help center <SUPPORT_LINK_HERE> or reach out to the Algolia Support team: https://alg.li/support.';
        }

        parent::__construct($message, $code, $previous);
    }
}
