package cn.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> KafkaTemplate;

    @RequestMapping(value = "/sendMsgToKafka")
    //kafka用key值确定value存放在哪个分区
    public String sendMsgToKafka() {
        for (int i = 0; i < 10; i++) {
            KafkaTemplate.send("dmservice", "dm", "hello,Kafka!--->" + i);
        }
        return "发送消息到Kafka完毕";
    }
}
