/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hanranti
 */
public class StatisticsTest {

    public StatisticsTest() {
    }

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void searchFindsPlayer() {
        assertTrue(stats.search("Kurri").getName().equals("Kurri"));
    }

    @Test
    public void searchWithNonExistentPlayerReturnsNull() {
        assertNull(stats.search("irruK"));
    }

    @Test
    public void teamContainsAllPlayersInTeamAndNoOthers() {
        List<Player> team = stats.team("EDM");
        ArrayList<String> names = new ArrayList<>();
        for (Player player : team) {
            names.add(player.getName());
        }
        assertTrue(names.contains("Semenko"));
        assertTrue(names.contains("Kurri"));
        assertTrue(names.contains("Gretzky"));
        assertFalse(names.contains("Lemieux"));
    }

    @Test
    public void topScorersReturnsRightAmount() {
        assertEquals(4, stats.topScorers(4).size());
    }

    @Test
    public void topScorersAreInRightOrder() {
        List<Player> topScorers = stats.topScorers(5);

        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new Player("Lemieux", "PIT", 45, 54));
        players.add(new Player("Yzerman", "DET", 42, 56));
        players.add(new Player("Kurri", "EDM", 37, 53));
        players.add(new Player("Gretzky", "EDM", 35, 89));
        players.add(new Player("Semenko", "EDM", 4, 12));
        
        int i = 0;
        for (Player topScorer : topScorers) {
            assertEquals(players.get(i).getName(), topScorer.getName());
            i++;
        }
    }

}
