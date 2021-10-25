package com.github.drednote.liquibasebean.service;

import com.github.drednote.liquibasebean.publisher.EventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EntityManagerFactoryBeanPostProcessor implements BeanPostProcessor {

  private final EventPublisher eventPublisher;

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if (!(bean instanceof AbstractEntityManagerFactoryBean)) {
      return bean;
    }
    ProxyFactory proxyFactory = new ProxyFactory(bean);
    proxyFactory.addAdvice(eventPublisher);
    return proxyFactory.getProxy();
  }
}
