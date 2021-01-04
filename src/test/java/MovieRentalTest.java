import org.junit.*;

public class MovieRentalTest extends junit.framework.TestCase {

    Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;

    @Before
    public void setUp() {
        theManWhoKnewTooMuch = new RegularMovie("The Man Who Knew Too Much");
        mulan = new ChildrensMovie("Mulan");
        slumdogMillionaire = new NewReleaseMovie("Slumdog Millionaire");
    }


    @Test
    public void testGetTitle() {
        assertEquals("The Man Who Knew Too Much", theManWhoKnewTooMuch.get_title());
    }


    @Test
    public void testGetDaysRented() {
        assertEquals(2, new MovieRental(theManWhoKnewTooMuch, 2).getDaysRented());
    }

    @Test
    public void testGetMovie() {
        assertEquals(theManWhoKnewTooMuch, new MovieRental(theManWhoKnewTooMuch, 2).getMovie());
    }

    @Test
    public void testGetName() {
        String name = "John Doe";
        assertEquals(name, new Customer(name)._name);
    }

    @Test
    public void testStatementRegularMovieOnly() {
        // regular movies cost $2.00 for the first 2 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 1));
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 2));
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 3));
        String expectedResult = "Rental Record for John Doe\n" +
                "\tThe Man Who Knew Too Much\t2.0\n" +
                "\tThe Man Who Knew Too Much\t2.0\n" +
                "\tThe Man Who Knew Too Much\t3.5\n" +
                "Amount owed is 7.5\n" +
                "You earned 3 frequent renter points";
        assertEquals(expectedResult, johnDoe.statement());
    }

    @Test
    public void testStatementChildrensMovieOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.25/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        johnDoeJr.addMovieRental(new MovieRental(mulan, 2));
        johnDoeJr.addMovieRental(new MovieRental(mulan, 3));
        johnDoeJr.addMovieRental(new MovieRental(mulan, 4));
        String expectedResult = "Rental Record for Johnny Doe, Jr.\n" +
                "\tMulan\t1.5\n" +
                "\tMulan\t1.5\n" +
                "\tMulan\t2.75\n" +
                "Amount owed is 5.75\n" +
                "You earned 3 frequent renter points";
        assertEquals(expectedResult, johnDoeJr.statement());
    }

    @Test
    public void testStatementNewReleaseOnly() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer janeDoe = new Customer("Jane Doe");
        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire, 1));
        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire, 2));
        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire, 3));
        String expectedResult = "Rental Record for Jane Doe\n" +
                "\tSlumdog Millionaire\t3.0\n" +
                "\tSlumdog Millionaire\t6.0\n" +
                "\tSlumdog Millionaire\t9.0\n" +
                "Amount owed is 18.0\n" +
                "You earned 5 frequent renter points";
        assertEquals(expectedResult, janeDoe.statement());
    }
}