public class CommonResource {
    Mine mine;
    Castle castle;

    public CommonResource(Mine mine, Castle castle) {
        this.mine = mine;
        this.castle = castle;
    }

    synchronized public void addingGoldToCastel(int x) {
        this.castle.setAmountOfGold(x + this.castle.getAmountOfGold());
    }

    synchronized public int minening(int x) {
        int gold = this.mine.getAmountOfGold();
        if (gold >= x) {
            this.mine.setAmountOfGold(gold - x);
            return (x);
        } else {
            this.mine.setAmountOfGold(0);
            return (gold);
        }

    }

}

class Mine {
    private int amountOfGold = 100;
    private boolean isEmpty = false;

    public int getGold() {
        this.amountOfGold -= 10;
        return (10);
    }

    public int getAmountOfGold() {
        return amountOfGold;
    }

    public void setAmountOfGold(int amountOfGold) {
        this.amountOfGold = amountOfGold;
    }

    public boolean isEmpty() {
        if (amountOfGold <= 0) {
            return true;
        }
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

}

class Castle {
    private int amountOfGold = 0;
    private boolean isEmpty = true;

    public int getAmountOfGold() {
        return amountOfGold;
    }

    public void setAmountOfGold(int amountOfGold) {
        this.amountOfGold = amountOfGold;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

}