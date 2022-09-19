package utile;

import java.time.LocalDate;

public class Utile {
    public  static  String convertLocalDateTimeToSqlTimeStamp(LocalDate date){
        return String.format("%d-%d-%d %d:%d:%d",date.getYear(),date.getMonthValue(),date.getDayOfMonth(),00,00,00);
    }

    public  static  String convertLocalDateTimeToSql(LocalDate date){
        return String.format("%d-%d-%d %d:%d:%d",date.getYear(),date.getMonthValue(),date.getDayOfMonth(),23,00,00);
    }
}
