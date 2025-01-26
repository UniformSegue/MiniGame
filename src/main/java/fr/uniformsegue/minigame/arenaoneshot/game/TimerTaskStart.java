package fr.uniformsegue.minigame.arenaoneshot.game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class TimerTaskStart extends BukkitRunnable {



    private int timer = 10;
    @Override
    public void run() {

        if(timer == 10){

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle("§c§lGame Start ", "§a§l" + timer + "s", 10, 70, 10);
            }
            Bukkit.broadcastMessage("§c§lGame Start " + "§a§l" + timer+ "s");

        }else if(timer == 5){

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle("§c§lGame Start ", "§a§l" + timer + "s", 10, 70, 10);
            }
            Bukkit.broadcastMessage("§c§lGame Start " + "§a§l" + timer+ "s");

        }else if(timer == 4){

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle("§c§lGame Start ", "§a§l" + timer + "s", 10, 70, 10);
            }
            Bukkit.broadcastMessage("§c§lGame Start " + "§a§l" + timer+ "s");

        }else if(timer == 3){

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle("§c§lGame Start ", "§a§l" + timer + "s", 10, 70, 10);
            }
            Bukkit.broadcastMessage("§c§lGame Start " + "§a§l" + timer+ "s");

        }else if(timer == 2){

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle("§c§lGame Start ", "§a§l" + timer + "s", 10, 70, 10);
            }
            Bukkit.broadcastMessage("§c§lGame Start " + "§a§l" + timer+ "s");

        }else if(timer == 1){

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle("§c§lGame Start ", "§a§l" + timer + "s", 10, 70, 10);
            }
            Bukkit.broadcastMessage("§c§lGame Start " + "§a§l" + timer+ "s");

        }

        if(timer == 0){

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle("§c§lGame Start", "", 10, 70, 10);
            }
            Bukkit.broadcastMessage("§c§lGame Start ");
            GameOneShot.startPlayer();

        }
        timer--;
    }

}
