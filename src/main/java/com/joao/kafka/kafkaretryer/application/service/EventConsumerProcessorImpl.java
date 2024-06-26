package com.joao.kafka.kafkaretryer.application.service;

import org.springframework.stereotype.Service;

import com.joao.kafka.kafkaretryer.model.kafka.Event;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class EventConsumerProcessorImpl implements EventConsumerProcessor {

    @Override
    public void processEvent(Event receivedEvent) throws Exception {
        log.info("processing : {} ", receivedEvent);
        assyncProcessing(receivedEvent);
        throw new RuntimeException();
    }

    public Void assyncProcessing(Event receivedEvent) throws Exception {
        return null;
    }

}
