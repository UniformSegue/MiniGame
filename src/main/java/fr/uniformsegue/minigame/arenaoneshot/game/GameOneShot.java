package fr.uniformsegue.minigame.arenaoneshot.game;

import fr.uniformsegue.minigame.GameList;
import fr.uniformsegue.minigame.MiniGame;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GameOneShot {

    static MiniGame main;
    public GameOneShot(MiniGame main){

        this.main = main;

    }

    public void start(){

        main.game.gamestart = true;
        main.game.gameOnStart = GameList.ONESHOT;
        Bukkit.getConsoleSender().sendMessage("GameOneShotStart");
        TimerTaskStart startTimer = new TimerTaskStart();
        startTimer.runTaskTimer(main,0 ,20);
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.setInvulnerable(true);
            p.setInvisible(true);
        }
        tpAllPlayer();
        setGameMode();
    }

    public static void stop(){
        main.game.gamestart = false;
        main.game.gameOnStart = null;
        Bukkit.getConsoleSender().sendMessage("GameOneShotStop");
        clearEffectPlayer();


    }

    public static void end(int nb_player,Player player_win){
        if(nb_player == 0){

            for(Player p : Bukkit.getOnlinePlayers()){
                p.sendTitle("§4Egaliter","§aGame Over");
            }

        }else if(nb_player == 1){
            for(Player p : Bukkit.getOnlinePlayers()){
                p.sendTitle("§a"+ player_win.getName() + " §4win","§aSucer le svp");
            }

        }
        stop();

    }

    public static void giveEffectPlayer(){

        for(Player p : Bukkit.getOnlinePlayers()) {

            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,9999999,255,true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,9999999,255,true));

        }
    }
    public static void clearEffectPlayer(){

        for(Player p : Bukkit.getOnlinePlayers()) {
            p.clearActivePotionEffects();
        }
    }

    public static void setGameMode(){

        for(Player p : Bukkit.getOnlinePlayers()) {
            p.setGameMode(GameMode.ADVENTURE);
        }
    }

    public static void tpAllPlayer(){
        for(Player p : Bukkit.getOnlinePlayers()) {

            p.teleport(new Location(Bukkit.getWorld("world"),OneShot.arenaOneShotCoordsMid.x,OneShot.arenaOneShotCoordsMid.y,OneShot.arenaOneShotCoordsMid.z));

        }
    }

    public static void startPlayer(){

        giveEffectPlayer();
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.setInvulnerable(false);
            p.setInvisible(false);
        }

    }
}
