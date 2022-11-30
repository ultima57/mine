public class Workers implements Runnable {
    boolean withGold = false;
    CommonResource commonResource;
    int myGold = 0;

    public Workers(CommonResource commonResource) {
        this.withGold = false;
        this.commonResource = commonResource;
        this.myGold = 0;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " awake");
        while (commonResource.mine.getAmountOfGold() > 0) {
            synchronized (commonResource.mine) {

                commonResource.mine.setEmpty(false);

                myGold = commonResource.minening((int) (Math.random() * 10 + 1));
                System.out.println(Thread.currentThread().getName() + " майнит");

                try {
                    Thread.currentThread().sleep((int) (Math.random() * 5000) + 500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " намайнил");
                System.out.println("Золота в шахте: " + commonResource.mine.getAmountOfGold());
                commonResource.mine.setEmpty(true);
                withGold = true;

            }
            synchronized (commonResource.castle) {

                commonResource.castle.setEmpty(false);
                commonResource.addingGoldToCastel(myGold);

                System.out.println(Thread.currentThread().getName() + " кидает золото");

                try {
                    Thread.currentThread().sleep((int) (Math.random() * 5000) + 500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " накидал золото");
                System.out.println("Золота в замке: " + commonResource.castle.getAmountOfGold());

                commonResource.castle.setEmpty(true);
                withGold = false;

            }
            // TODO Auto-generated method stub
        }

    }
}
