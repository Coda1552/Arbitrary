package coda.arbitrary.registry;

import coda.arbitrary.Arbitrary;
import coda.arbitrary.common.effects.VoidWalkerEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArbitraryEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Arbitrary.MOD_ID);

    public static final RegistryObject<MobEffect> VOID_WALKER = EFFECTS.register("void_walker", VoidWalkerEffect::new);
}
