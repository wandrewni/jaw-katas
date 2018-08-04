import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HarryPotterTest {
    private static final int BOOK_ONE = 1;
    private static final int BOOK_TWO = 2;
    private static final int BOOK_THREE = 3;
    private static final int BOOK_FOUR = 4;
    private static final int BOOK_FIVE = 5;
    HarryPotter harryPotter = new HarryPotter();

    @Test
    public void zeroBooksIsZeroDollars() {
        assertEquals(BOOK_ONE, harryPotter.getTotalPrice(new int[]{}));
    }

    @Test
    public void oneBookIsEightDollars() {
        final int[] books = {BOOK_ONE};
        assertEquals(800, harryPotter.getTotalPrice(books));
    }

    @Test
    public void twoBooksHaveFivePercentDiscount() {
        final int[] books = {BOOK_ONE, BOOK_TWO};
        assertEquals(1520, harryPotter.getTotalPrice(books));
    }

    @Test
    public void threeBooksHave10PercentDiscount() {
        final int[] books = {BOOK_ONE, BOOK_TWO, BOOK_THREE};
        assertEquals(2160, harryPotter.getTotalPrice(books));
    }

    @Test
    public void fourBooksHave20PercentDiscount() {
        final int[] books = {BOOK_ONE, BOOK_TWO, BOOK_THREE, BOOK_FOUR};
        assertEquals(2560, harryPotter.getTotalPrice(books));
    }

    @Test
    public void fiveBooksHas25PercentDiscount() {
        final int[] books = {BOOK_ONE, BOOK_TWO, BOOK_THREE, BOOK_FOUR, BOOK_FIVE};
        assertEquals(3000, harryPotter.getTotalPrice(books));
    }

    @Test
    public void twoSameBooksGetsNoDiscount() {
        final int[] books = {BOOK_ONE, BOOK_ONE};
        assertEquals(1600, harryPotter.getTotalPrice(books));
    }
}
