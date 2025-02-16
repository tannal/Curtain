package dev.dubhe.curtain.mixins.rules.better_sign_interaction;

import net.minecraft.world.level.block.SignBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SignBlock.class)
public abstract class SignBlockMixin {
    private final SignBlock self = (SignBlock) (Object) this;

//    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;)V"), cancellable = true)
//    public void use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir) {
//        if (CurtainRules.betterSignInteraction && self instanceof WallSignBlock) {
//            BlockEntity entity = level.getBlockEntity(pos);
//            if (entity instanceof SignBlockEntity sign && !sign.isWaxed()) return;
//            Direction direction = state.getValue(WallSignBlock.FACING);
//            BlockPos blockPos = pos.relative(direction, -1);
//            BlockState blockState = level.getBlockState(blockPos);
//            if (blockState.getBlock() instanceof WallSignBlock) return;
//            BlockHitResult hitResult = new BlockHitResult(Vec3.atCenterOf(blockPos), direction, blockPos, false);
//            blockState.use(level, player, hand, hitResult);
//            cir.setReturnValue(InteractionResult.SUCCESS);
//        }
//    }
}
