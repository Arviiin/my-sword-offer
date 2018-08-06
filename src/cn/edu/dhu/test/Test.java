package cn.edu.dhu.test;

class Main{
    public static synchronized void main(String[] args) throws InterruptedException{
        Thread t = new Thread(){
            public void run(){
                Right();
            }
        };
        t.start();
        System.out.print("“Left”");
    }
    static synchronized void Right(){
        System.out.print("“Right”");
    }
}