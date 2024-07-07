package dev.dubhe.curtain.mixins.events.item_stack;

import dev.dubhe.curtain.events.events.ItemStackEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(method = "use", at = @At("HEAD"))
    private void use(Level level, Player player, InteractionHand usedHand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
      NeoForge.EVENT_BUS.post(new ItemStackEvent.Use((ItemStack) (Object) this, level, player, usedHand));
    }

  @Inject(method = "hurtAndBreak*", at = @At("HEAD"))
  private <T extends LivingEntity> void hurtAndBreak(int pAmount, LivingEntity pEntity, EquipmentSlot pSlot, CallbackInfo ci) {
    if (pEntity instanceof Player player)
      NeoForge.EVENT_BUS.post(new ItemStackEvent.HurtAndBreak((ItemStack) (Object) this, pAmount, player));
    }
}
