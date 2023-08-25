package com.algolia.utils.retry;

import com.algolia.utils.Utils;
import java.time.OffsetDateTime;
import java.util.EnumSet;
import java.util.Set;

public class StatefulHost {

  private String host;
  private String scheme;
  private boolean up = true;
  private int retryCount;
  private OffsetDateTime lastUse = Utils.nowUTC();
  private Set<CallType> accept;

  public StatefulHost(String host, String scheme, Set<CallType> accept) {
    this.host = host;
    this.scheme = scheme;
    this.accept = accept;
  }

  public String getHost() {
    return host;
  }

  StatefulHost setHost(String host) {
    this.host = host;
    return this;
  }

  public String getScheme() {
    return this.scheme;
  }

  StatefulHost setScheme(String scheme) {
    this.scheme = scheme;
    return this;
  }

  public boolean isUp() {
    return up;
  }

  StatefulHost setUp(boolean up) {
    this.up = up;
    return this;
  }

  public int getRetryCount() {
    return retryCount;
  }

  StatefulHost setRetryCount(int retryCount) {
    this.retryCount = retryCount;
    return this;
  }

  void incrementRetryCount() {
    this.retryCount++;
  }

  public OffsetDateTime getLastUse() {
    return lastUse;
  }

  StatefulHost setLastUse(OffsetDateTime lastUse) {
    this.lastUse = lastUse;
    return this;
  }

  public Set<CallType> getAccept() {
    return accept;
  }

  StatefulHost setAccept(EnumSet<CallType> accept) {
    this.accept = accept;
    return this;
  }
}
