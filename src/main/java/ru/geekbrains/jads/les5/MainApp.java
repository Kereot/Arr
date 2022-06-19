package ru.geekbrains.jads.les5;

public class MainApp {
    public static void main(String[] args) {
        // В общем сначала я подумал, что надо зафиксировать основание,
        // поэтому изначально реализовал через вспомогательный метод.
        exp(3, -4);
        // Потом, конечно, погуглил, чтобы провериться,
        // и сразу нашёл намного более лаконичный вариант.
        System.out.println(expAfterGoogleCheck(3, -4));

        exp(-5, 7);
        System.out.println(expAfterGoogleCheck(-5, 7));
    }

    public static void exp(float base, int e) {
        if (base == 0f && e > 0) {
            System.out.println("Result = " + 0);
            return;
        }
        if (base == 0f) throw new IllegalArgumentException();
        if (e == 0) {
            System.out.println("Result = " + 1);
            return;
        }
        // Все эти ифы просто, чтобы не гонять метод
        service(base, base, e);
    }
    private static void service(float base, float temp, int e) {
        if (e == 1) {
            System.out.println("Result = " + base);
        }
        if (e == -1) {
            System.out.println("Result = " + ( 1 / base));
        }
        if (e > 1) {
            service(base*temp, temp, e - 1);
        }
        if (e < -1){
            service(base*temp, temp, e + 1);
        }
    }

    private static float expAfterGoogleCheck(float base, int e) {
        if (e == 0) return 1;
        else if (e > 0) return base * expAfterGoogleCheck(base, e - 1);
        else return 1 / base * expAfterGoogleCheck(base, e + 1);
    }
}
