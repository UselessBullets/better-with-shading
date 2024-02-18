package tfc.better_with_shaders;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.options.components.ShortcutComponent;
import net.minecraft.client.gui.options.data.OptionsPage;
import net.minecraft.client.gui.options.data.OptionsPages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfc.better_with_shaders.gui.ShaderMenu;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class BetterWithShaders implements GameStartEntrypoint {
    public static final String MOD_ID = "examplemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static Minecraft mc = Minecraft.getMinecraft(Minecraft.class);
    public static OptionsPage shaderMenu = new OptionsPage("shaders").withComponent(new ShortcutComponent("shadermenu",
            () -> mc.displayGuiScreen(new ShaderMenu(mc.currentScreen))));
    @Override
    public void beforeGameStart() {


    }

    @Override
    public void afterGameStart() {
        OptionsPages.register(shaderMenu);
        LOGGER.info("ExampleMod initialized.");
    }
}
