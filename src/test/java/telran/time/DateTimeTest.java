package telran.time;
import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.util.Locale;

import org.junit.jupiter.api.Test;

public class DateTimeTest {
    @Test
    void localDateTest() {
        LocalDate current = LocalDate.now();
        LocalDateTime cuDateTime = LocalDateTime.now();
        ZonedDateTime currZonedDateTime = ZonedDateTime.now();
        Instant currentInstant = Instant.now();
        LocalTime currentTime = LocalTime.now();
        System.out.printf("Current date is a %s in ISO format \n",current);
        System.out.printf("Current date and time is a %s in ISO format \n",cuDateTime);
        System.out.printf("Current zoned date is a %s in ISO format \n",currZonedDateTime);
        System.out.printf("Current instant isa %s in ISO format \n",currentInstant);
        System.out.printf("Current local time is a %s in ISO format \n",currentTime);
        System.out.printf("Current date is a %s in dd/mm/yyyy format \n",current.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.forLanguageTag("he"))));
    }
    @Test
    void nextFriday13Test() {
        LocalDate current = LocalDate.of(2024,8,11);
        LocalDate expected = LocalDate.of(2024,9,13);
        TemporalAdjuster adjuster = new NextFriday13();
        assertEquals(expected, current.with(adjuster));
        assertThrows(RuntimeException.class,() -> LocalTime.now().with(adjuster));
    }
}   
