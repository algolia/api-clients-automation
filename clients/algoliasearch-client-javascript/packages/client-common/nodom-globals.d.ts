// Mirrors a Node project without the DOM lib and without `@types/node` declaring `Storage`
// (`@types/node` 20): the only global the published types may rely on is Node's `ReadableStream`.
interface ReadableStream<R = any> {}
