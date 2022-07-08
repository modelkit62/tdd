package calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class App {

    int calculateAddition(int a, int b){
        return 0;
        //return a + b;
    }

    @Test
    public void testCalculateAddition(){
        int a = 2;
        int b = 2;
        assertEquals(4, calculateAddition(a, b));
    }
}
