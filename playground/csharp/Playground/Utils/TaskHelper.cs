using System.Diagnostics;

namespace Algolia.Utils;

public class TaskHelper
{
  public static async Task Start<T>(Func<Task<T>> ac)
  {
    var stopwatch = new Stopwatch();
    stopwatch.Start();
    var waitResult = await ac().ConfigureAwait(false);
    stopwatch.Stop();
    Console.WriteLine($"Task took {stopwatch.ElapsedMilliseconds}ms");
  }
}
