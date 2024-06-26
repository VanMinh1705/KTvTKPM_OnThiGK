package com.example.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;

import net.datafaker.Faker;



@SpringBootApplication
@EnableCaching
public class OrderApplication {
	 private final OrderRepository orderRepository;
	    private final Faker faker = new Faker();

	    public OrderApplication(OrderRepository orderRepository) {
	        this.orderRepository = orderRepository;
	    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	
	 @Bean
	    public CommandLineRunner commandLineRunner() {
	        return args -> {
	            for (int i = 1; i <= 10; i++) {
	                Order order = createFakeOrder();
	                orderRepository.save(order);
	            }
	        };
	    }

	    private Order createFakeOrder() {
	        Order order = new Order();
	        order.setOrderDate(faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
	        order.setStatus(faker.lorem().word());
	        order.setShippingAddress(faker.address().fullAddress());
	        return order;
	    }

	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

}
