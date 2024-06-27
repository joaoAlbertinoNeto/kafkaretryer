package com.joao.kafka.kafkaretryer.infrastructure.kafka.in;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joao.kafka.kafkaretryer.application.ports.in.EventConsumerPortIn;
import com.joao.kafka.kafkaretryer.application.service.EventConsumerProcessor;
import com.joao.kafka.kafkaretryer.model.kafka.Event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class KafkaConsumer implements EventConsumerPortIn{

    private final String TOPICO = "topico";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final EventConsumerProcessor eventConsumerProcessor;

    @KafkaListener(topics = TOPICO)
    @RetryableTopic(
        backoff = @Backoff(value = 2000L), 
        attempts = "3", 
        autoCreateTopics = "true",
        include = RuntimeException.class)
    public void receiveEvent(String receivedEvent) throws Exception {
        try {
            Event event = objectMapper.readValue(receivedEvent, Event.class);
            log.info("Received event : {}" ,event);
            this.inputEvent(event);
            
        } catch (Exception e) {
            log.error("Error : {} ", e.getLocalizedMessage());
            throw e;
        }
    }

    @Override
    public void inputEvent(Event receivedEvent) throws Exception {
        eventConsumerProcessor.processEvent(receivedEvent);
    }
}