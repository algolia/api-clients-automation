/**
 * Represent a group of items and pagination information.
 */
export type Pagination = {
  items?: Array<Record<string, any>>;
  /**
   * The maximum number of items returned by this request.
   */
  itemsPerPage?: number;
  /**
   * The current page browsed by this request.
   */
  page?: number;
  /**
   * The total number of items.
   */
  total?: number;
};
