package com.example.signaldetect;

public class ChangeBean {
    private String changetime;
    private String SIM;
    private String changetype;

    public ChangeBean(String changetime, String SIM, String changetype) {
        this.changetime = changetime;
        this.SIM = SIM;
        this.changetype = changetype;
    }

    public void setChangetime(String changetime) {
        this.changetime = changetime;
    }

    public void setSIM(String SIM) {
        this.SIM = SIM;
    }

    public void setChangetype(String changetype) {
        this.changetype = changetype;
    }

    public String getChangetime() {
        return changetime;
    }

    public String getSIM() {
        return SIM;
    }

    public String getChangetype() {
        return changetype;
    }
}
