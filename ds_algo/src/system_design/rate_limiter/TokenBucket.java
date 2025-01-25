package system_design.rate_limiter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucket {

    int maxBucket;
    AtomicInteger counter = new AtomicInteger();
    int refillToken = 0;


    public TokenBucket(int maxBucket,int refillToken) {
        this.maxBucket = maxBucket;
        this.refillToken = refillToken;
        counter = new AtomicInteger(maxBucket);
    }


    public static void main(String[] args) {

    }

    public boolean tryLock(){
        synchronized (counter){
            if(counter.get() > 0){
                return true;
            }
            return false;

        }
    }

    public void reFill(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(()->{
            synchronized (counter){
                int currentToken = counter.get();
                if(currentToken < maxBucket){
                    counter.set(Math.max(maxBucket,currentToken+ refillToken));
                }
            }

        },0,1, TimeUnit.SECONDS);

    }

}
