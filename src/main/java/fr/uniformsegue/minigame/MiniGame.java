package fr.uniformsegue.minigame;

import fr.uniformsegue.minigame.arenaoneshot.game.CommandStartOneShot;
import fr.uniformsegue.minigame.arenaoneshot.game.CommandStopOneShot;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MiniGame extends JavaPlugin {

    public Game game;
    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("§aPlugin MiniGame Ready");

        game = new Game();
        getServer().getPluginManager().registerEvents(new PluginListener(this), this);
        getCommand("startOneShot").setExecutor(new CommandStartOneShot(this));
        getCommand("stopOneShot").setExecutor(new CommandStopOneShot(this));




    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
