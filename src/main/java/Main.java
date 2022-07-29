public class Main {
    public static void main(String[] args) {
        Document doc = new Document(10001, "W9-form", "Doc");
        doc.checkSize();
        doc.typeCheck();

        int a = Integer.MAX_VALUE;
        int b = 1;
        System.out.println(a + b);

        int c = 2;
        double d = 123.345;
        System.out.println(c + d);

        int e = (int) (c + d);
        System.out.println(e);

        double f = c + d;
        System.out.println(f);


        int g = b++;
        if (g < 5) {
            System.out.println(g + " bigger or equals than 2");
        } else {
            System.out.println(g + " smaller than 2");
        }

        int k = 1;
        int j = ++k;
        if (j >= 2) {
            System.out.println(j + " bigger or equals than 2");
        } else {
            System.out.println(j + " smaller than 2");
        }
    }
}
