public class NewReleaseMovie extends Movie {

    public static final int FREQUENT_RENTER_POINTS = 1;
    public static final double RENTAL_COST = 3;

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int _daysRented) {
        double result = 0;
        result += _daysRented * RENTAL_COST;
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int _daysRented) {
        int frequentRenterPoints = FREQUENT_RENTER_POINTS;
        // add bonus for a two day new release rental
        if ( _daysRented > FREQUENT_RENTER_POINTS)
            frequentRenterPoints += frequentRenterPoints;
        return frequentRenterPoints;
    }
}
