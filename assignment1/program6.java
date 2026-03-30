// Program 6: Cipher System using Abstract Class and Method Overriding

public class CipherSystem {

    // Abstract base class
    abstract static class Cipher {
        protected String name;

        Cipher(String name) {
            this.name = name;
        }

        // Abstract methods to be overridden
        public abstract String encrypt(String text);
        public abstract String decrypt(String text);

        // Concrete method shared by all ciphers
        public void display(String original) {
            String enc = encrypt(original);
            String dec = decrypt(enc);
            System.out.println("-- " + name + " --");
            System.out.println("  Original  : " + original);
            System.out.println("  Encrypted : " + enc);
            System.out.println("  Decrypted : " + dec);
            System.out.println();
        }
    }

    // 1. Caesar Cipher: shift each letter by 'key' positions
    static class CaesarCipher extends Cipher {
        private int shift;

        CaesarCipher(int shift) {
            super("Caesar Cipher (shift=" + shift + ")");
            this.shift = shift;
        }

        @Override
        public String encrypt(String text) {
            StringBuilder sb = new StringBuilder();
            for (char c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    sb.append((char) ((c - base + shift) % 26 + base));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        @Override
        public String decrypt(String text) {
            StringBuilder sb = new StringBuilder();
            for (char c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    sb.append((char) ((c - base - shift + 26) % 26 + base));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    // 2. Reverse Cipher: simply reverses the string
    static class ReverseCipher extends Cipher {

        ReverseCipher() {
            super("Reverse Cipher");
        }

        @Override
        public String encrypt(String text) {
            return new StringBuilder(text).reverse().toString();
        }

        @Override
        public String decrypt(String text) {
            return encrypt(text); // reversing twice gives the original
        }
    }

    // 3. XOR Cipher: XOR each character with a key byte
    static class XORCipher extends Cipher {
        private int key;

        XORCipher(int key) {
            super("XOR Cipher (key=" + key + ")");
            this.key = key;
        }

        @Override
        public String encrypt(String text) {
            StringBuilder sb = new StringBuilder();
            for (char c : text.toCharArray())
                sb.append((char) (c ^ key));
            return sb.toString();
        }

        @Override
        public String decrypt(String text) {
            return encrypt(text); // XOR is its own inverse
        }
    }

    public static void main(String[] args) {
        System.out.println("======= Cipher System =======\n");
        String message = "Hello World";

        Cipher[] ciphers = {
            new CaesarCipher(3),
            new ReverseCipher(),
            new XORCipher(7)
        };

        for (Cipher c : ciphers)
            c.display(message);
    }
}