package com.github.drednote.liquibasebean.changeset;

import com.github.drednote.liquibasebean.model.TestEntity;
import com.github.drednote.liquibasebean.repository.TestEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(1)
public class SecondExampleChangeSet implements ChangeSet {

  private final TestEntityRepository testEntityRepository;

  @Override
  public void execute() {
    for (int i = 0; i < 100; i++) {
      TestEntity testEntity = new TestEntity();
      testEntity.setText("hi" + i);
      testEntityRepository.save(testEntity);
    }
  }
}
