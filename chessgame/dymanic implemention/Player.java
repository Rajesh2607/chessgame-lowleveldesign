public class Player {
    private Account account;
    private Color color;

    public Player(Account account, Color color) {
        this.account = account;
        this.color = color;
    }

    public String getName() {
        return account.getName();
    }

    public Color getColor() {
        return color;
    }
}
