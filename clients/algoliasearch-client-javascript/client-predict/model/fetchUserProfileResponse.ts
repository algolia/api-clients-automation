import type { FetchUserProfileResponsePredictions } from './fetchUserProfileResponsePredictions';
import type { FetchUserProfileResponseProperties } from './fetchUserProfileResponseProperties';
import type { FetchUserProfileResponseSegments } from './fetchUserProfileResponseSegments';

export type FetchUserProfileResponse = {
  user: string;
  predictions?: FetchUserProfileResponsePredictions;
  properties?: FetchUserProfileResponseProperties;
  segments?: FetchUserProfileResponseSegments;
};
