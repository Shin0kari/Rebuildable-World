package com.rebuildableworldmod.world.biome;

import com.rebuildableworldmod.RebuildableWorld;
import com.rebuildableworldmod.world.biome.surface.ModMaterialRules;

import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;
import terrablender.api.SurfaceRuleManager.RuleCategory;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModNetherRegion(new Identifier(RebuildableWorld.MOD_ID, "nether"), 4));

        SurfaceRuleManager.addSurfaceRules(
            SurfaceRuleManager.RuleCategory.NETHER, 
            RebuildableWorld.MOD_ID, 
            ModMaterialRules.makeRules());
    }
}
