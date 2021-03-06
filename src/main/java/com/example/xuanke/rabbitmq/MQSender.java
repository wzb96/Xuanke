package com.example.xuanke.rabbitmq;

import com.example.xuanke.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSender {

    private static final Logger logger = LoggerFactory.getLogger(MQSender.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(Object message){
        String msg = GsonUtil.toJson(message);
        logger.info("send msg:"+msg);
        amqpTemplate.convertAndSend(MQConfig.QUEUE,msg);
    }


}
