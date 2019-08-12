package com.epam.rd.spring2019.pet.web.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorDto implements Serializable {
    String msgError;
    String classException;
    List<String> listError = new ArrayList<>();

    public ErrorDto(String msgError, String classException) {
        this.msgError = msgError;
        this.classException = classException;
    }

    public String getMsgError() {
        return msgError;
    }

    public String getClassException() {
        return classException;
    }

    public List<String> getListError() {
        return listError;
    }

    public void setListError(List<String> listError) {
        this.listError = listError;
    }
}
