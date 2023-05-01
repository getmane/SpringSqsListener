package com.getmane.springsqslistener.consumer;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SqsConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqsConsumer.class);

    @SqsListener(value = "${config.aws.sqs-queue-url}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    public void receiveMessage(String stringJson, Acknowledgment acknowledgment) {
        LOGGER.info("Received new message");
        // Parse json payload to process message
        acknowledgment.acknowledge();
    }
}