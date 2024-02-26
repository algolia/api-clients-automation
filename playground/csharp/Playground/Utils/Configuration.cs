using dotenv.net;

namespace Algolia.Utils;

public static class Config
{
  public static Configuration Load()
  {
    DotEnv.Load(options: new DotEnvOptions(ignoreExceptions: false, probeForEnv: true, probeLevelsToSearch: 6));
    return new Configuration
    {
      AppId = GetEnvVariable("ALGOLIA_APPLICATION_ID"),
      AdminApiKey = GetEnvVariable("ALGOLIA_ADMIN_KEY"),
      SearchApiKey = GetEnvVariable("ALGOLIA_SEARCH_KEY"),
      MonitoringApiKey = GetEnvVariable("MONITORING_KEY"),
    };
  }

  private static string GetEnvVariable(string enVarName)
  {
    var appId = Environment.GetEnvironmentVariable(enVarName);
    if (appId == null)
    {
      throw new Exception($"please provide an `{enVarName}` env var");
    }

    return appId;
  }
}
