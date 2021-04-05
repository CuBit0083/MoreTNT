package org.cubit.moretnt.moretnt.tnt;

import org.bukkit.Location;
import org.bukkit.World;
import org.cubit.moretnt.moretnt.MoreTNT;

public class MoreTNTLightning implements MoreTNT {


    @Override
    public void onTNT(Location location) {
        World world = location.getWorld();
        world.strikeLightning(location);
    }
}
