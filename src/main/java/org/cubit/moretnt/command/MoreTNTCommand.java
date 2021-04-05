package org.cubit.moretnt.command;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.cubit.moretnt.moretnt.MoreTNTManager;
import skywolf46.commandannotation.annotations.legacy.MinecraftCommand;
import skywolf46.commandannotation.data.command.CommandArgument;

import java.util.Arrays;

public class MoreTNTCommand {

    private MoreTNTManager moreTNTManager;

    public MoreTNTCommand(MoreTNTManager moreTNTManager) {
        this.moreTNTManager = moreTNTManager;
    }

    @MinecraftCommand("/tnt")
    public void TNTCommand(Player player , CommandArgument args){
        if (args.length() < 1) {
            player.sendMessage("§fMore TNT: TNT 기능을 추가하다");
            player.sendMessage("§f./More TNT [TNT SKILL]");
            return;
        }
        if (this.moreTNTManager.getMoreTNT(args.get(0)) == null) {
            player.sendMessage("§fMore TNT: No TNT Skill Name");
            return;
        }
        if (player.getInventory().getItemInMainHand() == null || player.getInventory().getItemInMainHand().getType() != Material.TNT) {
            player.sendMessage("§fMore TNT: Player MainHand No TNT");
            return;
        }
        ItemStack itemStack = new ItemStack(Material.TNT);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(Arrays.asList("" , "§fMore TNT: " + args.get(0)));
        itemStack.setItemMeta(itemMeta);
        player.getInventory().setItemInMainHand(itemStack);

    }



}
