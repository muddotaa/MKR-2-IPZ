import java.util.HashSet;
import java.util.Set;

public class ObservableCharacter extends Character implements Observable {
    private Set<Observer> observers = new HashSet<>();

    public ObservableCharacter(String name, int health, int attackPower, int x, int y) {
        super(name, health, attackPower, x, y);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - this.attackPower);
        System.out.println(this.name + " attacks " + target.getName() + " for " + this.attackPower + " damage.");
        notifyObservers();
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        System.out.println(this.name + " moves to (" + this.x + ", " + this.y + ").");
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}




