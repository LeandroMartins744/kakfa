//package br.com.aura;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try(var dispatcher = new KafkaDispatcher<Order>()) {
            try (var dispatcherEmail = new KafkaDispatcher<String>()) {
                var userId = UUID.randomUUID().toString();
                var order = new Order(userId, UUID.randomUUID().toString(), new BigDecimal(Math.random() * 5000 + 1));
                dispatcher.send("ECOMMERCE_NEW_ORDER", userId, order);

                var email = "Texto do email sendo enviado";
                dispatcherEmail.send("ECOMMERCE_EMAIL", userId, email);
            }
        }
    }
}
