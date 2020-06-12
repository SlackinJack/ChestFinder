package ca.slackinjack.cf;

import net.minecraft.client.renderer.tileentity.TileEntityEnderChestRenderer;
import net.minecraft.tileentity.TileEntityEnderChest;

public class DummyTileEntityEnderChestRenderFactory extends TileEntityEnderChestRenderer {

    private final CF cf;

    public DummyTileEntityEnderChestRenderFactory(CF cf) {
        this.cf = cf;
    }

    @Override
    public void renderTileEntityAt(TileEntityEnderChest te, double x, double y, double z, float partialTicks, int destroyStage) {
        if (cf.getEnabled()) {
            cf.getDrawBoxes().drawBoxForEnderChest(cf, te, partialTicks);
        }
        super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
    }
}
