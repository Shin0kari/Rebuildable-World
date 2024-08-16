package com.rebuildable_world_mod.screen;

import com.rebuildable_world_mod.RebuildableWorld;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {

    public static final ScreenHandlerType<ClockChargeScreenHandler> CLOCK_CHARGE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(RebuildableWorld.MOD_ID, "clock_charge"),
                new ExtendedScreenHandlerType<>(ClockChargeScreenHandler::new));

    public static void registerScreenHandlers() {
        RebuildableWorld.LOGGER.info("Registering Screen Handlers for " + RebuildableWorld.MOD_ID);
    }

}
