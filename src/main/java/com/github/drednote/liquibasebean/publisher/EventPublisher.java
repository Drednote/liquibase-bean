package com.github.drednote.liquibasebean.publisher;

import com.github.drednote.liquibasebean.model.event.JpaEntityInitializedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventPublisher implements MethodInterceptor {

  private final ApplicationEventPublisher applicationEventPublisher;

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    String method = invocation.getMethod().getName();
    if (method.equals("afterPropertiesSet")) {
      Object proceed = invocation.proceed();
      String message = String.format("Publish %s event",
          JpaEntityInitializedEvent.class.getSimpleName());
      log.info(message);
      applicationEventPublisher.publishEvent(new JpaEntityInitializedEvent(this, message));
      return proceed;
    }
    return invocation.proceed();
  }
}
