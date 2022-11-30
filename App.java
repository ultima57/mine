public class App {
    public static void main(String[] args) throws Exception {

        Mine mine = new Mine();
        Castle castle = new Castle();
        CommonResource commonResource = new CommonResource(mine, castle);
        Workers[] workers = new Workers[5];
        Thread[] threads = new Thread[5];

        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Workers(commonResource);
            threads[i] = new Thread(workers[i]);
        }
        for (int i = 0; i < workers.length; i++) {
            threads[i].start();
        }
        try {
            for (int i = 1; i < workers.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
