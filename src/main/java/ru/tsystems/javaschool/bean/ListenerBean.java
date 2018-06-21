package ru.tsystems.javaschool.bean;

import com.rabbitmq.client.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import ru.tsystems.javaschool.model.InfoDto;
import ru.tsystems.javaschool.model.OrderDto;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Startup
@Singleton
public class ListenerBean implements Serializable {

    @Inject
    private UpdateDataBean updateDataBean;

    @Inject
    private BeanManager beanManager;

    private final static String QUEUE_NAME = "infoBoardQueue";
    private ConnectionFactory factory = new ConnectionFactory();
    private Connection connection;
    private Channel channel;

    @PostConstruct
    public void init() {
        try {
        updateDataBean.observeUpdateActivity("update");

        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {

                try {
                    String message = new String(body, "UTF-8");
                    System.out.println("STRING: " + message);
                    /*JSONParser parser = new JSONParser();

                    Object o = parser.parse(message);
                    JSONObject obj = (JSONObject)o;

                    System.out.println(" [x] Received '" + obj.toJSONString() + "'");


                    InfoDto infoDto = new InfoDto();
                    infoDto.setAllDrivers(Integer.parseInt(obj.get("allDrivers").toString()));
                    infoDto.setDriversOnOrder(Integer.parseInt(obj.get("driversOnOrder").toString()));
                    infoDto.setFreeDrivers(Integer.parseInt(obj.get("freeDrivers").toString()));
                    infoDto.setAllTrucks(Integer.parseInt(obj.get("allTrucks").toString()));
                    infoDto.setAvailableTrucks(Integer.parseInt(obj.get("availableTrucks").toString()));
                    infoDto.setBrokenTrucks(Integer.parseInt(obj.get("brokenTrucks").toString()));
                    infoDto.setTrucksOnOrder(Integer.parseInt(obj.get("trucksOnOrder").toString()));

                    List<OrderDto> orderDtoList = (List<OrderDto>) obj.get("lastTen");

                    infoDto.setLastTenOrders(orderDtoList);

                    System.out.println("Listener infoDto01 +++++++++++ : "+infoDto);
                    updateDataBean.setInformation(infoDto); */

                    beanManager.fireEvent(message);

                    //System.out.println("Listener infoDto: "+ infoDto);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @PreDestroy
    public void preDestroy() {
        try {
            System.out.println("Invoking method: preDestroy()");
            connection.close();
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
