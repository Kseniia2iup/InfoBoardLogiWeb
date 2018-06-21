package ru.tsystems.javaschool.bean;

import ru.tsystems.javaschool.model.InfoDto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean(name = "infoBoardDataBean")
@SessionScoped
public class InfoBoardDataBean implements Serializable {

    @Inject
    private UpdateDataBean updateDataBean;

    public InfoDto getInformation(){
        return updateDataBean.getInformation();
    }
}
