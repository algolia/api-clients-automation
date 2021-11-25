export * from './searchApi';
import { SearchApi } from './searchApi';
export * from '../utils/errors';
export { EchoRequester } from '../utils/EchoRequester';

export class SearchApiClient extends SearchApi {}
export const APIS = [SearchApi];
