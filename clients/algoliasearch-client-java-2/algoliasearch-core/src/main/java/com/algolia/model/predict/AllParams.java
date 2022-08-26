// This file is generated, manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation.

package com.algolia.model.predict;

import com.fasterxml.jackson.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** AllParams */
public class AllParams {

  @JsonProperty("modelsToRetrieve")
  private List<ModelsToRetrieve> modelsToRetrieve;

  @JsonProperty("typesToRetrieve")
  private List<TypesToRetrieve> typesToRetrieve;

  public AllParams setModelsToRetrieve(List<ModelsToRetrieve> modelsToRetrieve) {
    this.modelsToRetrieve = modelsToRetrieve;
    return this;
  }

  public AllParams addModelsToRetrieve(ModelsToRetrieve modelsToRetrieveItem) {
    if (this.modelsToRetrieve == null) {
      this.modelsToRetrieve = new ArrayList<>();
    }
    this.modelsToRetrieve.add(modelsToRetrieveItem);
    return this;
  }

  /**
   * Get modelsToRetrieve
   *
   * @return modelsToRetrieve
   */
  @javax.annotation.Nullable
  public List<ModelsToRetrieve> getModelsToRetrieve() {
    return modelsToRetrieve;
  }

  public AllParams setTypesToRetrieve(List<TypesToRetrieve> typesToRetrieve) {
    this.typesToRetrieve = typesToRetrieve;
    return this;
  }

  public AllParams addTypesToRetrieve(TypesToRetrieve typesToRetrieveItem) {
    if (this.typesToRetrieve == null) {
      this.typesToRetrieve = new ArrayList<>();
    }
    this.typesToRetrieve.add(typesToRetrieveItem);
    return this;
  }

  /**
   * Get typesToRetrieve
   *
   * @return typesToRetrieve
   */
  @javax.annotation.Nullable
  public List<TypesToRetrieve> getTypesToRetrieve() {
    return typesToRetrieve;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllParams allParams = (AllParams) o;
    return (
      Objects.equals(this.modelsToRetrieve, allParams.modelsToRetrieve) && Objects.equals(this.typesToRetrieve, allParams.typesToRetrieve)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(modelsToRetrieve, typesToRetrieve);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllParams {\n");
    sb.append("    modelsToRetrieve: ").append(toIndentedString(modelsToRetrieve)).append("\n");
    sb.append("    typesToRetrieve: ").append(toIndentedString(typesToRetrieve)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
