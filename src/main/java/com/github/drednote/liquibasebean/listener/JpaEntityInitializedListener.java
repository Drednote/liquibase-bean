package com.github.drednote.liquibasebean.listener;

import com.github.drednote.liquibasebean.changeset.ChangeSet;
import com.github.drednote.liquibasebean.model.event.JpaEntityInitializedEvent;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JpaEntityInitializedListener implements
    ApplicationListener<JpaEntityInitializedEvent> {

  private final Collection<ChangeSet> changeSets;

  @Override
  public void onApplicationEvent(JpaEntityInitializedEvent event) {
    log.info("Get event with message {} from {}", event.getMessage(), event.getSource());
    for (ChangeSet changeSet : changeSets) {
      changeSet.execute();
    }
  }
}
