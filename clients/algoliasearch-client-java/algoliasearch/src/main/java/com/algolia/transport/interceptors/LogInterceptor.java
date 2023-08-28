package com.algolia.transport.interceptors;

import com.algolia.config.LogLevel;
import com.algolia.config.Logger;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class LogInterceptor implements Interceptor {
    private final HttpLoggingInterceptor logger;
    public LogInterceptor(Logger logger, LogLevel logLevel) {
        HttpLoggingInterceptor.Logger logr = logger != null
                ? toLogger(logger)
                : HttpLoggingInterceptor.Logger.DEFAULT;
        HttpLoggingInterceptor.Level level = toLevel(logLevel);
        this.logger = new HttpLoggingInterceptor(logr).setLevel(level);
    }

    public HttpLoggingInterceptor.Logger toLogger(@NotNull Logger logger) {
        return logger::log;
    }

    public HttpLoggingInterceptor.Level toLevel(@NotNull LogLevel logLevel) {
        switch (logLevel) {
            case NONE:
                return HttpLoggingInterceptor.Level.NONE;
            case BODY:
                return HttpLoggingInterceptor.Level.BODY;
            case BASIC:
                return HttpLoggingInterceptor.Level.BASIC;
            case HEADERS:
                return HttpLoggingInterceptor.Level.HEADERS;
            default:
                throw new UnsupportedOperationException("Unsupported LogLevel " + logLevel);
        }
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        return logger.intercept(chain);
    }
}
