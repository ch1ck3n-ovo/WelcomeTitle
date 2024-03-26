package tw.ch1ck3n.welcometitle.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tw.ch1ck3n.welcometitle.WelcomeTitle;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        WelcomeTitle PWT = WelcomeTitle.INSTANCE;
        if (PWT.settings.mode == 0) {
            PWT.send();
        } else if(PWT.settings.mode == 1) {
            Player p = e.getPlayer();
            if (PWT.settings.players.contains(p.getName())) {
                PWT.send();
            }
        }
    }
}