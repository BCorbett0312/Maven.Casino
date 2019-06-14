import io.zipcoder.casino.Player;
import io.zipcoder.casino.SpinGame;
import io.zipcoder.casino.roulette.Roulette;
import org.junit.Test;
import org.junit.Assert;

public class RouletteTest {


@Test
public void testGetBalance() {
   //Given:
    // create the player
    Player player1 = new Player();
    // give the player money
    player1.setMoney(100);
    //make roulette with player
    Roulette roulette = new Roulette(player1);

    //When:
    //expected balance
    Integer expected = 300;
    Integer actual= roulette.getPlayerBalance();

    //Then:
    //this is the test
    Assert.assertEquals(actual,expected);


}

@Test
public void testPlayerBet() {
    //Given:
    Player player1= new Player();
    player1.setMoney(20);
    Roulette roulette = new Roulette(player1);


    //When:
    Integer expected = 20;
    Integer actual = roulette.playerBet();

    //Then:
    Assert.assertEquals(actual,expected);


}


@Test
public void  testSpin() {



}





}
