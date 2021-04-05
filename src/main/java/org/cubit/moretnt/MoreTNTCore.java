package org.cubit.moretnt;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.cubit.moretnt.command.MoreTNTCommand;
import org.cubit.moretnt.event.MoreTNTEvent;
import org.cubit.moretnt.moretnt.MoreTNTManager;
import org.cubit.moretnt.moretnt.tnt.MoreTNTLightning;
import org.cubit.moretnt.moretnt.tnt.MoreTNTNuke;
import org.cubit.moretnt.moretnt.tnt.MoreTNTPrime;
import skywolf46.commandannotation.CommandAnnotation;

public class MoreTNTCore extends JavaPlugin {

    private MoreTNTManager moreTNTManager;
    private MoreTNTEvent moreTNTEvent;

    @Override
    public void onEnable() {
        this.moreTNTManager = new MoreTNTManager();
        this.moreTNTEvent = new MoreTNTEvent(this.moreTNTManager);

        this.moreTNTManager.register("Nuke" , new MoreTNTNuke());
        this.moreTNTManager.register("Lightning" , new MoreTNTLightning());
        this.moreTNTManager.register("Ocelot" , new MoreTNTPrime());

        Bukkit.getPluginManager().registerEvents(this.moreTNTEvent , this);

        CommandAnnotation.init(this);
        CommandAnnotation.registerCommandObject(new MoreTNTCommand(this.moreTNTManager));
    }
}
