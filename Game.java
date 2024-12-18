import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Create the arena (mediator)
        Arena arena = new Arena();

        Scanner scanner = new Scanner(System.in);

        // Create and add characters to the arena
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter character type (warrior, mage, archer): ");
            String type = scanner.nextLine();
            System.out.println("Enter character name: ");
            String name = scanner.nextLine();
            System.out.println("Enter character health: ");
            int health = scanner.nextInt();
            System.out.println("Enter character attack power: ");
            int attackPower = scanner.nextInt();
            System.out.println("Enter character starting x position: ");
            int x = scanner.nextInt();
            System.out.println("Enter character starting y position: ");
            int y = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            Character character = CharacterFactory.createCharacter(type, name, health, attackPower, x, y);
            arena.addCharacter(character);

            ObservableCharacter observableCharacter = new ObservableCharacter(name, health, attackPower, x, y);
            CharacterObserver observer = new CharacterObserver("Observer" + (i + 1));
            observableCharacter.addObserver(observer);

            observableCharacter.move(0, 0);  // Move to the initial position to trigger any possible attacks
            arena.notifyAboutMovement(observableCharacter);
        }

        // Check for interactions (attacks) after all characters are added
        for (Character character : arena.getCharacters()) {
            arena.notifyAboutMovement(character);
        }

        scanner.close();
    }
}



