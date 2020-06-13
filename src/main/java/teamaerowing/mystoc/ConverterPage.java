package teamaerowing.mystoc;

import li.cil.oc.api.driver.Converter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import java.util.Map;

public class ConverterPage implements Converter {
    @Override
    public void convert(Object o, Map<Object, Object> map) {
        if(o instanceof ItemStack)
        {
            final ItemStack stack = (ItemStack)o;
            if(stack.getItem().getRegistryName().equals(new ResourceLocation("mystcraft", "page")) && stack.hasTagCompound())
            {
                final NBTTagCompound tag = stack.getTagCompound();
                map.put("symbol", tag.getString("symbol"));
            }
        }
    }
}
