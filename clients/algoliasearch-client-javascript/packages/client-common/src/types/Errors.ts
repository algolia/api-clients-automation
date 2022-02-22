import type { Response } from './Requester';
import type { StackFrame } from './Transporter';

export type RetryError = Error & {
  /**
   * Contains report of stack frames of the
   * execution of a certain request.
   */
  stackTrace: StackFrame[];
};

export type ApiError = Error & {
  /**
   * The http status code.
   */
  status: number;

  /**
   * Contains report of stack frames of the
   * execution of a certain request.
   */
  stackTrace: StackFrame[];
};

export type DeserializationError = Error & {
  /**
   * The raw response from the server.
   */
  response: Response;
};
