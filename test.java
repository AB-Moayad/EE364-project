import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class test {

    public static void main(String[] args) {
        // Example usage
        LocalTime currentTime = LocalTime.now();
        int estimatedTime = calculatePrayerTime(currentTime);
        System.out.println("Estimated time to finish prayers: " + estimatedTime + " minutes");
    }

    public static int calculatePrayerTime(LocalTime currentTime) {
        int remainingTime = 0;

        // Calculate remaining time for each prayer from the current time
        remainingTime += calculateRemainingTime(currentTime, getPrayerTime("Fajir"));
        remainingTime += calculateRemainingTime(currentTime, getPrayerTime("Duhr"));
        remainingTime += calculateRemainingTime(currentTime, getPrayerTime("Asur"));
        remainingTime += calculateRemainingTime(currentTime, getPrayerTime("Magreeb"));
        remainingTime += calculateRemainingTime(currentTime, getPrayerTime("Ashia"));

        return remainingTime;
    }

    public static LocalTime getPrayerTime(String prayerName) {
        // Add your prayer time logic here
        // You can use an API or retrieve the prayer times from a database or any other source
        // For demonstration purposes, let's assume fixed prayer times
        switch (prayerName) {
            case "Fajir":
                return LocalTime.of(5, 0); // Example: Fajir prayer at 5:00 AM
            case "Duhr":
                return LocalTime.of(12, 0); // Example: Duhr prayer at 12:00 PM
            case "Asur":
                return LocalTime.of(15, 0); // Example: Asur prayer at 3:00 PM
            case "Magreeb":
                return LocalTime.of(18, 0); // Example: Magreeb prayer at 6:00 PM
            case "Ashia":
                return LocalTime.of(20, 0); // Example: Ashia prayer at 8:00 PM
            default:
                return LocalTime.MAX;
        }
    }

    public static int calculateRemainingTime(LocalTime currentTime, LocalTime prayerTime) {
        if (currentTime.isBefore(prayerTime)) {
            return (int) ChronoUnit.MINUTES.between(currentTime, prayerTime);
        } else {
            return 0;
        }
    }
}
