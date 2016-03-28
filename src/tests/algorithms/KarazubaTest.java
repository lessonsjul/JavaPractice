package algorithms;


import org.junit.Test;

import static org.junit.Assert.*;

public class KarazubaTest {

    @Test
    public void multiplyTestOne(){
        Karazuba x = new Karazuba("8711129198194917883527844183686122989894424943636426448417394566");
        Karazuba y = new Karazuba("2924825637132661199799711722273977411715641477832758942277358764");

        Karazuba expected = new Karazuba("25478534007255378799894857247961445544397925869179138904636157575535921570058983065006369481295619500406669960288667484926076424");
        Karazuba result = x.multiply(y);
        assertEquals(result, expected);
        System.out.println(result);
    }

    @Test
    public void multiplyTestTwo(){
        Karazuba x = new Karazuba("8436939677358274975644341226884162349535836199962392872868456892");
        Karazuba y = new Karazuba("3864264464372346883776335161325428226997417338413342945574123327");

        Karazuba expected = new Karazuba("32602566183268675582196165592691544162522778809155901895617284287276672563976841699892789718741377833554298336397153444191119684");
        Karazuba result = x.multiply(y);
        assertEquals(result, expected);
        System.out.println(result);
    }

    @Test
    public void multiplyTestNull(){
        Karazuba x = new Karazuba("0");
        Karazuba y = new Karazuba("0");

        Karazuba expected = new Karazuba("0");
        Karazuba result = x.multiply(y);
        assertEquals(result, expected);
        System.out.println(result);
    }
}
