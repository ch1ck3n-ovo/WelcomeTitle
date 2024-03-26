package tw.ch1ck3n.welcometitle;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import tw.ch1ck3n.welcometitle.commands.WTReloadCommand;
import tw.ch1ck3n.welcometitle.commands.WTTestCommand;
import tw.ch1ck3n.welcometitle.listeners.PlayerJoinListener;

public final class WelcomeTitle extends JavaPlugin {

    public static WelcomeTitle INSTANCE;

    public String prefix = "§7[§aWelcomeTitle§7]§r";

    public PluginSettings settings;

    @Override
    public void onEnable() {
        INSTANCE = this;

        this.saveDefaultConfig();
        this.settings = new PluginSettings();

        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getCommand("wtreload").setExecutor(new WTReloadCommand());
        this.getCommand("wttest").setExecutor(new WTTestCommand());
    }

    public void send() {
        WelcomeTitle PWT = WelcomeTitle.INSTANCE;
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p: Bukkit.getOnlinePlayers()) {
                    p.sendTitle(
                            PWT.settings.title, PWT.settings.subtitle,
                            PWT.settings.titleFadeIn, PWT.settings.titleStay, PWT.settings.titleFadeOut
                    );
                }
            }
        }.runTaskLater(PWT, PWT.settings.runAfter);
    }

    public void test(Player p) {
        WelcomeTitle PWT = WelcomeTitle.INSTANCE;
        new BukkitRunnable() {
            @Override
            public void run() {
                p.sendTitle(
                        PWT.settings.title, PWT.settings.subtitle,
                        PWT.settings.titleFadeIn, PWT.settings.titleStay, PWT.settings.titleFadeOut
                );
            }
        }.runTaskLater(PWT, PWT.settings.runAfter);

    }
}
