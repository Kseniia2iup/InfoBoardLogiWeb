package ru.tsystems.javaschool.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.javaschool.model.InfoDto;

import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import javax.faces.bean.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import java.io.Serializable;

@Startup
@ApplicationScoped
public class UpdateDataBean implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateDataBean.class);

    @Inject
    @Push(channel = "push")
    PushContext pusher;

    @Inject
    private ObjectReceiverBean objectReceiverBean;

    private InfoDto information;

    public InfoDto getInformation() {
        LOGGER.info("From UpdateDataBean getting information");
        return information;
    }

    public void setInformation(InfoDto information) {
        this.information = information;
    }

    public void observeUpdateActivity(@Observes String message) {
        information = objectReceiverBean.getInfoForUpdate();
        LOGGER.info("From UpdateDataBean method observeUpdateActivity got new information " +
                "from ObjectReceiverBean: \n{}", information);
        pusher.send("update");
    }

}
