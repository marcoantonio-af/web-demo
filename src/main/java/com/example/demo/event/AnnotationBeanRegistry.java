package com.example.demo.event;

import com.example.demo.event.annotation.Consumer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author zhangjie [zhangjie02@yinhai.com]
 */
@Component
public class AnnotationBeanRegistry implements InitializingBean {

	public static final String CUSTOMER_TOPIC = "CONSUMER_TOPIC_";
	public static final String SYNCHRONIZATION = "SYNCHRONIZATION_";

	@Resource
	private final ApplicationContext context;


	public AnnotationBeanRegistry(ApplicationContext context) {
		Assert.notNull(context, "无法获取ApplicationContext");
		this.context = context;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		String[] consumers = context.getBeanNamesForAnnotation(Consumer.class);
		String key;
		Map<String, List<String>> beanMap = new HashMap<>(16);
		for (String c : consumers) {
			Consumer consumer = context.findAnnotationOnBean(c, Consumer.class);
			if (null == consumer) {
				continue;
			}
			//这个地方注册的时候只把async=true的注册进去,
			if (consumer.async()) {
				key = CUSTOMER_TOPIC + consumer.value();
			} else {
				key = SYNCHRONIZATION + consumer.value();
			}
			if (!beanMap.containsKey(key)) {
				beanMap.put(key, new ArrayList<>(0));
			}
			beanMap.get(key).add(c);
		}
		Iterator<String> iter = beanMap.keySet().iterator();
		BeanDefinitionBuilder beanDefinitionBuilder;

		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) context;
		BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory();

		while (iter.hasNext()) {
			key = iter.next();
			beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayList.class);
			beanDefinitionBuilder.addConstructorArgValue(beanMap.get(key));
			beanDefinitionRegistry.registerBeanDefinition(key, beanDefinitionBuilder.getBeanDefinition());
		}
	}


}
