public class VideoGameRental {
    private VideoGame _videoGame;
    private int _daysRented;
    private boolean _consoleRented;

    public VideoGameRental(VideoGame videoGame,
                           int daysRented, boolean consoleRented) {
        _videoGame = videoGame;
        _daysRented = daysRented;
        _consoleRented = consoleRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public VideoGame getVideoGame() {
        return _videoGame;
    }

    public double getCharge() {
        return _videoGame.getCharge(_daysRented, _consoleRented);
    }

    public int getFrequentRenterPoints() {
        return _videoGame.getFrequentRenterPoints(_daysRented, _consoleRented);
    }
}