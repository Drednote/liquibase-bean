package com.github.drednote.liquibasebean.changeset;

import org.springframework.transaction.annotation.Transactional;

public interface ChangeSet {

  @Transactional
  void execute();
}
