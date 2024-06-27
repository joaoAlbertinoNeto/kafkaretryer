package com.joao.kafka.kafkaretryer.application.ports.in;

import com.joao.kafka.kafkaretryer.model.kafka.Event;

public interface EventConsumerPortIn{
    public void inputEvent (Event receivedEvent) throws Exception;
}
