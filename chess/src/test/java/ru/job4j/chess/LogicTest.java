package ru.job4j.chess;


import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test
    public void testMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new BishopBlack(Cell.C8));
        logic.move(Cell.C8, Cell.H3);
        Assert.assertEquals(logic.findBy(Cell.H3), 1);
    }

    @Test (expected = FigureNotFoundException.class)
    public void testMoveWhenFigureNotFound()
            throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new BishopBlack(Cell.F8));
        logic.move(Cell.E8,Cell.F7);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void testMoveWhenImpossibleMove()
            throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.move(Cell.C8, Cell.C4);
    }

    @Test (expected = OccupiedCellException.class)
    public void testMoveWhenOccupiedCell()
            throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new BishopBlack(Cell.E6));
        logic.move(Cell.C8, Cell.H3);
    }
}