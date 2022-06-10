package com.algolia.utils;

import com.algolia.utils.retry.StatefulHost;
import java.util.List;
import java.util.ArrayList;

public class ClientOptions {

  private Requester requester;
  private List<AlgoliaAgent.Segment> algoliaAgentSegments;
  private List<StatefulHost> hosts;

  private ClientOptions() {
    algoliaAgentSegments = new ArrayList<>();
  }

  public static ClientOptions build() {
    return new ClientOptions();
  }

  public Requester getRequester() {
    return this.requester;
  }

  public ClientOptions setRequester(Requester requester) {
    this.requester = requester;
    return this;
  }

  public List<AlgoliaAgent.Segment> getAlgoliaAgentSegments() {
    return this.algoliaAgentSegments;
  }

  public ClientOptions setAlgoliaAgentSegments(List<AlgoliaAgent.Segment> algoliaAgentSegments) {
    this.algoliaAgentSegments = algoliaAgentSegments;
    return this;
  }

  public ClientOptions addAlgoliaAgentSegment(AlgoliaAgent.Segment algoliaAgentSegment) {
    this.algoliaAgentSegments.add(algoliaAgentSegments);
    return this;
  }

  public ClientOptions addAlgoliaAgentSegment(String value, String version) {
    this.algoliaAgentSegments.add(new AlgoliaAgent.Segment(string, version));
    return this;
  }

  public List<StatefulHost> getHosts() {
    return this.hosts;
  }

  public ClientOptions setHosts(List<StatefulHost> hosts) {
    this.hosts = hosts;
    return this;
  }
}
