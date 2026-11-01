package logan.pixl.block.custom;

import logan.pixl.block.ModBlocks;
import logan.pixl.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 1, 0);

        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.BLOCKS, 2f, 1f);
        return InteractionResult.SUCCESS;
    }



    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        // buddie season 10 :pray:
        if(entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 300));
        }

        BlockPos posBelow = pos.below();
        BlockState stateBelow = level.getBlockState(posBelow);

        if(entity instanceof ItemEntity itemEntity) {
            if(stateBelow.is(Blocks.OBSIDIAN)) {
                if(isValidItem(itemEntity.getItem())) {
                    itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount() * 4));
                }
            }

        }
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(ModItems.FLUORITE) || item.is(Items.IRON_INGOT);
    }

}
