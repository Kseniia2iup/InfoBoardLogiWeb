package ru.tsystems.javaschool.bean;

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

    @Inject
    @Push(channel = "push")
    PushContext pushContext;

    @Inject
    ObjectReceiverBean objectReceiverBean;

    private InfoDto information;

    public InfoDto getInformation() {
        return information;
    }

    public void setInformation(InfoDto information) {
        this.information = information;
    }

    public void observeUpdateActivity(@Observes String message) {
        information = objectReceiverBean.getInfoForUpdate();
        System.out.println("INFORMATION UPDATeDATaBean: " + information);
        pushContext.send("update");
    }

}
