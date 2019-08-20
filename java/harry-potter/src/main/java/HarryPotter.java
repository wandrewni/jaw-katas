import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HarryPotter {
    static final int BOOK_PRICE = 800;
    static final double[] DISCOUNT_RATE = new double[]{0, 0, .05, .10, .20, .25};

    public int getTotalPrice(int[] books) {
        Collection<Set<Integer>> bookSets = sortIntoSets(books);

        int totalPrice = 0;
        for (Set<Integer> bookSet : bookSets) {
            totalPrice += calcSetPrice(bookSet.size());
        }
        return totalPrice;
    }

    private Collection<Set<Integer>> sortIntoSets(int[] books) {
        Collection<Set<Integer>> bookSets = new ArrayList<>();

        for (int book : books) {
            boolean bookAddedToSet = addBookToBookSets(bookSets, book);
            if (!bookAddedToSet) {
                Set<Integer> newBookSet = new HashSet<>();
                newBookSet.add(book);
                bookSets.add(newBookSet);
            }
        }
        return bookSets;
    }

    private boolean addBookToBookSets(Collection<Set<Integer>> bookSets, int book) {
        for (Set<Integer> bookSet : bookSets) {
            if (bookSet.size() == 3 && !bookSet.contains(book)){
                bookSet.add(book);
                return true;
            }
        }
        for (Set<Integer> bookSet : bookSets) {
            if (!bookSet.contains(book)) {
                bookSet.add(book);
                return true;
            }
        }
        return false;
    }

    private int calcSetPrice(int numBooks) {
        int subTotal = BOOK_PRICE * numBooks;
        return subTotal - calcSetDiscount(numBooks);
    }

    private int calcSetDiscount(int booksInSet) {
        return booksInSet * (int) (BOOK_PRICE * DISCOUNT_RATE[booksInSet]);
    }
}
