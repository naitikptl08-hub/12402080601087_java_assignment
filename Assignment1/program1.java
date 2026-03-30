// Program 1: Array and String Operations using Class and Objects

import java.util.Arrays;

class ArrayOps {
    private int[] arr;

    ArrayOps(int[] arr) {
        this.arr = arr.clone();
    }

    // Reverse the array
    public int[] reverse() {
        int[] rev = arr.clone();
        int n = rev.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = rev[i];
            rev[i] = rev[n - 1 - i];
            rev[n - 1 - i] = temp;
        }
        return rev;
    }

    // Sort the array (ascending)
    public int[] sort() {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        return sorted;
    }

    // Linear search: returns index or -1
    public int search(int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key) return i;
        return -1;
    }

    // Average of elements
    public double average() {
        double sum = 0;
        for (int x : arr) sum += x;
        return sum / arr.length;
    }

    // Maximum element
    public int maximum() {
        int max = arr[0];
        for (int x : arr) if (x > max) max = x;
        return max;
    }

    public void display() {
        System.out.println(Arrays.toString(arr));
    }
}

class StringOps {
    private String str;

    StringOps(String str) {
        this.str = str;
    }

    // Reverse the string
    public String reverse() {
        return new StringBuilder(str).reverse().toString();
    }

    // Sort characters alphabetically
    public String sort() {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    // Search for a character; returns index or -1
    public int search(char key) {
        return str.indexOf(key);
    }

    // Average ASCII value of characters
    public double average() {
        double sum = 0;
        for (char c : str.toCharArray()) sum += c;
        return sum / str.length();
    }

    // Character with maximum ASCII value
    public char maximum() {
        char max = str.charAt(0);
        for (char c : str.toCharArray()) if (c > max) max = c;
        return max;
    }
}

public class ArrayStringOps {
    public static void main(String[] args) {
        // --- Array Operations ---
        System.out.println("===== Array Operations =====");
        int[] data = {5, 3, 8, 1, 9, 2};
        ArrayOps ao = new ArrayOps(data);

        System.out.print("Original  : "); ao.display();
        System.out.println("Reversed  : " + Arrays.toString(ao.reverse()));
        System.out.println("Sorted    : " + Arrays.toString(ao.sort()));
        System.out.println("Search(8) : index " + ao.search(8));
        System.out.println("Average   : " + ao.average());
        System.out.println("Maximum   : " + ao.maximum());

        // --- String Operations ---
        System.out.println("\n===== String Operations =====");
        StringOps so = new StringOps("hello");

        System.out.println("Original  : hello");
        System.out.println("Reversed  : " + so.reverse());
        System.out.println("Sorted    : " + so.sort());
        System.out.println("Search(l) : index " + so.search('l'));
        System.out.printf ("Average   : %.2f%n", so.average());
        System.out.println("Maximum   : " + so.maximum());
    }
}