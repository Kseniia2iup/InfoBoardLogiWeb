package ru.tsystems.javaschool.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.javaschool.model.InfoDto;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class InfoBoardDataBean implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(InfoBoardDataBean.class);

    @Inject
    private UpdateDataBean updateDataBean;

    public InfoDto getInformation(){
        return updateDataBean.getInformation();
    }
}
