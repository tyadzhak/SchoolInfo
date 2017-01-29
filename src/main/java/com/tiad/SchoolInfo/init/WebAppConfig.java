package com.tiad.SchoolInfo.init;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.web.config.SpringDataWebConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.tiad.SchoolInfo.common.loggin.Logging;
import com.tiad.SchoolInfo.common.loggin.LoggingAnnotationProcessor;

@Configuration
@EnableWebMvc
@ComponentScan("com.tiad.SchoolInfo")
@PropertySource("classpath:application.properties")
@EnableMongoRepositories("com.tiad.SchoolInfo.repository")
public class WebAppConfig extends AbstractMongoConfiguration {
	@Logging(WebAppConfig.class)
	Logger logger;

	@Autowired
	private Environment env;

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		try {
			UrlBasedViewResolver resolver = new UrlBasedViewResolver();
			resolver.setPrefix("/WEB-INF/pages/");
			resolver.setSuffix(".jsp");
			resolver.setViewClass(JstlView.class);
			return resolver;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@Bean
	protected String getDatabaseName() {
		try {
			return env.getRequiredProperty("mongo.name");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		try {
			ServerAddress serverAddress = new ServerAddress(
					env.getRequiredProperty("mongo.host"));
			List<MongoCredential> credentials = new ArrayList<>();
			credentials.add(MongoCredential.createScramSha1Credential(env
					.getRequiredProperty("mongo.username"), env
					.getRequiredProperty("mongo.name"), env
					.getRequiredProperty("mongo.password").toCharArray()));

			MongoClientOptions options = new MongoClientOptions.Builder()
					.build();
			return new MongoClient(serverAddress, credentials, options);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@Bean
	public LoggingAnnotationProcessor loggingAnnotationProcessor() {
		return new LoggingAnnotationProcessor();
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename(env.getRequiredProperty("message.source.basename"));
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
}
