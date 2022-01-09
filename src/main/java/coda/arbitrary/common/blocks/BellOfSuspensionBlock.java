package coda.arbitrary.common.blocks;

import coda.arbitrary.common.blockentities.BellOfSuspensionBlockEntity;
import coda.arbitrary.registry.ArbitraryBlockEntities;
import coda.arbitrary.registry.ArbitraryEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BellBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class BellOfSuspensionBlock extends BaseEntityBlock {
    private static final VoxelShape BELL_TOP_SHAPE = Block.box(5.0D, 6.0D, 5.0D, 11.0D, 13.0D, 11.0D);
    private static final VoxelShape BELL_BOTTOM_SHAPE = Block.box(4.0D, 4.0D, 4.0D, 12.0D, 6.0D, 12.0D);
    private static final VoxelShape BELL_SHAPE = Shapes.or(BELL_BOTTOM_SHAPE, BELL_TOP_SHAPE);

    public BellOfSuspensionBlock(Properties p_49696_) {
        super(p_49696_);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand han, BlockHitResult hit) {
        player.addEffect(new MobEffectInstance(ArbitraryEffects.VOID_WALKER.get(), 1200, 0));

        level.playSound(null, pos, SoundEvents.BELL_BLOCK, SoundSource.BLOCKS, 2.0F, 1.0F);

        return super.use(state, level, pos, player, han, hit);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_152198_, BlockState p_152199_) {
        return new BellOfSuspensionBlockEntity(p_152198_, p_152199_);
    }

    private VoxelShape getVoxelShape() {
        return BELL_SHAPE;
    }

    public VoxelShape getCollisionShape(BlockState p_49760_, BlockGetter p_49761_, BlockPos p_49762_, CollisionContext p_49763_) {
        return this.getVoxelShape();
    }

    public VoxelShape getShape(BlockState p_49755_, BlockGetter p_49756_, BlockPos p_49757_, CollisionContext p_49758_) {
        return this.getVoxelShape();
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState pos, BlockEntityType<T> be) {
        return createTickerHelper(be, ArbitraryBlockEntities.BELL_OF_SUSPENSION.get(), BellOfSuspensionBlockEntity::tick);
    }

    public RenderShape getRenderShape(BlockState p_49753_) {
        return RenderShape.MODEL;
    }
}
