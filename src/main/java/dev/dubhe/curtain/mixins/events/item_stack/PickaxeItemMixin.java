package dev.dubhe.curtain.mixins.events.item_stack;

import dev.dubhe.curtain.events.events.ItemStackEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PickaxeItem.class)
public abstract class PickaxeItemMixin extends DiggerItem {
  public PickaxeItemMixin(Tier pTier, TagKey<Block> pBlocks, Properties pProperties) {
    super(pTier, pBlocks, pProperties);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
      //todo
      ItemStackEvent.BreakSpeed event = new ItemStackEvent.BreakSpeed(stack, state, super.getDestroySpeed(stack, state), 1.0f);
      NeoForge.EVENT_BUS.post(event);
        return event.getSpeed();
    }
}
