package Design_Pattern;

class VendingMachineMemento {
    private final int snacksCount;

    public VendingMachineMemento(int snacksCount) {
        this.snacksCount = snacksCount;
    }

    public int getSnacksCount() {
        return snacksCount;
    }
}

class VendingMachine {
    private int snacksCount;

    public VendingMachine(int snacksCount) {
        this.snacksCount = snacksCount;
    }

    public void addSnack() {
        snacksCount++;
    }

    public void dispenseSnack() {
        if (snacksCount > 0) {
            snacksCount--;
        } else {
            System.out.println("Out of snacks!");
        }
    }

    public VendingMachineMemento saveToMemento() {
        return new VendingMachineMemento(snacksCount);
    }

    public void restoreFromMemento(VendingMachineMemento memento) {
        snacksCount = memento.getSnacksCount();
    }

    public int getSnacksCount() {
        return snacksCount;
    }
}

class VendingMachineCareTaker {
    private VendingMachineMemento memento;

    public void saveMemento(VendingMachineMemento memento) {
        this.memento = memento;
    }

    public VendingMachineMemento getMemento() {
        return memento;
    }
}

public class Memento {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(5);
        System.out.println("Initial snacks count: " + vendingMachine.getSnacksCount());

        VendingMachineCareTaker careTaker = new VendingMachineCareTaker();
        careTaker.saveMemento(vendingMachine.saveToMemento());

        vendingMachine.dispenseSnack();
        vendingMachine.dispenseSnack();
        vendingMachine.addSnack();
        System.out.println("Snacks count after dispensing: " + vendingMachine.getSnacksCount());

        vendingMachine.restoreFromMemento(careTaker.getMemento());
        System.out.println("Snacks count after restoration: " + vendingMachine.getSnacksCount());
    }
}
