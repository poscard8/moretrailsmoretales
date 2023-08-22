package github.poscard8.moretrailsmoretales;

import github.poscard8.moretrailsmoretales.init.CreativeTabInit;
import github.poscard8.moretrailsmoretales.init.ModBlocks;
import github.poscard8.moretrailsmoretales.init.ModEntities;
import github.poscard8.moretrailsmoretales.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreTrailsMoreTales.MODID)
public class MoreTrailsMoreTales {
    public static final String MODID = "moretrailsmoretales";

    public MoreTrailsMoreTales() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);

        ModEntities.ENTITIES.register(bus);
        ModEntities.BLOCK_ENTITIES.register(bus);



        CreativeTabInit.TABS.register(bus);








    }
}
