public class CharacterFactory {
    public static Character createCharacter(String type, String name, int health, int attackPower, int x, int y) {
        switch (type.toLowerCase()) {
            case "warrior":
                return new Warrior(name, health, attackPower, x, y);
            case "mage":
                return new Mage(name, health, attackPower, x, y);
            case "archer":
                return new Archer(name, health, attackPower, x, y);
            default:
                throw new IllegalArgumentException("Unknown character type: " + type);
        }
    }
}


