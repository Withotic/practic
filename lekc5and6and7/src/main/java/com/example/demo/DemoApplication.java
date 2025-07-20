package com.example.demo;

//import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;

//import com.example.demo.service.RatingService;
//import com.example.demo.service.RestaurantService;
//import com.example.demo.service.VisitorService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		/*ConfigurableApplicationContext context =*/ SpringApplication.run(DemoApplication.class, args);
/*
		VisitorService visitorService = context.getBean(VisitorService.class);
        RestaurantService restaurantService = context.getBean(RestaurantService.class);
        RatingService ratingService = context.getBean(RatingService.class);

        visitorService.save("Иван", (byte) 25, false);
        visitorService.save((byte) 30, true);

        restaurantService.save(new Restaurant( 0,"peperoni porfavore", "Итальянская кухня", ResType.Italian, 25.0, BigDecimal.ZERO));
        restaurantService.save(new Restaurant(1,"терияки", ResType.Chinese, 18.5, BigDecimal.ZERO));

        ratingService.save(new Rating(0, 0, 5, "Отлично!"));
        ratingService.save(new Rating(1, 1, 4));
		System.out.println("Рестораны:");
        for (Restaurant r : restaurantService.findAll()) {
            System.out.println(r);
        }
        ratingService.save(new Rating(1, 1, 3, "Нормально."));

        System.out.println("Рестораны после пересчета:");
        for (Restaurant r : restaurantService.findAll()) {
            System.out.println(r);
        }
		context.close();*/
	}

}
