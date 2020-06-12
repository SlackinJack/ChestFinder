package ca.slackinjack.cf;

import net.minecraft.client.renderer.tileentity.TileEntityChestRenderer;
import net.minecraft.tileentity.TileEntityChest;

public class DummyTileEntityChestRenderFactory extends TileEntityChestRenderer {

    private final CF cf;

    public DummyTileEntityChestRenderFactory(CF cf) {
        this.cf = cf;
    }

    @Override
    public void renderTileEntityAt(TileEntityChest te, double x, double y, double z, float partialTicks, int destroyStage) {
        if (cf.getEnabled()) {
            cf.getDrawBoxes().drawBoxForChest(cf, te, partialTicks);
        }
        super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
    }
}
