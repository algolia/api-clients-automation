import { EndRequest, Request, Response } from '../types';
import { Requester } from './Requester';

export class EchoRequester extends Requester {
  async send(request: EndRequest, originalRequest: Request): Promise<Response> {
    return {
      content: JSON.stringify(originalRequest),
      isTimedOut: false,
      status: 200,
    };
  }
}
