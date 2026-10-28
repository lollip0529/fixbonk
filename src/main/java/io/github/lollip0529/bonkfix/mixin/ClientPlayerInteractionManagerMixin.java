package io.github.lollip0529.bonkfix.mixin;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    @Shadow @Final private Object2ObjectLinkedOpenHashMap<?, ?> unacknowledgedPlayerActions;

    @Inject(method = "createPlayer", at = @At("HEAD"))
    private void bonkfix$forgetOldPositions(CallbackInfoReturnable<?> cir) {
        unacknowledgedPlayerActions.clear();
    }
}
