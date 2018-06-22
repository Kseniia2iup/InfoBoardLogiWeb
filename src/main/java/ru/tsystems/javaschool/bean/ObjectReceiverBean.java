package ru.tsystems.javaschool.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.javaschool.model.InfoDto;

import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@Singleton
public class ObjectReceiverBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectReceiverBean.class);

    private Client client = ClientBuilder.newClient();

    public InfoDto getInfoForUpdate(){
        String uri = "http://127.0.0.1:8181/trucking/emit";
        WebTarget target = client.target(uri);
        LOGGER.info("From ObjectReceiverBean method getInfoForUpdate receiving request " +
                "from http://127.0.0.1:8181/trucking/emit");
        return target.request()
                .get(InfoDto.class);
    }
}
