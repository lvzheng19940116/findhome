package findhome.rabbit;

import com.fasterxml.jackson.databind.ObjectMapper;
import findhome.service.search.HouseIndexMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 以动手实践为荣,以只看不练为耻.
 * 以打印日志为荣,以出错不报为耻.
 * 以局部变量为荣,以全局变量为耻.
 * 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻.
 * 以多态应用为荣,以分支判断为耻.
 * 以定义常量为荣,以魔法数字为耻.
 * 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng
 * 创建时间：lvzheng  2018/8/15
 */

@Component
public class Reciver {

//    @RabbitHandler
//    @RabbitListener(queues = "fly")
//    public void process(String aaa) {
//        System.out.print("reciver:" + aaa);
//    }

//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @RabbitHandler
//    @RabbitListener(queues = "fly")
//    private void handleMessage(String content) {
//        try {
//            HouseIndexMessage message = objectMapper.readValue(content, HouseIndexMessage.class);
//
//            switch (message.getOperation()) {
//                case HouseIndexMessage.INDEX:
//                    this.createOrUpdateIndex(message);
//                    break;
//                case HouseIndexMessage.REMOVE:
//                    this.removeIndex(message);
//                    break;
//                default:
//                    logger.warn("Not support message content " + content);
//                    break;
//            }
//        } catch (IOException e) {
//            logger.error("Cannot parse json for " + content, e);
//        }
//    }
}


