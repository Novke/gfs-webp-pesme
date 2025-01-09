package gfs.webp.pesme.util;

public class PrintUtils {

    private static Integer SIRINA = 120;

    public static void ispisiCeoRedKarakterom(String text){
        for (int i = 0; i < SIRINA; i++) System.out.print(text);
        System.out.println();
    }

    public static void ispisiCeoRedJednaLinija(){
        ispisiCeoRedKarakterom("-");
    }
    public static void ispisiCeoRedDveLinije(){
        ispisiCeoRedKarakterom("=");
    }

    public static void ispisiUokvireno(String text, int debljinaRama){
        if (debljinaRama<1) debljinaRama = 1;
        if (debljinaRama>10) debljinaRama = 10;

        for (int i = 0; i < debljinaRama; i++) System.out.print("=");

        System.out.print("  ");
        System.out.print(text);

        for (int i = debljinaRama * 2 + 4 + text.length(); i < SIRINA; i++){
            System.out.print(" ");
        }

        System.out.print("  ");
        for (int i = 0; i < debljinaRama; i++) System.out.print("=");
        System.out.println();
    }

    public static void ispisiUokvireno(String text){
        ispisiUokvireno(text, 3);
    }

    public static void ispisiBanner(){
        String text = """
              
                                                                                                     \s
                                                                                                     \s
                        GGGGGGGGGGGGG        FFFFFFFFFFFFFFFFFFFFFF           SSSSSSSSSSSSSSS        \s
                     GGG::::::::::::G        F::::::::::::::::::::F         SS:::::::::::::::S       \s
                   GG:::::::::::::::G        F::::::::::::::::::::F        S:::::SSSSSS::::::S       \s
                  G:::::GGGGGGGG::::G        FF::::::FFFFFFFFF::::F        S:::::S     SSSSSSS       \s
                 G:::::G       GGGGGG          F:::::F       FFFFFF        S:::::S                   \s
                G:::::G                        F:::::F                     S:::::S                   \s
                G:::::G                        F::::::FFFFFFFFFF            S::::SSSS                \s
                G:::::G    GGGGGGGGGG          F:::::::::::::::F             SS::::::SSSSS           \s
                G:::::G    G::::::::G          F:::::::::::::::F               SSS::::::::SS         \s
                G:::::G    GGGGG::::G          F::::::FFFFFFFFFF                  SSSSSS::::S        \s
                G:::::G        G::::G          F:::::F                                 S:::::S       \s
                 G:::::G       G::::G          F:::::F                                 S:::::S       \s
                  G:::::GGGGGGGG::::G        FF:::::::FF                   SSSSSSS     S:::::S       \s
                   GG:::::::::::::::G ...... F::::::::FF            ...... S::::::SSSSSS:::::S ......\s
                     GGG::::::GGG:::G .::::. F::::::::FF            .::::. S:::::::::::::::SS  .::::.\s
                        GGGGGG   GGGG ...... FFFFFFFFFFF            ......  SSSSSSSSSSSSSSS    ......\s
                                                                                                     \s
                 G R A D J E V I N S K I      F A K U L T E T       U      S U B O T I C I           \s
                                
                """;
        System.out.println(text);
    }
}
