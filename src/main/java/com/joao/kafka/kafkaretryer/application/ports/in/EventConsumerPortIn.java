package com.joao.kafka.kafkaretryer.application.ports.in;

public interface EventConsumerPortIn{
    public void receiveEvent (String receivedEvent) throws Exception;
}
