package org.cubit.moretnt.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.cubit.moretnt.moretnt.MoreTNTManager;

public class MoreTNTEvent implements Listener {

    private MoreTNTManager moreTNTManager;

    public MoreTNTEvent(MoreTNTManager moreTNTManager) {
        this.moreTNTManager = moreTNTManager;
    }

    @EventHandler
    public void onMoreTNT(BlockPlaceEvent blockPlaceEvent) {
        Player player = blockPlaceEvent.getPlayer();
        String name = player.getInventory().getItemInMainHand().getItemMeta().getLore().get(1);
        name = name.replace("§fMore TNT: " , "");
        if (this.moreTNTManager.getMoreTNT(name) != null) {
            this.moreTNTManager.getMoreTNT(name).onTNT(blockPlaceEvent.getBlockPlaced().getLocation());
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
            player.updateInventory();
        }
    }


}
