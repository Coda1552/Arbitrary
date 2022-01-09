package coda.arbitrary.common;

import coda.arbitrary.Arbitrary;
import coda.arbitrary.registry.ArbitraryEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Arbitrary.MOD_ID)
public class CommonEvents {

    @SubscribeEvent
    public static void voidWalkerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        BlockPos pos = new BlockPos(player.getX(), player.getY(), player.getZ());

        if (!player.isCreative() && !player.isSpectator() && player.hasEffect(ArbitraryEffects.VOID_WALKER.get())) {
            if (player.getFeetBlockState().isAir()) {

                Vec3 d3 = player.getViewVector(1.0F);
                BlockPos pos1 = pos.below();

                if (!player.isOnGround() && !player.level.getBlockState(pos1).isRedstoneConductor(player.getLevel(), pos1) && !player.level.getBlockState(pos1.below()).isRedstoneConductor(player.getLevel(), pos1)) {
                    Vec3 vec31 = Vec3.ZERO;
                    player.setDeltaMovement(vec31.add(d3));
                    player.setPose(Pose.SWIMMING);
                    player.startFallFlying();
                    player.resetFallDistance();
                }

            }
        }

        if (player.level.getBlockState(pos.below()).isRedstoneConductor(player.getLevel(), pos)) {
            player.stopFallFlying();
        }
    }

}
