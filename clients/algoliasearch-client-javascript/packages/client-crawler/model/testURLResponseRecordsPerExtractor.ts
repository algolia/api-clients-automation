export type TestURLResponseRecordsPerExtractor = {
  /**
   * Index of the extractor.
   */
  index?: number;
  /**
   * Type of the extractor.
   */
  type?: string;
  records?: Array<Record<string, any>>;
};
