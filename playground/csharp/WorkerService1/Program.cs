using WorkerService1;

var builder = Host.CreateApplicationBuilder(args);
builder.Services.AddHostedService<Worker>();
builder.Logging.AddFilter("Algolia", LogLevel.Information).AddConsole();

var host = builder.Build();
host.Run();
