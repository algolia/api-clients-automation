using Microsoft.Extensions.Logging;

namespace Algolia.Search.Utils;

internal static class LoggerExtensions
{
  public static void LogInfo(this ILogger logger, string message, params object[] args) =>
    logger.LogInformation(message, args);
}
