package com.algolia.manual;

import static org.junit.jupiter.api.Assertions.*;

import com.algolia.api.SearchClient;
import com.algolia.config.CallType;
import com.algolia.config.ClientOptions;
import com.algolia.config.Host;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.SocketFactory;
import okhttp3.Interceptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/** Pins that client sockets disable Nagle's algorithm, including with a custom socket factory. */
class TcpNoDelayTest {

  private ServerSocket server;
  private Thread serverThread;

  @BeforeEach
  void startServer() throws Exception {
    server = new ServerSocket(0, 50, InetAddress.getLoopbackAddress());
    serverThread = new Thread(() -> {
      while (!server.isClosed()) {
        try (Socket socket = server.accept()) {
          BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
          int contentLength = 0;
          String line;
          while ((line = reader.readLine()) != null && !line.isEmpty()) {
            if (line.toLowerCase().startsWith("content-length:")) {
              contentLength = Integer.parseInt(line.substring("content-length:".length()).trim());
            }
          }
          for (int i = 0; i < contentLength; i++) reader.read();
          OutputStream out = socket.getOutputStream();
          out.write(
            "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\nContent-Length: 2\r\nConnection: close\r\n\r\n{}".getBytes(
              StandardCharsets.UTF_8
            )
          );
          out.flush();
        } catch (Exception e) {
          // server closed
        }
      }
    });
    serverThread.setDaemon(true);
    serverThread.start();
  }

  @AfterEach
  void stopServer() throws Exception {
    server.close();
    serverThread.join(1000);
  }

  private SearchClient clientCapturingNoDelay(AtomicReference<Boolean> tcpNoDelay, SocketFactory customFactory) {
    Interceptor capture = chain -> {
      tcpNoDelay.set(chain.connection().socket().getTcpNoDelay());
      return chain.proceed(chain.request());
    };
    Host host = new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", server.getLocalPort());
    return new SearchClient(
      "appId",
      "apiKey",
      ClientOptions.builder()
        .setHosts(Collections.singletonList(host))
        .setRequesterConfig(requester -> {
          requester.addNetworkInterceptor(capture);
          if (customFactory != null) {
            requester.setHttpClientConfig(okhttp -> okhttp.socketFactory(customFactory));
          }
        })
        .build()
    );
  }

  @Test
  @Timeout(10)
  @DisplayName("client sockets have TCP_NODELAY enabled by default")
  void socketsHaveTcpNoDelayByDefault() throws Exception {
    AtomicReference<Boolean> tcpNoDelay = new AtomicReference<>();
    try (SearchClient client = clientCapturingNoDelay(tcpNoDelay, null)) {
      client.customPost("1/test");
    }
    assertEquals(Boolean.TRUE, tcpNoDelay.get());
  }

  @Test
  @Timeout(10)
  @DisplayName("TCP_NODELAY stays enabled with a socket factory set through setHttpClientConfig")
  void customSocketFactoryKeepsTcpNoDelay() throws Exception {
    AtomicReference<Boolean> tcpNoDelay = new AtomicReference<>();
    try (SearchClient client = clientCapturingNoDelay(tcpNoDelay, SocketFactory.getDefault())) {
      client.customPost("1/test");
    }
    assertEquals(Boolean.TRUE, tcpNoDelay.get());
  }
}
