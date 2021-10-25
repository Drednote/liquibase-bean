package com.github.drednote.liquibasebean.changeset;

import com.github.drednote.liquibasebean.model.TestEntity;
import com.github.drednote.liquibasebean.repository.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(0)
public class FirstExampleChangeSet implements ChangeSet {

  private final TestEntityRepository testEntityRepository;

  @Override
  public void execute() {
    TestEntity testEntity = new TestEntity();
    testEntity.setText("hi");
    testEntityRepository.save(testEntity);
  }
}
