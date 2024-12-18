public class CharacterObserver implements Observer {
    private String name;

    public CharacterObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Character character) {
        System.out.println(this.name + " is notified that " + character.getName() + " has moved to (" + character.getX() + ", " + character.getY() + ").");
    }
}