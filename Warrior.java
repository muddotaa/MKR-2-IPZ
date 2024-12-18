public class Warrior extends Character {
    public Warrior(String name, int health, int attackPower, int x, int y) {
        super(name, health, attackPower, x, y);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - this.attackPower);
        System.out.println(this.name + " attacks " + target.getName() + " for " + this.attackPower + " damage.");
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        System.out.println(this.name + " moves to (" + this.x + ", " + this.y + ").");
    }
}

