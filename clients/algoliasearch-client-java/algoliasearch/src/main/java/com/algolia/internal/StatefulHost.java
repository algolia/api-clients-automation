package com.algolia.internal;

import com.algolia.config.CallType;
import com.algolia.config.Host;
import com.algolia.utils.DateTimeUtils;
import java.time.OffsetDateTime;
import java.util.Set;

public final class StatefulHost {

  private final Host host;
  private boolean up = true;
  private int retryCount;
  private OffsetDateTime lastUse = DateTimeUtils.nowUTC();

  public StatefulHost(Host host) {
    this.host = host;
  }

  public String getHost() {
    return host.getUrl();
  }

  public String getScheme() {
    return this.host.getScheme();
  }

  public boolean isUp() {
    return up;
  }

  public StatefulHost setUp(boolean up) {
    this.up = up;
    return this;
  }

  public int getRetryCount() {
    return retryCount;
  }

  public StatefulHost resetCount() {
    this.retryCount = 0;
    return this;
  }

  public void incrementRetryCount() {
    this.retryCount++;
  }

  public OffsetDateTime getLastUse() {
    return lastUse;
  }

  public StatefulHost setLastUse(OffsetDateTime lastUse) {
    this.lastUse = lastUse;
    return this;
  }

  public Set<CallType> getAccept() {
    return this.host.getCallTypes();
  }
}
