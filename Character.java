public abstract class Character {
    protected String name;
    protected int health;
    protected int attackPower;
    protected int x;
    protected int y;

    public Character(String name, int health, int attackPower, int x, int y) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Перевіряємо, чи це той самий об'єкт
        if (obj == null || getClass() != obj.getClass()) return false; // Перевірка на null або інший клас
        Character character = (Character) obj;
        return name.equals(character.name); // Порівняння за унікальним іменем
    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void attack(Character target);
    public abstract void move(int dx, int dy);
}

