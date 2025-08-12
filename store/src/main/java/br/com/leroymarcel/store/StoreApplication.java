package br.com.leroymarcel.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;

@SpringBootApplication(
		exclude = {
				WebFluxAutoConfiguration.class, ThymeleafAutoConfiguration.class,
				MailSenderAutoConfiguration.class, FlywayAutoConfiguration.class,
				SecurityAutoConfiguration.class, RabbitAutoConfiguration.class,
				KafkaAutoConfiguration.class, TaskSchedulingAutoConfiguration.class
		}
)
public class StoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
}
