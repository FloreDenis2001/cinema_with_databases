package repository;

import exceptii.StatusException;

import java.time.LocalDateTime;

public class Programare {
    private LocalDateTime startTime;
    private LocalDateTime finishTime;

    public Programare(LocalDateTime startTime,LocalDateTime finishTime){
        this.startTime=startTime;
        this.finishTime=finishTime;
    }

    public Programare(String startTime,String finishTime) throws StatusException{
        int yy=Integer.parseInt(startTime.split(",")[0]);
        int mm=Integer.parseInt(startTime.split(",")[1]);
        int dd=Integer.parseInt(startTime.split(",")[2]);
        int hh=Integer.parseInt(startTime.split(",")[3]);
        int min=Integer.parseInt(startTime.split(",")[4]);
        int sec=Integer.parseInt(startTime.split(",")[5]);


        int yys=Integer.parseInt(finishTime.split(",")[0]);
        int mms=Integer.parseInt(finishTime.split(",")[1]);
        int dds=Integer.parseInt(finishTime.split(",")[2]);
        int hhs=Integer.parseInt(finishTime.split(",")[3]);
        int mins=Integer.parseInt(finishTime.split(",")[4]);
        int secunde=Integer.parseInt(finishTime.split(",")[5]);

        if(LocalDateTime.of(yy,mm,dd,hh,min,sec).compareTo(LocalDateTime.of(yys,mms,dds,hhs,mins,secunde))<0){
            this.startTime=LocalDateTime.of(yy,mm,dd,hh,min,sec);
            this.finishTime=LocalDateTime.of(yys,mms,dds,hhs,mins,secunde);
        }else {
            throw new StatusException("Datele nu sunt introduse corect ! ");
        }
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }
}
