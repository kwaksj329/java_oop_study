public class GarbageMaker {

    public void minorGarbageMaker() {
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }
        for (int i = 0; i < 999999999; i++) {
            Garbage garbage = new Garbage();
            garbage = null;
        }

    }

    public void majorGarbageMaker() {
        Garbage[] garbage2 = new Garbage[9999999];
        for (Garbage g : garbage2) {
            g = new Garbage();
        }
        for (Garbage g : garbage2) {
            g = null;
        }
        Garbage[] garbage3 = new Garbage[99999999];
        for (Garbage g : garbage3) {
            g = new Garbage();
        }
        for (Garbage g : garbage3) {
            g = null;
        }
        Garbage[] garbage4 = new Garbage[9999999];
        for (Garbage g : garbage4) {
            g = new Garbage();
        }
        for (Garbage g : garbage4) {
            g = null;
        }
        Garbage[] garbage5 = new Garbage[99999999];
        for (Garbage g : garbage5) {
            g = new Garbage();
        }
        for (Garbage g : garbage5) {
            g = null;
        }
    }

    public static void main(String[] args) {
        GarbageMaker gmaker = new GarbageMaker();
        System.out.println("Incurring only minor garbage collections...");
        gmaker.minorGarbageMaker();
        System.out.println("Incurring full garbage collections...");
        gmaker.majorGarbageMaker();
    }

}