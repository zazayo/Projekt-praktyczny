package database;

import http.SlipDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Slip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long slipId;

    private long id;
    private String advice;

    public Slip(){}
    public Slip(SlipDto slipDTo){
        this.id = slipDTo.getId();
        this.advice = slipDTo.getAdvice();
    }

    public Slip(long id, String advice) {
        this.id = id;
        this.advice = advice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    @Override
    public String toString() {
        return "Slip{" +
                "slipId=" + slipId +
                ", id=" + id +
                ", advice='" + advice + '\'' +
                '}';
    }
}
