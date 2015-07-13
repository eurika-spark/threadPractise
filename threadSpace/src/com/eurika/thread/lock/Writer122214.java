package com.eurika.thread.lock;

import java.math.BigDecimal;

public class Writer122214 implements Runnable {

      private PricesInfo122214 pricesInfo = null;
      
      public Writer122214(PricesInfo122214 pricesInfo) {
             this. pricesInfo = pricesInfo;
      }
      
      @Override
      public void run() {

             double price1 = 0, price2 =0;
            BigDecimal bg = null;
            
             for ( int i = 0; i < 3; i++) {
                  System. out.println(Thread. currentThread().getName() + " Writer: Attempt to modify the prices." );
                  
                  bg = new BigDecimal(Math. random() * 10);
                  price1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                  
                  bg = new BigDecimal(Math. random() * 8);
                  price2 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                  
                   pricesInfo.setPrice(price1, price2);
                  
                  System. out.println( "Writer: Prices have been modified. " + price1 + " & " + price2);
                  
                   try {
                        Thread. sleep(2);
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
            }
      }
      
      public static void main(String[] args) {
            
            PricesInfo122214 pricesInfo = new PricesInfo122214();
            
            Reader122214[] readers = new Reader122214[5];
            
            Thread[] threadReader = new Thread[5];
             for ( int i = 0; i < 5; i++) {
                  readers[i] = new Reader122214(pricesInfo);
                  threadReader[i] = new Thread(readers[i]);
            }
            
            Writer122214 writer = new Writer122214(pricesInfo);
            Thread threadWriter = new Thread(writer);
            
            threadWriter.start();
             for ( int i = 0; i < 5; i++) {
                  threadReader[i].start();
            }
            
             /*
                  Thread-5 Writer: Attempt to modify the prices.
                  Thread-0 : Price 1:1.0
                  Thread-0 : Price 2:2.0
                  Thread-0 : Price 1:1.0
                  Thread-0 : Price 2:2.0
                  Thread-0 : Price 1:1.0
                  Thread-0 : Price 2:2.0
                  Thread-0 : Price 1:1.0
                  Thread-0 : Price 2:2.0
                  Thread-0 : Price 1:1.0
                  Thread-0 : Price 2:2.0
                  Thread-0 : Price 1:1.0
                  Thread-0 : Price 2:2.0
                  Thread-0 : Price 1:1.0
                  Thread-0 : Price 2:2.0
                  Thread-0 : Price 1:1.0
                  Thread-0 : Price 2:2.0
                  Thread-0 : Price 1:1.0
                  Thread-0 : Price 2:2.0
                  Thread-0 : Price 1:1.0
                  Thread-0 : Price 2:2.0
                  Thread-2 : Price 1:1.0
                  Thread-2 : Price 2:2.0
                  Thread-2 : Price 1:1.0
                  Thread-2 : Price 2:2.0
                  Thread-2 : Price 1:1.0
                  Thread-2 : Price 2:2.0
                  Thread-2 : Price 1:1.0
                  Thread-2 : Price 2:2.0
                  Thread-2 : Price 1:1.0
                  Thread-2 : Price 2:2.0
                  Thread-2 : Price 1:1.0
                  Thread-2 : Price 2:2.0
                  Thread-2 : Price 1:1.0
                  Thread-2 : Price 2:2.0
                  Thread-2 : Price 1:1.0
                  Writer: Prices have been modified. 9.71 & 2.56
                  Thread-3 : Price 1:9.71
                  Thread-2 : Price 2:2.56
                  Thread-1 : Price 1:9.71
                  Thread-4 : Price 1:9.71
                  Thread-1 : Price 2:2.56
                  Thread-2 : Price 1:9.71
                  Thread-3 : Price 2:2.56
                  Thread-2 : Price 2:2.56
                  Thread-1 : Price 1:9.71
                  Thread-4 : Price 2:2.56
                  Thread-1 : Price 2:2.56
                  Thread-2 : Price 1:9.71
                  Thread-3 : Price 1:9.71
                  Thread-2 : Price 2:2.56
                  Thread-1 : Price 1:9.71
                  Thread-1 : Price 2:2.56
                  Thread-1 : Price 1:9.71
                  Thread-4 : Price 1:9.71
                  Thread-1 : Price 2:2.56
                  Thread-1 : Price 1:9.71
                  Thread-1 : Price 2:2.56
                  Thread-1 : Price 1:9.71
                  Thread-1 : Price 2:2.56
                  Thread-1 : Price 1:9.71
                  Thread-1 : Price 2:2.56
                  Thread-1 : Price 1:9.71
                  Thread-1 : Price 2:2.56
                  Thread-1 : Price 1:9.71
                  Thread-1 : Price 2:2.56
                  Thread-1 : Price 1:9.71
                  Thread-1 : Price 2:2.56
                  Thread-3 : Price 2:2.56
                  Thread-3 : Price 1:9.71
                  Thread-3 : Price 2:2.56
                  Thread-3 : Price 1:9.71
                  Thread-3 : Price 2:2.56
                  Thread-3 : Price 1:9.71
                  Thread-3 : Price 2:2.56
                  Thread-3 : Price 1:9.71
                  Thread-3 : Price 2:2.56
                  Thread-3 : Price 1:9.71
                  Thread-3 : Price 2:2.56
                  Thread-3 : Price 1:9.71
                  Thread-3 : Price 2:2.56
                  Thread-3 : Price 1:9.71
                  Thread-3 : Price 2:2.56
                  Thread-3 : Price 1:9.71
                  Thread-3 : Price 2:2.56
                  Thread-5 Writer: Attempt to modify the prices.
                  Writer: Prices have been modified. 3.0 & 7.86
                  Thread-4 : Price 2:2.56
                  Thread-4 : Price 1:3.0
                  Thread-4 : Price 2:7.86
                  Thread-4 : Price 1:3.0
                  Thread-4 : Price 2:7.86
                  Thread-4 : Price 1:3.0
                  Thread-4 : Price 2:7.86
                  Thread-4 : Price 1:3.0
                  Thread-4 : Price 2:7.86
                  Thread-4 : Price 1:3.0
                  Thread-4 : Price 2:7.86
                  Thread-4 : Price 1:3.0
                  Thread-4 : Price 2:7.86
                  Thread-4 : Price 1:3.0
                  Thread-4 : Price 2:7.86
                  Thread-4 : Price 1:3.0
                  Thread-4 : Price 2:7.86
                  Thread-5 Writer: Attempt to modify the prices.
                  Writer: Prices have been modified. 2.02 & 0.72
            */
      }

}