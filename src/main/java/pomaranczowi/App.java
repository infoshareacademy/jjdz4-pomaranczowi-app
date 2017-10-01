package pomaranczowi;

public class App
{
    public static void main( String[] args ) {

        Currency aud = new Currency("AUD.txt"); //test
        System.out.println(aud.getClose("20160524")); //test
        System.out.println(aud.getClose("20160526")); //test

    }
}
