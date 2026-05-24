package beginner.time10699;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Instant: UTC"); // Instant.now()は常にUTC
        Instant UTC = Instant.now();
        Duration nineHour = Duration.ofHours(9);
        Instant plusNine = UTC.plus(nineHour);
        String today = plusNine.toString().substring(0, 10);
        System.out.println(today);
        // ZoneIdで地域指定、ZoneDateTimeを作る
        System.out.println("Instant: ZoneId");
        Instant nowUtc = Instant.now();
        ZonedDateTime tokyo = nowUtc.atZone(ZoneId.of("Asia/Tokyo"));
        String today2 = tokyo.toLocalDate().toString();
        System.out.println(today2);
    }
}
