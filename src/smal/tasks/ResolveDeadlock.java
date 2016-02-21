package smal.tasks;

public class ResolveDeadlock {

    public static void main(String[] args) {
        ResolveDeadlock test = new ResolveDeadlock();

        final A a = test.new A();
        final B b = test.new B();

        Runnable block1 = new Runnable(){
            public void run(){
                synchronized(a){
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }

                    synchronized(b){
                        System.out.println("In block one");
                    }
                }
            }
        };

        Runnable block2 = new Runnable(){
            public void run(){
                // для предотвращения deadlock необходимо сменить порядок синхронизации объектов
                synchronized(b){ //здесь необходимо синхронизировать a
                    synchronized(a){ //а здесь b
                        System.out.println("In block two");
                    }
                }
            }
        };

        new Thread(block1).start();
        new Thread(block2).start();
    }

    public class A{
        private int i = 5;
    }

    public class B{
        private int i = 10;
    }
}
