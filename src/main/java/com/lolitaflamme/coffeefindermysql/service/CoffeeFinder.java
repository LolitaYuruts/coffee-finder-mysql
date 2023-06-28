package com.lolitaflamme.coffeefindermysql.service;

import com.lolitaflamme.coffeefindermysql.domain.Coffee;
import com.lolitaflamme.coffeefindermysql.repository.CoffeeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Service
@RequiredArgsConstructor
public class CoffeeFinder {

    @NonNull
    private final CoffeeRepository coffeeRepository;

    private final WebClient client = WebClient.create("http://localhost:8085/coffees");

    @Scheduled(fixedRate = 1000)
    private void findCoffees() {
        coffeeRepository.deleteAll();

        client.get()
                .retrieve()
                .bodyToFlux(Coffee.class)
                .toStream()
                .forEach(coffeeRepository::save);

        coffeeRepository.findAll().forEach(System.out::println);
    }
}
