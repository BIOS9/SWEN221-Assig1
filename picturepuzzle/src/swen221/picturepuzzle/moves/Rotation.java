// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.moves;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Cell;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.model.Operation;

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

	/**
	 * Rotates the image in a single cell
	 * @param cell The cell to have its image rotated
	 */
	private void rotate(Cell cell)
	{
		if(cell == null)
			return;

		for(int x = 0; x < cell.getWidth() / 2; ++x)
		    for(int y = 0; y < cell.getWidth() / 2; ++y)
            {
                int size = cell.getWidth();

                // Calculate 4 positions 90 degrees apart
                int[][] positions = {
                        { x, y },
                        { size - y - 1, x },
                        { size - x - 1, size - y - 1 },
                        { y, size - x - 1}
                };

                // Temporarily save the pixels
                int[] pixels = {
                        cell.getRGB(positions[0][0], positions[0][1]),
                        cell.getRGB(positions[1][0], positions[1][1]),
                        cell.getRGB(positions[2][0], positions[2][1]),
                        cell.getRGB(positions[3][0], positions[3][1]),
                };

                // Move each pixel one position round the cell
                cell.setRGB(positions[0][0], positions[0][1], pixels[3]);
                cell.setRGB(positions[1][0], positions[1][1], pixels[0]);
                cell.setRGB(positions[2][0], positions[2][1], pixels[1]);
                cell.setRGB(positions[3][0], positions[3][1], pixels[2]);
            }

	}
}
