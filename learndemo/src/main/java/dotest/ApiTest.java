package dotest;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


public class ApiTest {


    public static void main(String[] args) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
percentInstance.setMinimumFractionDigits(2);
        System.out.println(percentInstance.format(0.12545));


        System.out.println(Math.round(0.12387634853*10000)/10000D);


        String str = "we are happy";
        System.out.println(str.replaceAll(" ","%20"));
    }



}
