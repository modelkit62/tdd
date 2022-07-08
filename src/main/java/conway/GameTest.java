package conway;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void test(){
        Game game = new Game(4, 5);
        game.setAlive(2,1);
        game.setAlive(2,2);
        game.setAlive(2,3);
        assertEquals(3, game.getAliveNeighbours(1,2));
    }



}
