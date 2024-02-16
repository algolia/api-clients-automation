export function union(expected: any, received: any): any {
  if (Array.isArray(expected)) {
    if (Array.isArray(received)) {
      const res = new Array(expected.length);
      for (const [i, v] of expected.entries()) {
        res[i] = union(v, received[i]);
      }

      return res;
    }
    return received;
  }
  if (typeof expected === 'object' && expected !== null) {
    const res = {};
    for (const [key, value] of Object.entries(expected)) {
      if (key in received) {
        res[key] = union(value, received[key]);
      }
    }

    return res;
  }

  return received;
}
