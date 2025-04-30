package joyceUsingLoops;

import java.time.LocalDateTime;

public class Clock {
    public static void main(String[] args) {
        LocalDateTime now;
        int nowSec;
        int prevSec = 0;
        for (; ;){
            now = LocalDateTime.now();
            nowSec = now.getSecond();
            if (nowSec != prevSec){
                System.out.println(now.getHour() + " :" + now.getMinute() + " : " + nowSec);
                prevSec = nowSec;
            }
        }
    }
}
// Pseudocode:
//1. Initialize Variables:
//    - now: a variable to store the current date and time.
//    - nowSec: a variable to store the current second.
//    - prevSec: a variable to store the previous second, initialized to 0.
//2. Infinite Loop:
//    - Loop indefinitely until the program is manually stopped.
//3. Get Current Time:
//    - Update now with the current date and time.
//    - Extract the current second from now and store it in nowSec.
//4. Check for Second Change:
//    - If nowSec is different from prevSec, then:
//        - Print the current time in the format "hour : minute : second".
//        - Update prevSec with the current nowSec value.
//5. Repeat:
//    - Go back to step 3 and continue the loop.


