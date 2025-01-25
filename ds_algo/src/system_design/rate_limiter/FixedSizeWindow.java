package system_design.rate_limiter;

public class FixedSizeWindow {

    public static void main(String[] args) throws InterruptedException {
        FixedSizeWindow fixedSizeWindow = new FixedSizeWindow();
        FixedSizeRateLimiter fixedSizeRateLimiter = new FixedSizeRateLimiter(5,1000l);

        for (int i=0;i<100;i++){
            fixedSizeRateLimiter.requestAvailable(i);
            Thread.sleep(100l);

        }
    }



    static class FixedSizeRateLimiter{

        int maxRequest;
        long maxIntervalTime;  // in milliseconds
        long startTime;
        int requestCount = 1;

        public  FixedSizeRateLimiter(int maxRequest, long maxIntervalTime) {
            this.maxRequest = maxRequest;
            this.maxIntervalTime = maxIntervalTime;
            this.startTime = System.currentTimeMillis();
        }

        /**
         *    _ _ _ _ | _ _ _ _
         * @return
         */
        public synchronized boolean requestAvailable(int i){
            long currentTime = System.currentTimeMillis();
            refresh(currentTime);
            if( requestCount <= maxRequest ){
                requestCount++;
                System.out.println(""+i + "available for Request");
                return true;
            }
            else{
                System.out.println(""+i + "NOT available for Request");

                return false;
            }
        }

        private void refresh(long currentTime) {
            long current = currentTime;
            if(currentTime - startTime >=  maxIntervalTime){
                requestCount = 1;
                startTime = System.currentTimeMillis();
            }

        }


    }
}
