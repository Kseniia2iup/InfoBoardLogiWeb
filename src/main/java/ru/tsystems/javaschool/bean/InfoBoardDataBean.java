package ru.tsystems.javaschool.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.javaschool.model.InfoDto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean(name = "infoBoardDataBean")
@SessionScoped
public class InfoBoardDataBean implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(InfoBoardDataBean.class);

    @Inject
    private UpdateDataBean updateDataBean;

    public InfoDto getInformation(){
        LOGGER.info("From InfoBoardDataBean method getInformation: getting information");
        return updateDataBean.getInformation();
    }
}
