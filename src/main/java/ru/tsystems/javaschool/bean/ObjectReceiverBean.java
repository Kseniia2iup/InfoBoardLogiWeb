package ru.tsystems.javaschool.bean;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.javaschool.model.InfoDto;

import javax.ejb.Singleton;
import java.io.Serializable;


@Singleton
public class ObjectReceiverBean implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectReceiverBean.class);

    ResteasyClient client = new ResteasyClientBuilder().build();

    public InfoDto getInfoForUpdate(){
        ResteasyWebTarget target = client.target("http://127.0.0.1:8181/trucking/emit");
        LOGGER.info("From ObjectReceiverBean method getInfoForUpdate receiving request " +
                "from http://127.0.0.1:8181/trucking/emit");
        return target.request()
                .get(InfoDto.class);
    }
}
