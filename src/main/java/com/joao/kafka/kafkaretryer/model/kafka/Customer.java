package com.joao.kafka.kafkaretryer.model.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private String name;
    private String documentNumber;
}