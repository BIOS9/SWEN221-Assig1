// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.moves;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Cell;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.model.Operation;

import java.util.HashMap;

/**
 * Responsible for rotating the image data in a given cell in a clockwise
 * direction.
 *
 * @author betty
 *
 */
public class Rotation implements Operation {
	private final Location location;
	private final int steps;

	/**
	 * Construction a rotation for the cell at a given location, rotating a given
	 * number of steps.
	 *
	 * @param loc
	 * @param steps
	 */
	public Rotation(Location loc, int steps) {
		this.location = loc;
		this.steps = steps;
	}
	/**
	 * Apply rotation to the selected cell.
	 */
	@Override
	public void apply(Board board) {
		int stepCount = steps % 4; //4 steps is equal to no change of the image

		//Ensure negative steps work correctly
		if(stepCount < 0)
			stepCount = 4 + stepCount;

		Cell cell = board.getCellAt(location);

		//Rotate 90 degrees for each step count
		for(int i = 0; i < stepCount; ++i)
			rotate(cell);
	}

	private void rotate(Cell cell)
	{
		int[] image = cell.getImage();

		HashMap<int, int> a;
		a.va
	}
}
