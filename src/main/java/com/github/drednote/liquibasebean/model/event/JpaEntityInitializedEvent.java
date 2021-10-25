package com.github.drednote.liquibasebean.model.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class JpaEntityInitializedEvent extends ApplicationEvent {

  private final String message;

  public JpaEntityInitializedEvent(Object source, String message) {
    super(source);
    this.message = message;
  }
}
