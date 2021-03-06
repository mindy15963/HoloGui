package mcjty.hologui.setup;

import mcjty.hologui.ForgeEventHandlers;
import mcjty.hologui.HoloGui;
import mcjty.hologui.ModEntities;
import mcjty.hologui.commands.ConfigurationGui;
import mcjty.hologui.config.ConfigSetup;
import mcjty.lib.compat.MainCompatHandler;
import mcjty.lib.setup.DefaultModSetup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by jorrit on 16.12.16.
 */
public class ModSetup extends DefaultModSetup {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        MinecraftForge.EVENT_BUS.register(new ForgeEventHandlers());

        //        HoloMessages.registerNetworkMessages("hologui");

        ModEntities.init();

        HoloGui.guiHandler.getGuiRegistry().registerGui(ConfigurationGui.GUI_CONFIGURATION, ConfigurationGui::create);
    }

    @Override
    protected void setupModCompat() {
        MainCompatHandler.registerWaila();
        MainCompatHandler.registerTOP();
    }

    @Override
    protected void setupConfig() {
        ConfigSetup.init();
    }

    @Override
    public void createTabs() {
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        ConfigSetup.postInit();
    }
}
