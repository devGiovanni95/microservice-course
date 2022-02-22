package com.giovanni.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/*Nao necessitamos mais intanciar manulmente pois o eureka ira fazer isso automaticamente*/
//@RibbonClient(name = "hr-worker")//local que o outro microservico esta


//quando imprementarmos a chamada, ficara muito mais limpa do que usando o restTemplete alem de estar ligado com todas as ferramentas do SprindCloud

//responsavel por fazer o balanceamento de carga das requisiçoes
@EnableEurekaClient
//Habilitando o Hystrix para permitir a tolerancia de falhas
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
