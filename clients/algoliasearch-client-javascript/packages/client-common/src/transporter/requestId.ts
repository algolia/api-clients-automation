const BASE62_CHARS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
const REQUEST_ID_LENGTH = 11;

export function generateRequestId(): string {
  let requestId = '';

  if (typeof globalThis.crypto?.getRandomValues === 'function') {
    const bytes = new Uint8Array(REQUEST_ID_LENGTH);
    globalThis.crypto.getRandomValues(bytes);
    for (const byte of bytes) {
      requestId += BASE62_CHARS[byte % BASE62_CHARS.length];
    }

    return requestId;
  }

  for (let i = 0; i < REQUEST_ID_LENGTH; i++) {
    requestId += BASE62_CHARS[Math.floor(Math.random() * BASE62_CHARS.length)];
  }

  return requestId;
}
