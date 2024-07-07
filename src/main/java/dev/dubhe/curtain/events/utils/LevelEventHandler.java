package dev.dubhe.curtain.events.utils;

import dev.dubhe.curtain.Curtain;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import org.jetbrains.annotations.NotNull;

public class LevelEventHandler {
    @SubscribeEvent
    public void onLevelSave(@NotNull LevelEvent.Save event) {
        Curtain.rules.saveToFile();
    }
}
