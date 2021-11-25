export * from './recommendApi';
import { RecommendApi } from './recommendApi';
export * from '../utils/errors';
export { EchoRequester } from '../utils/EchoRequester';

export class RecommendApiClient extends RecommendApi {}
export const APIS = [RecommendApi];
