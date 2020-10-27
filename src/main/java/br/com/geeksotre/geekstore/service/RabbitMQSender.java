package br.com.geeksotre.geekstore.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.geeksotre.geekstore.model.Pedido;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;

	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;

	public void send(Pedido pedido) {
		rabbitTemplate.convertAndSend(exchange, routingkey, pedido);
		System.out.println("Send msg = " + pedido);
	}

}
