using dotenv.net;

namespace Algolia.Utils;

public static class Config
{
  public static Configuration Load()
  {
    DotEnv.Load(options: new DotEnvOptions(ignoreExceptions: false, envFilePaths: new[] { "../.env", "./Playground/.env"}));
    return new Configuration
    {
      AppId = GetEnvVariable("ALGOLIA_APPLICATION_ID"),
      AdminApiKey = GetEnvVariable("ALGOLIA_ADMIN_KEY"),
      MetisAppId = GetEnvVariable("ALGOLIA_METIS_APPLICATION_ID"),
      MetisApiKey = GetEnvVariable("ALGOLIA_METIS_API_KEY"),
      MonitoringApiKey = GetEnvVariable("ALGOLIA_MONITORING_API_KEY"),
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
