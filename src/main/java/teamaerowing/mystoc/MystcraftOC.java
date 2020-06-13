package teamaerowing.mystoc;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import li.cil.oc.api.Driver;

@Mod(modid = MystcraftOC.MODID, name = MystcraftOC.NAME, version = MystcraftOC.VERSION, dependencies = "required-after:opencomputers")
public class MystcraftOC
{
    public static final String MODID = "mystoc";
    public static final String NAME = "Mystcraft / OpenComputers Integration";
    public static final String VERSION = "0.1";


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

        Driver.add(new ConverterAgebook());
        Driver.add(new ConverterLinkbook());
        Driver.add(new ConverterPage());

    }
}
