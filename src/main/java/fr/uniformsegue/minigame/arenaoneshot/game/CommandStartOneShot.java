package fr.uniformsegue.minigame.arenaoneshot.game;

import fr.uniformsegue.minigame.MiniGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStartOneShot implements CommandExecutor {
    private MiniGame main;
    public CommandStartOneShot(MiniGame main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {
            GameOneShot gameOneShot = new GameOneShot(main);
            gameOneShot.start();

        }
        return false;
    }
}