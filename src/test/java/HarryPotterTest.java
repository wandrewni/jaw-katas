import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HarryPotterTest {
    private static final int BOOK_1 = 1;
    private static final int BOOK_2 = 2;
    private static final int BOOK_3 = 3;
    private static final int BOOK_4 = 4;
    private static final int BOOK_5 = 5;
    private HarryPotter harryPotter = new HarryPotter();

    @Test
    public void zeroBooksIsZeroDollars() {
        verifyPrice(0, new int[]{});
    }

    @Test
    public void oneBookIsEightDollars() {
        final int[] books = {BOOK_1};
        final int expectedPrice = 800;
        verifyPrice(expectedPrice, books);
    }

    @Test
    public void twoBooksHaveFivePercentDiscount() {
        final int[] books = {BOOK_1, BOOK_2};
        verifyPrice(1520, books);
    }

    @Test
    public void threeBooksHave10PercentDiscount() {
        final int[] books = {BOOK_1, BOOK_2, BOOK_3};
        verifyPrice(2160, books);
    }

    @Test
    public void fourBooksHave20PercentDiscount() {
        final int[] books = {BOOK_1, BOOK_2, BOOK_3, BOOK_4};
        verifyPrice(2560, books);
    }

    @Test
    public void fiveBooksHas25PercentDiscount() {
        final int[] books = {BOOK_1, BOOK_2, BOOK_3, BOOK_4, BOOK_5};
        verifyPrice(3000, books);
    }

    @Test
    public void twoSameBooksGetsNoDiscount() {
        final int[] books = {BOOK_1, BOOK_1};
        verifyPrice(1600, books);
    }

    @Test
    public void onlySetBooksGetSetDiscount() throws Exception {
        final int[] books = {BOOK_1, BOOK_2, BOOK_2};
        verifyPrice(2320, books);
        final int[] threeAndDuplicate = {BOOK_1, BOOK_2, BOOK_3, BOOK_3};
        verifyPrice(2960, threeAndDuplicate);
        final int[] threeAndTwoDuplicates = {BOOK_1, BOOK_2, BOOK_2, BOOK_3, BOOK_3};
        verifyPrice(3680, threeAndTwoDuplicates);
    }

    @Test
    public void canGetSetDiscountsOnThreeSets() throws Exception {
        final int[] threeSets = {
                BOOK_1, BOOK_2, BOOK_3,
                BOOK_1, BOOK_2, BOOK_3,
                BOOK_1, BOOK_2, BOOK_3
        };
        verifyPrice(6480, threeSets);
    }

    @Test
    public void choosesBestPriceWhenTwoPossibilities() throws Exception {
        final int[] twoSetsOfFour_versus_setOfThreeAndSetOfFive = {
                BOOK_1, BOOK_2, BOOK_3, BOOK_4,
                BOOK_2, BOOK_3, BOOK_4, BOOK_5
        };
        verifyPrice(5120, twoSetsOfFour_versus_setOfThreeAndSetOfFive);
    }

    @Test
    public void choosesBestPriceWhenTwoPossibilities_InTroublesomeOrder() throws Exception {
        final int[] twoSetsOfFour_versus_setOfThreeAndSetOfFive = {
                BOOK_1, BOOK_2, BOOK_3, BOOK_4,
                BOOK_5, BOOK_2, BOOK_3, BOOK_4
        };
        verifyPrice(5120, twoSetsOfFour_versus_setOfThreeAndSetOfFive);
    }

    private void verifyPrice(int expectedPrice, int[] books) {
        assertEquals(expectedPrice, harryPotter.getTotalPrice(books));
    }
}
