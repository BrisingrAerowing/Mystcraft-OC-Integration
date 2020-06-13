package teamaerowing.mystoc;

import com.google.common.hash.Hashing;
import li.cil.oc.api.driver.Converter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import java.util.Map;

public class ConverterLinkbook implements Converter {
    @Override
    public void convert(Object o, Map<Object, Object> map) {
        if(o instanceof ItemStack)
        {
            final ItemStack stack = (ItemStack)o;
            if(stack.getItem().getRegistryName().equals(new ResourceLocation("mystcraft","linkbook")) && stack.hasTagCompound())
            {
                final NBTTagCompound tag = stack.getTagCompound();
                if(tag.hasKey("Dimension"))
                {
                    map.put("dimensionId", tag.getInteger("Dimension"));
                }
                if(tag.hasKey("DisplayName"))
                {
                    map.put("dimensionName", tag.getString("DisplayName"));
                }

                if(tag.hasKey("SpawnX") && tag.hasKey("SpawnY") && tag.hasKey("SpawnZ"))
                {
                    map.put("spawnId", Hashing.murmur3_32().newHasher().
                            putInt(tag.getInteger("SpawnX")).
                            putInt(tag.getInteger("SpawnY")).
                            putInt(tag.getInteger("SpawnZ")).
                            hash().asInt());
                }

            }
        }
    }
}
