using System.Runtime.Serialization;
using Algolia.Search.Models.Search;

public class TestObject : Hit
{
  [DataMember(Name = "value")] 
  public string? Value { get; set; }

  [DataMember(Name = "otherValue")] 
  public string? OtherValue { get; set; }
}
