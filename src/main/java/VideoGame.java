public abstract class VideoGame {
    public VideoGame() {
        super();
    }

    public abstract String get_gameName();

    public abstract String get_consoleName();

    public abstract double getCharge(int _daysRented, boolean _consoleRented);

    public abstract int getFrequentRenterPoints(int _daysRented, boolean _consoleRented);
}
