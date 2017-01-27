package com.tiad.SchoolInfo.common.loggin;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LoggingAnnotationProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		try {
			Class clazz = bean.getClass();
			do {
				for (Field field : clazz.getDeclaredFields()) {
					Logging annotation = field.getAnnotation(Logging.class);
					if (annotation != null) {
						boolean accessible = field.isAccessible();
						field.setAccessible(true);
						try {
							if (annotation.value() != null) {
								field.set(bean,
										Logger.getLogger(annotation.value()));
							} else {
								field.set(bean, Logger.getLogger(clazz));
							}
						} catch (IllegalAccessException e) {
							Logger.getLogger(this.getClass()).error(
									e.getMessage(), e);
						}
						field.setAccessible(accessible);
					}
				}
				clazz = clazz.getSuperclass();
			} while (clazz != null);
			return bean;
		} catch (Exception e) {
			Logger.getLogger(this.getClass()).error(e.getMessage(), e);
			throw e;
		}

	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		return bean;
	}

}
