package hackerRank;

/**
 *  1-12 AM|PM
 *  if( PM ) :
 *
 */
public class TimeConversion {

    public static void main(String[] args) {
        TimeConversion conversion = new TimeConversion();
        System.out.println(conversion.timeConversion("06:40:03AM")); // Output: 19:05:45

    }

    public static String timeConversion(String s) {
        // Write your code here
        String result = "";
        String[] time = s.split(":");
        String isAm = time[2].substring(2);
        System.out.println(isAm);
        if(isAm.equals("PM")){
            int hour = Integer.parseInt(time[0]);
            if( hour!=12 ){
                hour += 12;
            }
            result = (hour < 10 ? "0"+hour : hour) + ":" + time[1] + ":" + time[2].substring(0, 2);

        }
        else{
            int hour = Integer.parseInt(time[0]);
            if( hour==12 ){
                hour = 0;
            }
            result = (hour < 10 ? "0"+hour : hour) + ":" + time[1] + ":" + time[2].substring(0, 2);
        }




        return result;



    }

}
