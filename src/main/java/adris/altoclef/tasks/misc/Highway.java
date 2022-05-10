package adris.altoclef.tasks.misc;

import adris.altoclef.AltoClef;
import adris.altoclef.Debug;
import adris.altoclef.TaskCatalogue;
import adris.altoclef.tasks.resources.CollectFoodTask;
import adris.altoclef.tasksystem.Task;
import adris.altoclef.trackers.storage.ItemStorageTracker;
import adris.altoclef.util.helpers.BaritoneHelper;
import adris.altoclef.util.helpers.ItemHelper;
import adris.altoclef.util.helpers.StorageHelper;
import adris.altoclef.util.helpers.WorldHelper;
import baritone.Baritone;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import adris.altoclef.tasks.misc.EquipArmorTask;

public class Highway extends Task {


    int NeededDiamonds = 41;
    boolean hasArmor = false;
    @Override
    protected void onStart(AltoClef mod) {
        Debug.logMessage("Task made by BloodyNoah3#2794 discord.gg/meg");
    }
private Task _armorTask;
    @Override
    protected Task onTick(AltoClef mod) {
        double xCoord = mod.getPlayer().getX();
        double zCoord = mod.getPlayer().getX();
        String Dimension = String.valueOf(WorldHelper.getCurrentDimension());
        Debug.logMessage(Dimension);
        if (xCoord < 50_000 || zCoord < 50_000 && Dimension != "NETHER") {
            if(!mod.getItemStorage().hasItem(Items.DIAMOND_CHESTPLATE, Items.DIAMOND_HELMET, Items.DIAMOND_BOOTS, Items.DIAMOND_LEGGINGS) && !StorageHelper.isArmorEquippedAll(mod, ItemHelper.DIAMOND_ARMORS)) {
                Debug.logMessage("Im within 50k of spawn");
            }
        }
        if (!StorageHelper.isArmorEquippedAll(mod, ItemHelper.DIAMOND_ARMORS)) {
            _armorTask = new EquipArmorTask(ItemHelper.DIAMOND_ARMORS);
            return _armorTask;
        }
        if (mod.getItemStorage().getItemCount(Items.DIAMOND) <= NeededDiamonds && !mod.getItemStorage().hasItem(Items.DIAMOND_CHESTPLATE, Items.DIAMOND_HELMET, Items.DIAMOND_BOOTS, Items.DIAMOND_LEGGINGS) && !StorageHelper.isArmorEquippedAll(mod, ItemHelper.DIAMOND_ARMORS)) {
            setDebugState("Mining for Diamonds!");
            return TaskCatalogue.getItemTask("diamond", NeededDiamonds);
        }
        if (!mod.getItemStorage().hasItem(Items.DIAMOND_CHESTPLATE) && !StorageHelper.isArmorEquippedAll(mod, ItemHelper.DIAMOND_ARMORS)) {
            return TaskCatalogue.getItemTask("diamond_chestplate", 1);
        }
        if (!mod.getItemStorage().hasItem(Items.DIAMOND_HELMET) && !StorageHelper.isArmorEquippedAll(mod, ItemHelper.DIAMOND_ARMORS)) {
            return TaskCatalogue.getItemTask("diamond_helmet", 1);
        }
        if (!mod.getItemStorage().hasItem(Items.DIAMOND_LEGGINGS) && !StorageHelper.isArmorEquippedAll(mod, ItemHelper.DIAMOND_ARMORS)) {
            return TaskCatalogue.getItemTask("diamond_leggings", 1);
        }
        if (!mod.getItemStorage().hasItem(Items.DIAMOND_BOOTS) && !StorageHelper.isArmorEquippedAll(mod, ItemHelper.DIAMOND_ARMORS)) {
            return TaskCatalogue.getItemTask("diamond_boots", 1);
        }
        if (mod.getItemStorage().getItemCount(Items.DIAMOND_PICKAXE) < 5) {
            return TaskCatalogue.getItemTask("diamond_pickaxe", 5);
        }
        if (mod.getItemStorage().getItemCount(Items.OBSIDIAN) <= 63) {
            return TaskCatalogue.getItemTask("obsidian", 64);
        }
        if (StorageHelper.calculateInventoryFoodScore(mod) < 10) {
             new CollectFoodTask(220);
        }
        return null;
    }

    @Override
    protected void onStop(AltoClef mod, Task interruptTask) {

    }

    @Override
    protected boolean isEqual(Task other) {
        return false;
    }

    @Override
    protected String toDebugString() {
        return null;
    }
}
