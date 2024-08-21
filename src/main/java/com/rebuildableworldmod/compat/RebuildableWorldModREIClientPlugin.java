package com.rebuildableworldmod.compat;

import com.rebuildableworldmod.block.ModBlocks;
import com.rebuildableworldmod.recipe.ClockChargeRecipe;
import com.rebuildableworldmod.screen.ClockChargeScreen;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class RebuildableWorldModREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ClockChargeCategory());

        registry.addWorkstations(ClockChargeCategory.CLOCK_CHARGE, EntryStacks.of(ModBlocks.CLOCK_CHARGE_STATION));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(
            ClockChargeRecipe.class, 
            ClockChargeRecipe.Type.INSTANCE, 
            ClockChargeDisplay::new);

    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), 
            ClockChargeScreen.class, 
            ClockChargeCategory.CLOCK_CHARGE);
    }
}
