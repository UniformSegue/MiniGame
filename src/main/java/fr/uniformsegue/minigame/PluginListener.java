package fr.uniformsegue.minigame;

import fr.uniformsegue.minigame.arenaoneshot.game.GameOneShot;
import fr.uniformsegue.minigame.arenaoneshot.game.OneShot;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;

public class PluginListener implements Listener {

    MiniGame main;


     public PluginListener(MiniGame main) {
        this.main = main;

    }

    @EventHandler
    public void onMovePlayer(PlayerMoveEvent event){

        Player player = event.getPlayer();
        if(main.game.gamestart){

            if(main.game.gameOnStart.equalsIgnoreCase(GameList.ONESHOT)) {

                if (player.getLocation().getY() <= OneShot.arenaOneShotCoords[1].y || player.getLocation().getY() >= OneShot.arenaOneShotCoords[0].y || player.getLocation().getX() <= OneShot.arenaOneShotCoords[1].x || player.getLocation().getX() >= OneShot.arenaOneShotCoords[0].x || player.getLocation().getZ() <= OneShot.arenaOneShotCoords[1].z || player.getLocation().getZ() >= OneShot.arenaOneShotCoords[0].z) {
                    player.teleport(new Location(Bukkit.getWorld("world"), OneShot.arenaOneShotCoordsMid.x, OneShot.arenaOneShotCoordsMid.y, OneShot.arenaOneShotCoordsMid.z));
                }
            }
        }
    }


    @EventHandler
    public void onDeathPlayer(PlayerDeathEvent event){
        Player player = event.getPlayer();
        if(main.game.gamestart) {

            if (main.game.gameOnStart.equalsIgnoreCase(GameList.ONESHOT)) {

                event.setCancelled(true);
                player.setGameMode(GameMode.SPECTATOR);
                player.sendTitle("§4You dead","",10, 70, 10);
                int nb_player_alive = 0;
                Player playerWin = null;
                for(Player p : Bukkit.getOnlinePlayers()){
                    if(p.getGameMode() == GameMode.ADVENTURE){
                        nb_player_alive++;
                        playerWin = p;
                    }
                }
                if(nb_player_alive < 2){
                    GameOneShot.end(nb_player_alive,playerWin);
                }

            }
        }

    }

}

