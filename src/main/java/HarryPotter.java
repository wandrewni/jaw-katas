import java.util.Arrays;
import java.util.stream.IntStream;

public class HarryPotter {
    static final int BOOK_PRICE = 800;
    static final double[] DISCOUNT_RATE = new double[] {0, 0, .05, .10, .20, .25};

    public int getTotalPrice(int[] books) {
        int bookQuantity = books.length;
        final IntStream distinctedStream = Arrays.stream(books).distinct();
        long numberOfDifferentBooks = distinctedStream.count();
        final int subTotal = BOOK_PRICE * bookQuantity;
        int totalPrice = subTotal - calcSetDiscount((int) numberOfDifferentBooks);
        return totalPrice;
    }

    private int calcSetDiscount(int booksInSet){
        return booksInSet * (int)(BOOK_PRICE * DISCOUNT_RATE[booksInSet]);
    }
}
