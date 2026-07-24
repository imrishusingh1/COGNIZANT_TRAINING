public class LibrarySearch {

    // Linear Search - O(n), works on unsorted arrays
    public static Book linearSearch(Book[] books, int targetId) {
        for (Book book : books) {
            if (book.getBookId() == targetId) return book;
        }
        return null;
    }

    // Binary Search - O(log n), requires SORTED array by bookId
    public static Book binarySearch(Book[] books, int targetId) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (books[mid].getBookId() == targetId) return books[mid];
            else if (books[mid].getBookId() < targetId) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
}
