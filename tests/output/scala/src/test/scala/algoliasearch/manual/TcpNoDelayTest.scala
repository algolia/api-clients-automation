package algoliasearch.manual

import algoliasearch.api.SearchClient
import algoliasearch.config.{CallType, ClientOptions, Host}

import okhttp3.Interceptor
import org.json4s.JValue
import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite

import java.io.{BufferedReader, InputStreamReader}
import java.net.{InetAddress, ServerSocket, Socket}
import java.nio.charset.StandardCharsets
import java.util.concurrent.atomic.AtomicReference
import javax.net.SocketFactory
import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext}
import scala.util.Using

/** Pins that client sockets disable Nagle's algorithm, including with a custom socket factory. */
class TcpNoDelayTest extends AnyFunSuite with BeforeAndAfterEach {
  implicit val ec: ExecutionContext = ExecutionContext.global

  private var server: ServerSocket = null
  private var serverThread: Thread = null

  override def beforeEach(): Unit = {
    server = new ServerSocket(0, 50, InetAddress.getLoopbackAddress)
    serverThread = new Thread(() => {
      while (!server.isClosed) {
        try {
          Using.resource(server.accept()) { socket =>
            val reader = new BufferedReader(new InputStreamReader(socket.getInputStream, StandardCharsets.UTF_8))
            var line = reader.readLine()
            while (line != null && line.nonEmpty) line = reader.readLine()
            socket.getOutputStream.write(
              "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\nContent-Length: 2\r\nConnection: close\r\n\r\n{}"
                .getBytes(StandardCharsets.UTF_8)
            )
            socket.getOutputStream.flush()
          }
        } catch {
          case _: Exception => // server closed
        }
      }
    })
    serverThread.setDaemon(true)
    serverThread.start()
  }

  override def afterEach(): Unit = {
    server.close()
    serverThread.join(1000)
  }

  private def tcpNoDelayOfRequest(customFactory: Option[SocketFactory]): Option[Boolean] = {
    val tcpNoDelay = new AtomicReference[Option[Boolean]](None)
    val capture: Interceptor = chain => {
      tcpNoDelay.set(Some(chain.connection().socket().getTcpNoDelay))
      chain.proceed(chain.request())
    }
    val host = Host("localhost", Set(CallType.Read, CallType.Write), "http", Some(server.getLocalPort))
    val client = SearchClient(
      "appId",
      "apiKey",
      ClientOptions
        .builder()
        .withHosts(List(host))
        .withRequesterConfig { requester =>
          requester.withNetworkInterceptor(capture)
          customFactory.foreach(factory => requester.withHttpClientConfig(_.socketFactory(factory)))
        }
        .build()
    )
    try Await.result(client.customGet[JValue]("1/test"), 10.seconds)
    finally client.close()
    tcpNoDelay.get
  }

  test("client sockets have TCP_NODELAY enabled by default") {
    assert(tcpNoDelayOfRequest(None) == Some(true))
  }

  test("TCP_NODELAY stays enabled with a socket factory set through withHttpClientConfig") {
    assert(tcpNoDelayOfRequest(Some(SocketFactory.getDefault)) == Some(true))
  }
}
