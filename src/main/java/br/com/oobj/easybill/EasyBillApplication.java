package br.com.oobj.easybill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EasyBillApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBillApplication.class, args);
	}

}
