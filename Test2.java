package innnerclass;

public class Test2 {
    public static void main(String[] args) {
        class People{
            private int heartbeat = 150;
            class Heart {
                private int heartbeat = 110;

                public void show() {
                    int heartbeat = 78;

                    System.out.println( heartbeat ); // 78
                      System.out.println(this.heartbeat); // 110
                    System.out.println(People.this.heartbeat); // 150

            }}}}}