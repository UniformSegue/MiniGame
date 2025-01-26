package fr.uniformsegue.minigame.arenaoneshot.game;

import fr.uniformsegue.minigame.MiniGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStopOneShot implements CommandExecutor {
    private MiniGame main;
    public CommandStopOneShot(MiniGame main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(sender instanceof Player) {

            GameOneShot gameOneShot = new GameOneShot(main);
            gameOneShot.stop();


        }
        return false;
    }
}