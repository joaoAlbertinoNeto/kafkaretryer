package com.joao.kafka.kafkaretryer.application.service;

import com.joao.kafka.kafkaretryer.model.kafka.Event;

public interface EventConsumerProcessor {
    public void processEvent(Event receivedEvent) throws Exception;
}
