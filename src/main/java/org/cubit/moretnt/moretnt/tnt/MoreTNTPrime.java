package org.cubit.moretnt.moretnt.tnt;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Ocelot;
import org.cubit.moretnt.moretnt.MoreTNT;

public class MoreTNTPrime implements MoreTNT {
    @Override
    public void onTNT(Location location) {
        World world = location.getWorld();
        for (int i = 0; i < 20; i ++) {
            world.spawn(location , Ocelot.class);
        }
    }
}
