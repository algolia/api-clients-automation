/* eslint-disable no-console */
import ora from 'ora-classic';

class OraLog {
  private _text: string;

  constructor(text: string) {
    this._text = text;
  }

  private maybeText(text?: string): void {
    if (text !== undefined) {
      this._text = text;
      this.start();
    }
  }

  start(): this {
    console.log(this._text);
    return this;
  }

  succeed(text?: string): void {
    this.maybeText(text);
  }

  fail(text?: string): void {
    this.maybeText(text);
  }

  warn(text?: string): void {
    this.maybeText(text);
  }

  info(text?: string): void {
    this.maybeText(text);
  }

  get text(): string {
    return this._text;
  }

  set text(text: string) {
    this._text = text;
    this.start();
  }
}

/**
 * Returns a spinner that will log directly in verbose mode, to avoid conflict with other log.
 */
export function createSpinner(
  text: string,
  verbose: boolean
): ora.Ora | OraLog {
  if (verbose) {
    return new OraLog(text);
  }
  return ora(text);
}
