package tfc.better_with_shaders.gui.button;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlider;

public class SliderButton extends GuiSlider implements IOptionButton {
    String name;
    ShaderOption option;

    public SliderButton(int id, int xPosition, int yPosition, ShaderOption option) {
        super(id, xPosition, yPosition, option);
        this.name = option.getDisplayStringName();
        this.option = option;
    }

    public SliderButton(int id, int xPosition, int yPosition, int width, int height, ShaderOption option) {
        super(id, xPosition, yPosition, width, height, option);
        this.name = option.getDisplayStringName();
        this.option = option;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean mouseClicked(Minecraft minecraft, int i, int j) {
        float ov = sliderValue;
        boolean rv = super.mouseClicked(minecraft, i, j);
        if (sliderValue != ov) {
            option.value = sliderValue;
            option.onUpdate(this);
        }
        return rv;
    }

    @Override
    public void mouseReleased(int i, int j) {
        float ov = sliderValue;
        super.mouseReleased(i, j);
        if (sliderValue != ov) {
            option.value = sliderValue;
            option.onUpdate(this);
        }
    }

    @Override
    public void mouseDragged(Minecraft minecraft, int i, int j) {
        float ov = sliderValue;
        super.mouseDragged(minecraft, i, j);
        if (sliderValue != ov) {
            option.value = sliderValue;
            option.onUpdate(this);
        }
    }
}
