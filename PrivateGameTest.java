package org.max.home;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
public class PrivateGameTest {
    List<Door> doors;
    Player player;
    Game game;

    @BeforeEach
    void initDoors() {
        doors = new ArrayList<>();
        doors.add(new Door(false));
        doors.add(new Door(false));
        doors.add(new Door(true));
    }

    @Test
    void testRoundWithNoChangeItsSelectionAndGetLose() {
        //given
        player = new Player("The1stPlayer", false);
        game = new Game(player, doors);
        //when
        boolean result = game.round(1).isPrize();
        //then
        Assertions.assertEquals(2, doors.size());
        Assertions.assertFalse(result);
    }

    @Test
    void testRoundWithNoChangeItsSelectionAndGetWin() {
        //given
        player = new Player("The1stPlayer", false);
        game = new Game(player, doors);
        //when
        boolean result = game.round(3).isPrize();
        //then
        Assertions.assertEquals(1, doors.size());
        Assertions.assertTrue(result);
    }

    @Test
    void testRoundWithChangeItsSelectionAndGetLose() {
        //given
        player = new Player("The1stPlayer", true);
        game = new Game(player, doors);
        //when
        boolean result = game.round(3).isPrize();
        //then
        Assertions.assertEquals(2, doors.size());
        Assertions.assertFalse(result);
    }

    @Test
    void testRoundWithChangeItsSelectionAndGetWin() {
        //given
        player = new Player("The1stPlayer", true);
        game = new Game(player, doors);
        //when
        boolean result = game.round(2).isPrize();
        //then
        Assertions.assertEquals(1, doors.size());
        Assertions.assertFalse(result);
    }

}
