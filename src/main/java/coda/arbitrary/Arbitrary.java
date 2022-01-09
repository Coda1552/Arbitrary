package coda.arbitrary;

import coda.arbitrary.registry.ArbitraryBlockEntities;
import coda.arbitrary.registry.ArbitraryBlocks;
import coda.arbitrary.registry.ArbitraryEffects;
import coda.arbitrary.registry.ArbitraryItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Arbitrary.MOD_ID)
public class Arbitrary {
    public static final String MOD_ID = "arbitrary";
    public final static CreativeModeTab GROUP = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ArbitraryItems.ACORN.get());
        }
    };

    public Arbitrary() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ArbitraryEffects.EFFECTS.register(bus);
        ArbitraryBlocks.BLOCKS.register(bus);
        ArbitraryItems.ITEMS.register(bus);
        ArbitraryBlockEntities.BLOCK_ENTITIES.register(bus);
    }
}
