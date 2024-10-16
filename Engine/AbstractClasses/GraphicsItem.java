package engine.abstractclasses;

import java.awt.Graphics2D;

import engine.util.GraphicsPanel;

/**
 * Class to process and draw (based in the {@code z}) in the {@link GraphicsPanel}.
 */
public abstract class GraphicsItem {

    /*
     * The position of the draw.
     * If z = 0, it'll be drawn in front of all the other GraphicsItem that has a lower z;
     */
    private int z = 0;

    // Flag for the GraphicsPanel to know if the update() should be called.
    private boolean updateEnabled = true;

    // Flag for the GraphicsPanel to know if the draw() should be called.
    private boolean drawEnabled = true;

    /**
     * It's called every frame, if the update is enabled, and process all the code inside.
     * @param deltaTime The variance between the current frame and the last frame.
     */
    public abstract void update(double deltaTime);

    /**
     * It's called every frame, if the draw is enabled, and redraw the {@link GraphicsPanel}.
     * @param g2 Draw in the {@link GraphicsPanel}.
     */
    public abstract void draw(Graphics2D g2);

    /**
     * Remove {@code this} from the {@link GraphicsPanel}.
     * If there's another variable referencing {@code this}, it'll only be removed from {@link GraphicsPanel} but not freed
     * in the memory.
     */
    public void free(){
        GraphicsPanel.removeGraphicItem(this);
    }

    /**
     * Get the {@code z} value.
     * @return The position in the axis-z of the draw.
     */
    public int getZ() {
        return z;
    }

    /**
     * Set the {@code z} value.
     * <h3> Note: </h3>
     * If {@code this} is inside {@link GraphicsPanel}, the {@link GraphicsPanel} will sort the 
     * {@code List} that store all the objects that inherits {@link GraphicsItem} based in the {@code z} value.
     * @param z The position in the axis-z of the draw.
     */
    public void setZ(int z) {
        this.z = z;
        if(GraphicsPanel.containsGraphicItem(this)){
            GraphicsItem temp = this;
            GraphicsPanel.removeGraphicItem(this);
            GraphicsPanel.addGraphicItem(temp);
        }
    }

    /**
     * Check if the update is enabled
     * @return {@code true} if update is enabled, else {@code false}.
     */
    public boolean isUpdateEnabled() {
        return updateEnabled;
    }

    /**
     * Set {@code boolean} if the update should still be processed.
     * @param updateEnabled Update enabled.
     */
    public void setUpdateEnabled(boolean updateEnabled) {
        this.updateEnabled = updateEnabled;
    }

    /**
     * Check if the draw is enabled
     * @return {@code true} if draw is enabled, else {@code false}.
     */
    public boolean isDrawEnabled() {
        return drawEnabled;
    }

    /**
     * Set {@code boolean} if the draw should still be redrawn.
     * @param drawEnabled Draw enabled.
     */
    public void setDrawEnabled(boolean drawEnabled) {
        this.drawEnabled = drawEnabled;
    }

}
