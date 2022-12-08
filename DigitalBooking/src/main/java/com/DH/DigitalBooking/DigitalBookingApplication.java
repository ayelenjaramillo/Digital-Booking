package com.DH.DigitalBooking;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Digital Booking API"))
public class DigitalBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBookingApplication.class, args);
	}

}
