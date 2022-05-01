import java.util.Calendar;

public class Util {

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

    public static boolean timeTrigger(int hour, int minute, int second) {
        sleep(1000);
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int currentMinute = Calendar.getInstance().get(Calendar.MINUTE);
        int currentSecond = Calendar.getInstance().get(Calendar.SECOND);
        System.out.println("时间触发 当前时间 " + currentHour + ":" + currentMinute + ":" + currentSecond + " 目标时间 " + hour + ":" + minute + ":" + second);
        return currentHour == hour && currentMinute == minute && currentSecond >= second;
    }

    /**
     * get currentTime
     */
    public static String getCurrentTime(){
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int currentMinute = Calendar.getInstance().get(Calendar.MINUTE);
        int currentSecond = Calendar.getInstance().get(Calendar.SECOND);
        return currentHour + ":" + currentMinute + ":" + currentSecond + ": ";
    }

}
