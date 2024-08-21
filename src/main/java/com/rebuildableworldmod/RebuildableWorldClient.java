package com.rebuildableworldmod;

import com.rebuildableworldmod.block.entity.ModBlockEntities;
import com.rebuildableworldmod.block.entity.renderer.ClockChargeBlockEntityRendered;
import com.rebuildableworldmod.screen.ClockChargeScreen;
import com.rebuildableworldmod.screen.ModScreenHandlers;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class RebuildableWorldClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.CLOCK_CHARGE_SCREEN_HANDLER, ClockChargeScreen::new);

        BlockEntityRendererFactories.register(ModBlockEntities.CLOCK_CHARGE_STATION_BLOCK_ENTITY, ClockChargeBlockEntityRendered::new);
    }
}