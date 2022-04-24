package adris.altoclef.tasks.misc;

import adris.altoclef.AltoClef;
import adris.altoclef.TaskCatalogue;
import adris.altoclef.tasks.resources.CollectFoodTask;
import adris.altoclef.tasksystem.Task;
import adris.altoclef.util.helpers.BaritoneHelper;
import adris.altoclef.util.helpers.StorageHelper;
import baritone.Baritone;
import net.minecraft.item.Items;

public class Highway extends Task {

    @Override
    protected void onStart(AltoClef mod) {

    }

    @Override
    protected Task onTick(AltoClef mod) {
        if (!mod.getItemStorage().hasItem(Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_HELMET, Items.DIAMOND_PICKAXE, Items.DIAMOND)) {
            return TaskCatalogue.getItemTask("diamond", 40);
        }
        if (!mod.getItemStorage().hasItem(Items.DIAMOND_CHESTPLATE)) {
            return TaskCatalogue.getItemTask("diamond_chestplate", 1);
        }
        if (!mod.getItemStorage().hasItem(Items.DIAMOND_HELMET)) {
            return TaskCatalogue.getItemTask("diamond_helmet", 1);
        }
        if (!mod.getItemStorage().hasItem(Items.DIAMOND_LEGGINGS)) {
            return TaskCatalogue.getItemTask("diamond_leggings", 1);
        }
        if (!mod.getItemStorage().hasItem(Items.DIAMOND_BOOTS)) {
            return TaskCatalogue.getItemTask("diamond_boots", 1);
        }
        if (!mod.getItemStorage().hasItem(Items.DIAMOND_PICKAXE)) {
            return TaskCatalogue.getItemTask("diamond_pickaxe", 5);
        }
        if (!mod.getItemStorage().hasItem(Items.OBSIDIAN)) {
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
