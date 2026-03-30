// Program 3: Wrapper Classes and String vs StringBuffer

public class WrapperAndString {

    public static void main(String[] args) {

        // ===== WRAPPER CLASSES =====
        System.out.println("===== Wrapper Classes =====");

        // Auto-boxing: primitive → object
        int primitiveInt = 42;
        Integer wrappedInt = primitiveInt;          // auto-boxing
        double primitiveDouble = 3.14;
        Double wrappedDouble = primitiveDouble;

        System.out.println("Boxed int    : " + wrappedInt);
        System.out.println("Boxed double : " + wrappedDouble);

        // Unboxing: object → primitive
        int unboxed = wrappedInt;                  // auto-unboxing
        System.out.println("Unboxed int  : " + unboxed);

        // Parsing strings to primitives
        int parsed   = Integer.parseInt("123");
        double dParsed = Double.parseDouble("9.81");
        boolean bParsed = Boolean.parseBoolean("true");
        System.out.println("Parsed int   : " + parsed);
        System.out.println("Parsed double: " + dParsed);
        System.out.println("Parsed bool  : " + bParsed);

        // Useful Wrapper constants and methods
        System.out.println("Max int      : " + Integer.MAX_VALUE);
        System.out.println("Min int      : " + Integer.MIN_VALUE);
        System.out.println("Binary of 10 : " + Integer.toBinaryString(10));
        System.out.println("Hex of 255   : " + Integer.toHexString(255));

        // Character wrapper
        char ch = 'A';
        System.out.println("isLetter     : " + Character.isLetter(ch));
        System.out.println("isDigit      : " + Character.isDigit(ch));
        System.out.println("toLowerCase  : " + Character.toLowerCase(ch));

        // ===== STRING vs StringBuffer =====
        System.out.println("\n===== String vs StringBuffer =====");

        // String: immutable
        String s = "Hello";
        System.out.println("String before concat  : " + s);
        s = s + " World";   // creates a new object; original "Hello" is unchanged
        System.out.println("String after concat   : " + s);

        // StringBuffer: mutable, thread-safe
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("\nStringBuffer before   : " + sb);
        sb.append(" World");          // modifies the SAME object
        System.out.println("After append          : " + sb);
        sb.insert(5, ",");
        System.out.println("After insert at 5     : " + sb);
        sb.delete(5, 6);
        System.out.println("After delete(5,6)     : " + sb);
        sb.reverse();
        System.out.println("After reverse         : " + sb);
        sb.replace(0, 5, "WORLD");
        System.out.println("After replace(0,5)    : " + sb);

        // Performance comparison
        System.out.println("\n--- Performance Test: 50,000 concatenations ---");

        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 50000; i++) str += "a";
        System.out.println("String time     : " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        StringBuffer sbPerf = new StringBuffer();
        for (int i = 0; i < 50000; i++) sbPerf.append("a");
        System.out.println("StringBuffer time: " + (System.currentTimeMillis() - start) + " ms");
    }
}