package teamaerowing.mystoc;

import li.cil.oc.api.driver.Converter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;

public class ConverterAgebook implements Converter {
    @java.lang.Override
    public void convert(java.lang.Object o, java.util.Map<java.lang.Object, java.lang.Object> map) {
        if(o instanceof ItemStack)
        {
            final ItemStack stack = (ItemStack)o;
            if(stack.getItem().getRegistryName().equals(new ResourceLocation("mystcraft", "agebook")) && stack.hasTagCompound()) {
                final NBTTagCompound tag = stack.getTagCompound();
                if (tag.hasKey("Dimension"))
                {
                    map.put("dimensionId", tag.getInteger("Dimension"));
                }
                if(tag.hasKey("DisplayName"))
                {
                    map.put("dimensionName", tag.getString("DisplayName"));
                }

                if(tag.hasKey("Flags"))
                {
                    final HashMap<String, Boolean> flags = new HashMap<>();

                    map.put("flags", flags);

                    final NBTTagCompound flagsNbt = tag.getCompoundTag("Flags");
                    for(String flag : flagsNbt.getKeySet())
                    {
                        flags.put(flag, flagsNbt.getBoolean(flag));
                    }

                }

            }
        }
    }
}
