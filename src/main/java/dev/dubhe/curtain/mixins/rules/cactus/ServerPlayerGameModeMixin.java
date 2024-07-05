package dev.dubhe.curtain.mixins.rules.cactus;

import net.minecraft.server.level.ServerPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerPlayerGameMode.class)
public abstract class ServerPlayerGameModeMixin {
//    @Redirect(
//            method = "useItemOn",
//            at = @At(
//                    value = "INVOKE",
//                    target = "Lnet/minecraft/world/level/block/state/BlockState;use(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/InteractionResult;"
//            )
//    )
//    private InteractionResult activateWithOptionalCactus(BlockState blockState, Level world, Player player, InteractionHand hand, BlockHitResult result) {
//        boolean flipped = BlockRotator.flipBlockWithCactus(blockState, world, player, hand, result);
//        if (flipped) {
//            return InteractionResult.SUCCESS;
//        }
//        return blockState.use(world, player, hand, result);
//    }
}
