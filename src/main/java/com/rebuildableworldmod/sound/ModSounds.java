package com.rebuildableworldmod.sound;

import com.rebuildableworldmod.RebuildableWorld;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
// import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {


    public static final SoundEvent VILLAGER_TALK_MOD = registerSoundEvent("villager_talk_mod");
    public static final SoundEvent VILLAGER_TALK_TRADES_MOD = registerSoundEvent("villager_talk_trades_mod");

    public static final SoundEvent BAR_BRAWL = registerSoundEvent("bar_brawl");

 private static SoundEvent registerSoundEvent(String name) {
    Identifier id = new Identifier(RebuildableWorld.MOD_ID, name);
    return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
 }

    public static void registerSounds() {
        RebuildableWorld.LOGGER.info("Registering Sounds for " + RebuildableWorld.MOD_ID);
    }
}