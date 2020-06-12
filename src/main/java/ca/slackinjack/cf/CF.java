package ca.slackinjack.cf;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

import ca.slackinjack.sjutils.SJUtils;
import net.minecraft.tileentity.TileEntityEnderChest;

@Mod(modid = CF.MODID, acceptedMinecraftVersions = "1.8.9", dependencies="required-after:sjutils@[1.0.0,)")

public class CF {
    public static final String MODID = "cf";
    //private final RenderBoxes renderBoxes = new RenderBoxes();
    public static final SJUtils sjUtils = SJUtils.getUtils();
    public static final KeyBinding cfToggle = new KeyBinding("CF", Keyboard.KEY_K, "key.categories.gameplay");
    private DrawBoxes drawBoxes;
    private boolean enabled;

    static {
        ClientRegistry.registerKeyBinding(cfToggle);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChest.class, new DummyTileEntityChestRenderFactory(this));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnderChest.class, new DummyTileEntityEnderChestRenderFactory(this));
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        if (cfToggle.isPressed()) {
            this.setEnabled(!this.enabled);
            sjUtils.getAddChatMessage().add("CF", (this.enabled ? "Enabled!" : "Disabled!"), (this.enabled ? 0 : 1));
        }
    }

    private void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }
    
    public DrawBoxes getDrawBoxes() {
        if (this.drawBoxes == null) {
            drawBoxes = new DrawBoxes();
        }
        
        return drawBoxes;
    }
}
