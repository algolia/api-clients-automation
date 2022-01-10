export type InlineResponse2002 = {
  /**
   * Date and time of creation of the record.
   */
  timestamp: Date;
  /**
   * Type of the record, can be one of three values (INFO, SKIP or ERROR).
   */
  level: InlineResponse2002Level;
  /**
   * Detailed description of what happened.
   */
  message: string;
  /**
   * Indicates the hierarchy of the records. For example, a record with contextLevel=1 belongs to a preceding record with contextLevel=0.
   */
  contextLevel: number;
};

export type InlineResponse2002Level = 'ERROR' | 'INFO' | 'SKIP';
