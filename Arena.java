import java.util.ArrayList;
import java.util.List;

public class Arena {
    private List<Character> characters = new ArrayList<>();

    public void addCharacter(Character character) {
        characters.add(character);
        System.out.println(character.getName() + " has entered the arena at (" + character.getX() + ", " + character.getY() + ").");
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void notifyAboutMovement(Character character) {
        for (Character other : characters) {
            // Перевіряємо, чи персонажі на одній позиції та чи це не той самий персонаж
            if (other != character && other.getX() == character.getX() && other.getY() == character.getY()) {
                System.out.println(character.getName() + " encountered " + other.getName() + " at (" + character.getX() + ", " + character.getY() + ").");

                // Персонаж атакує іншого
                character.attack(other);

                // Інший персонаж атакує у відповідь, якщо ще живий
                if (other.getHealth() > 0) {
                    other.attack(character);
                }
            }
        }
    }
}
