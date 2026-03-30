// Program 7: Inner Classes — Member, Local, and Anonymous

public class Program7 {

    private String outerField = "Outer Field";

    // =============================================
    // 1. MEMBER INNER CLASS
    //    Declared directly inside the outer class.
    //    Has access to all outer class members.
    // =============================================
    class MemberInner {
        private String innerField = "Member Inner Field";

        public void display() {
            System.out.println("  [MemberInner] outerField = " + outerField);
            System.out.println("  [MemberInner] innerField = " + innerField);
        }
    }

    // =============================================
    // 2. STATIC NESTED CLASS
    //    Like a member class but static — does NOT
    //    hold a reference to an outer instance.
    // =============================================
    static class StaticNested {
        public void display() {
            System.out.println("  [StaticNested] I am a static nested class.");
            System.out.println("  [StaticNested] Cannot access outerField directly.");
        }
    }

    // =============================================
    // Helper interface used by local & anonymous
    // =============================================
    interface Greeting {
        void greet(String name);
    }

    // Method demonstrating LOCAL INNER CLASS
    public void localClassDemo() {

        // =============================================
        // 3. LOCAL INNER CLASS
        //    Defined inside a method. Scope is limited
        //    to that method only.
        // =============================================
        class LocalGreeting implements Greeting {
            @Override
            public void greet(String name) {
                System.out.println("  [LocalClass] Hello, " + name + "! (from local class)");
            }
        }

        Greeting lg = new LocalGreeting();
        lg.greet("Alice");
    }

    // Method demonstrating ANONYMOUS INNER CLASS
    public void anonymousClassDemo() {

        // =============================================
        // 4. ANONYMOUS INNER CLASS
        //    A one-time class with no name, defined
        //    and instantiated at the same time.
        // =============================================
        Greeting ag = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("  [AnonymousClass] Hi, " + name + "! (from anonymous class)");
            }
        };

        ag.greet("Bob");
    }

    public static void main(String[] args) {
        P7_InnerClasses outer = new P7_InnerClasses();

        System.out.println("===== 1. Member Inner Class =====");
        P7_InnerClasses.MemberInner member = outer.new MemberInner();
        member.display();

        System.out.println("\n===== 2. Static Nested Class =====");
        P7_InnerClasses.StaticNested staticNested = new P7_InnerClasses.StaticNested();
        staticNested.display();

        System.out.println("\n===== 3. Local Inner Class =====");
        outer.localClassDemo();

        System.out.println("\n===== 4. Anonymous Inner Class =====");
        outer.anonymousClassDemo();

        // Lambda expression (modern alternative to anonymous class for functional interfaces)
        System.out.println("\n===== 5. Lambda (modern anonymous) =====");
        Greeting lambda = name ->
            System.out.println("  [Lambda] Hey, " + name + "! (from lambda expression)");
        lambda.greet("Charlie");
    }
}