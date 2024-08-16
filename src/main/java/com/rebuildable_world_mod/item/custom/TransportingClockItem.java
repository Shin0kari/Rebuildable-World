package com.rebuildable_world_mod.item.custom;

import java.util.List;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.client.item.TooltipContext;
// import net.minecraft.enchantment.EnchantmentHelper;
// import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
// import net.minecraft.sound.SoundCategory;
// import net.minecraft.sound.SoundEvent;
// import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

public class TransportingClockItem extends Item {
    public TransportingClockItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);

        // Проверка на наличие прочности
        if (!isUsable(itemStack)) {
            return TypedActionResult.fail(itemStack);
        } else {
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.consume(itemStack);
        }
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.CROSSBOW;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.GOLD_NUGGET);
    }

    public static boolean isUsable(ItemStack stack) {
        return stack.getDamage() < stack.getMaxDamage() - 1;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        int i = this.getMaxUseTime(stack) - remainingUseTicks;
        float f = getChargeProgress(i, stack);

        if (f >= 1.0f && user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;

            if (!world.isClient()) {
                stack.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));

                Vec3d currentPos = player.getPos();
                Vec3d targetPos;

                // Проверка на измерение, если человек в Nether, то его координаты умножаются на 8, иначе делятся на 8
                if (world.getRegistryKey() == World.NETHER) {
                    targetPos = new Vec3d(currentPos.x * 8, currentPos.y, currentPos.z * 8);
                } else {
                    targetPos = new Vec3d(currentPos.x / 8, currentPos.y, currentPos.z / 8);
                }

                TeleportTarget teleportTarget = new TeleportTarget(targetPos, Vec3d.ZERO, player.getYaw(), player.getPitch());

                // Проверка на текущее измерение, если Nether, то телепортировать в Overworld, иначе в Nether
                ServerWorld targetWorld;
                if (world.getRegistryKey() == World.NETHER) {
                    targetWorld = player.getServer().getWorld(World.OVERWORLD);
                } else {
                    targetWorld = player.getServer().getWorld(World.NETHER);
                }

                if (targetWorld != null) {
                    FabricDimensions.teleport(player, targetWorld, teleportTarget);
                }
            }
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    public static int getChargeTime(ItemStack stack) {
        // int i = EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, stack);
        int i = 0;
        return i == 0 ? 25 : 25 - 5 * i;
    }

    private static float getChargeProgress(int useTicks, ItemStack stack) {
        float f = (float) useTicks / (float) getChargeTime(stack);
        return f > 1.0f ? 1.0f : f;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.rebuildable_world_mod.transporting_clock.tooltip").formatted(Formatting.AQUA));
        super.appendTooltip(stack, world, tooltip, context);
    }

    // Для проигрывания звуков при зажатии часов
    // @Override
    // public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
    //     if (!world.isClient) {
    //         int i = EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, stack);
    //         float f = (float) (stack.getMaxUseTime() - remainingUseTicks) / (float) getChargeTime(stack);
            
    //         // if (f < 0.2f) {
    //         //     this.charged = false;
    //         //     this.loaded = false;
    //         // }
    //         // if (f >= 0.2f && !this.charged) {
    //         //     this.charged = true;
    //         //     world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent, SoundCategory.PLAYERS, 0.5f, 1.0f);
    //         // }
    //         // if (f >= 0.5f && soundEvent2 != null && !this.loaded) {
    //         //     this.loaded = true;
    //         //     world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent2, SoundCategory.PLAYERS, 0.5f, 1.0f);
    //         // }
    //     }
    // }

    // private SoundEvent getQuickChargeSound(int level) {
    //     switch (level) {
    //         case 1:
    //             return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_1;
    //         case 2:
    //             return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_2;
    //         case 3:
    //             return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_3;
    //         default:
    //             return SoundEvents.ITEM_CROSSBOW_LOADING_START;
    //     }
    // }
}