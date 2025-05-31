package stellive.yunifanpage.home.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HomeService {

    public static String getYuniDebut() {
        LocalDate debutDate = LocalDate.of(2023, 1, 8);
        LocalDate today = LocalDate.now();
        long days = ChronoUnit.DAYS.between(debutDate, today);
        return String.valueOf(days);
    }
}
