package br.com.oobj.easybill.validator;

public class ErrorRequisition {

    private String field;
    private String messsage;

    public ErrorRequisition(String field, String messsage) {
        this.field = field;
        this.messsage = messsage;
    }

    public String getField() {
        return field;
    }

    public String getMesssage() {
        return messsage;
    }
}
