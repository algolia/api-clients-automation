/**
 * Segments that the user belongs to.
 */
export type FetchUserProfileResponseSegments = {
  /**
   * List of computed segments IDs.
   */
  computed?: string[];
  /**
   * List of custom segments IDs.
   */
  custom?: string[];
};
