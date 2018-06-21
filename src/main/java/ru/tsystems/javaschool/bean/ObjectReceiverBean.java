package ru.tsystems.javaschool.bean;

import ru.tsystems.javaschool.model.InfoDto;

import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@Singleton
public class ObjectReceiverBean {

    private Client client = ClientBuilder.newClient();

    public InfoDto getInfoForUpdate(){
        System.out.println("QUERY");
        String uri = "http://127.0.0.1:8181/trucking/emit";
        WebTarget target = client.target(uri);
        return target.request()
                .get(InfoDto.class);
    }
}
