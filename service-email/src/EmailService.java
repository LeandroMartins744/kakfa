import org.apache.kafka.clients.consumer.ConsumerRecord;

public class EmailService {
    public static void main(String[] args) {
        var emailService = new EmailService();
        var service = new KafkaService(
                EmailService.class.getSimpleName(),
                "ECOMMERCE_EMAIL",
                emailService::parse);
        service.run();
    }
    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("----------------------EMAIL----------------------");
        System.out.println("Processando new order, Envio Email");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // ignoring
            e.printStackTrace();
        }
        System.out.println("Ordem processada....");
    }
}
