package ru.job4j.chess.firuges.black;


import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.position(), is(Cell.C8));
    }

    @Test
    public void testCopy() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Figure newBishopBlack = bishopBlack.copy(Cell.F5);
       assertThat(newBishopBlack.position(), is(Cell.F5));
    }

    @Test
    public void testWay() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell[] expected = {Cell.D7, Cell.E6, Cell.F5};
        assertThat(bishopBlack.way(Cell.G4), is(expected));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenIsNotDiagonal() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        bishopBlack.way(Cell.G7);
    }
}