using System.Runtime.Serialization;
using Algolia.Search.Models.Search;

public class TestObject : Hit
{
  [DataMember(Name = "value")]
  public string? value { get; set; }
  [DataMember(Name = "otherValue")]
  public string? otherValue { get; set; }
}
