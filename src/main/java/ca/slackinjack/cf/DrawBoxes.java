package ca.slackinjack.cf;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class DrawBoxes {

    private final Minecraft mc = Minecraft.getMinecraft();

    public void drawBoxForChest(CF cf, TileEntity targetTileEntity, float partialTicks) {
        if (mc.thePlayer != null && targetTileEntity != null) {
            double p_85094_2_ = (targetTileEntity.getPos().getX() - mc.thePlayer.posX);
            double p_85094_4_ = (targetTileEntity.getPos().getY() - mc.thePlayer.posY);
            double p_85094_6_ = (targetTileEntity.getPos().getZ() - mc.thePlayer.posZ);
            try {
                AxisAlignedBB aabb = targetTileEntity.getRenderBoundingBox();
                if (aabb != null) {
                    aabb = aabb.expand(-1.0f, -0.5f, -1.0f).offset(0.0f, -0.55f, 0.0f);

                    AxisAlignedBB aabb1 = new AxisAlignedBB(aabb.minX - targetTileEntity.getPos().getX() + p_85094_2_, aabb.minY - targetTileEntity.getPos().getY() + p_85094_4_, aabb.minZ - targetTileEntity.getPos().getZ() + p_85094_6_, aabb.maxX - targetTileEntity.getPos().getX() + p_85094_2_, aabb.maxY - targetTileEntity.getPos().getY() + p_85094_4_, aabb.maxZ - targetTileEntity.getPos().getZ() + p_85094_6_);
                    cf.sjUtils.getRenderBoxes().renderBox(aabb1, true, 255, 192, 32, 208);
                }
            } catch (Exception e) {

            }
        }
    }
    
    public void drawBoxForEnderChest(CF cf, TileEntity targetTileEntity, float partialTicks) {
        if (mc.thePlayer != null && targetTileEntity != null) {
            double p_85094_2_ = (targetTileEntity.getPos().getX() - mc.thePlayer.posX);
            double p_85094_4_ = (targetTileEntity.getPos().getY() - mc.thePlayer.posY);
            double p_85094_6_ = (targetTileEntity.getPos().getZ() - mc.thePlayer.posZ);
            try {
                AxisAlignedBB aabb = targetTileEntity.getRenderBoundingBox();
                if (aabb != null) {
                    aabb = aabb.expand(0.06f, 0.056f, 0.06f);

                    AxisAlignedBB aabb1 = new AxisAlignedBB(aabb.minX - targetTileEntity.getPos().getX() + p_85094_2_, aabb.minY - targetTileEntity.getPos().getY() + p_85094_4_, aabb.minZ - targetTileEntity.getPos().getZ() + p_85094_6_, aabb.maxX - targetTileEntity.getPos().getX() + p_85094_2_, aabb.maxY - targetTileEntity.getPos().getY() + p_85094_4_, aabb.maxZ - targetTileEntity.getPos().getZ() + p_85094_6_);
                    cf.sjUtils.getRenderBoxes().renderBox(aabb1, true, 32, 48, 48, 208);
                }
            } catch (Exception e) {

            }
        }
    }
}
