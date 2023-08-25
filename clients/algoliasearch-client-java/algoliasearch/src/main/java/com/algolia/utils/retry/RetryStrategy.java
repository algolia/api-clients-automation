package com.algolia.utils.retry;

import com.algolia.exceptions.AlgoliaApiException;
import com.algolia.exceptions.AlgoliaRetryException;
import com.algolia.utils.UseReadTransporter;
import com.algolia.utils.Utils;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public final class RetryStrategy implements Interceptor {

    private final List<StatefulHost> hosts;

    public RetryStrategy(List<StatefulHost> hosts) {
        this.hosts = hosts;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        UseReadTransporter useReadTransporter = (UseReadTransporter) request.tag();
        Iterator<StatefulHost> hostsIter = getTriableHosts(
                (useReadTransporter != null || request.method().equals("GET")) ? CallType.READ : CallType.WRITE
        ).iterator();
        try {
            while (hostsIter.hasNext()) {
                StatefulHost currentHost = hostsIter.next();

                // Building the request URL
                HttpUrl newUrl = request.url().newBuilder().scheme(currentHost.getScheme()).host(currentHost.getHost()).build();
                request = request.newBuilder().url(newUrl).build();

                // Computing timeout with the retry count
                chain.withConnectTimeout(chain.connectTimeoutMillis() + currentHost.getRetryCount() * 1000, TimeUnit.MILLISECONDS);

                try {
                    Response response = chain.proceed(request);
                    currentHost.setLastUse(Utils.nowUTC());
                    // no timeout
                    if (response.isSuccessful()) {
                        currentHost.setUp(true);
                        return response;
                    }
                    if (isRetryable(response)) {
                        currentHost.setUp(false);
                        response.close();
                        continue;
                    }
                    String message = response.message();
                    if (response.body() != null) {
                        message = response.body().string();
                    }
                    throw new AlgoliaApiException(message, response.code());
                } catch (AlgoliaApiException e) {
                    throw e;
                } catch (SocketTimeoutException e) {
                    // timeout
                    currentHost.setUp(true);
                    currentHost.setLastUse(Utils.nowUTC());
                    currentHost.incrementRetryCount();
                } catch (UnknownHostException e) {
                    throw new AlgoliaApiException(e.getMessage(), 404);
                } catch (Exception e) {
                    throw new AlgoliaApiException(e.getMessage(), 400);
                }
            }
            throw new AlgoliaRetryException("All hosts are unreachable");
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * Tells if the response is retryable or not depending on the http status code
     *
     * @param response Algolia's API response
     */
    private boolean isRetryable(Response response) {
        return response.code() / 100 != 2 && response.code() / 100 != 4;
    }

    /**
     * Gives the available hosts.
     *
     * @param callType Algolia calltype.
     */
    List<StatefulHost> getTriableHosts(CallType callType) {
        synchronized (this) {
            resetExpiredHosts();
            if (hosts.stream().anyMatch(h -> h.isUp() && h.getAccept().contains(callType))) {
                return hosts.stream().filter(h -> h.isUp() && h.getAccept().contains(callType)).collect(Collectors.toList());
            } else {
                for (StatefulHost host : hosts.stream().filter(h -> h.getAccept().contains(callType)).collect(Collectors.toList())) {
                    reset(host);
                }

                return hosts;
            }
        }
    }

    /**
     * Reset the given hosts. Sets the retry count to 0 and set the last use to now.
     *
     * @param host The host to reset
     */
    private void reset(StatefulHost host) {
        host.setUp(true).setRetryCount(0).setLastUse(Utils.nowUTC());
    }

    /**
     * Reset all hosts down for more than 5 minutes.
     */
    private void resetExpiredHosts() {
        for (StatefulHost host : hosts) {
            long lastUse = Duration.between(Utils.nowUTC(), host.getLastUse()).getSeconds();
            if (!host.isUp() && Math.abs(lastUse) > 5 * 60) {
                reset(host);
            }
        }
    }
}
