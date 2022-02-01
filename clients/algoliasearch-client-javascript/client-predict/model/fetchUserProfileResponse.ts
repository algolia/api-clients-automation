import { FetchUserProfileResponsePredictions } from './fetchUserProfileResponsePredictions';
import { FetchUserProfileResponseProperties } from './fetchUserProfileResponseProperties';
import { FetchUserProfileResponseSegments } from './fetchUserProfileResponseSegments';


export type FetchUserProfileResponse = {
    user: string;
    predictions?: FetchUserProfileResponsePredictions;
    properties?: FetchUserProfileResponseProperties;
    segments?: FetchUserProfileResponseSegments;
}



