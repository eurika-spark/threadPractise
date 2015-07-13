package com.eurika.thread.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class PricesInfo122214 {

      private double price1 ;
      private double price2 ;
      private ReadWriteLock lock = null;
      
      PricesInfo122214() {
             this. price1 = 1.0;
             this. price2 = 2.0;
             this. lock = new ReentrantReadWriteLock();  // The Only Hierarchy class of ReadWriteLock
      }
      
      public double getPrice1() {
             this. lock.readLock().lock();
             double value = this. price1;
             this. lock.readLock().unlock();
             return value;
      }
      
      public double getPrice2() {
             this. lock.readLock().lock();
             double value = this. price2;
             this. lock.readLock().unlock();
             return value;
      }
      
      public void setPrice( double value1, double value2) {
             this. lock.writeLock().lock();
             this. price1 = value1;
             this. price2 = value2;
             this. lock.writeLock().unlock();
      }
      
}

public class Reader122214 implements Runnable {

      private PricesInfo122214 pricesInfo = null;
      
      public Reader122214(PricesInfo122214 pricesInfo) {
             this. pricesInfo = pricesInfo;
      }
      
      @Override
      public void run() {

             for ( int i = 0; i < 10; i++) {
                  System. out.println(Thread. currentThread().getName() + " : Price 1:" + pricesInfo .getPrice1());
                  System. out.println(Thread. currentThread().getName() + " : Price 2:" + pricesInfo .getPrice2());
            }
            
      }

}

