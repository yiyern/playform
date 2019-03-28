package com.ipenta;

public class PrimeCount implements Runnable {

    private int currentNum = 2;  //从2开始找
    private int totalPrimeCount = 0; //当前已经找到的

    //取一个数，不能重复，最大到100000
    private int incrCurrentNum() {
        synchronized (this) {     //如果不用锁，必然会出错。
            if(currentNum > 100000) {
                return -1;
            } else {
                int result = currentNum;
                currentNum++;
                return result;
            }
        }
    }

    //把某个线程找到的素数个数加上
    private void accPrimeCount(int count) {
        synchronized (this) {
            totalPrimeCount += count;
        }
    }

    @Override
    //一直取数并判断是否为素数，取不到了就把找到的个数累加
    public void run() {
        int primeCount = 0;
        int num;
        while((num=incrCurrentNum()) != -1) {
            if(isPrime(num)) {
                primeCount++;
            }
        }
        accPrimeCount(primeCount);
    }
    private boolean isPrime(int num) {
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args){
        PrimeCount pc = new PrimeCount();
        for(int i = 0; i < 10; i++) {
            new Thread(pc).start();
        }
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(pc.getTotalPrimeCount());
    }

    public int getTotalPrimeCount() {
        return totalPrimeCount;
    }

}