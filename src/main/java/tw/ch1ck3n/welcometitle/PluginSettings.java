package tw.ch1ck3n.welcometitle;

import java.util.List;

public class PluginSettings {

    public final int mode;

    public final long runAfter;

    public final String title;

    public final String subtitle;

    public final int titleFadeIn;

    public final int titleStay;

    public final int titleFadeOut;

    public final List<String> players;

    public PluginSettings() {
        this.mode = WelcomeTitle.INSTANCE.getConfig().getInt("mode");
        this.runAfter = WelcomeTitle.INSTANCE.getConfig().getLong("run-after");
        this.title = WelcomeTitle.INSTANCE.getConfig().getString("title").replaceAll("&", "§");
        this.subtitle = WelcomeTitle.INSTANCE.getConfig().getString("subtitle").replaceAll("&", "§");
        this.titleFadeIn = WelcomeTitle.INSTANCE.getConfig().getInt("title-fade-in");
        this.titleStay = WelcomeTitle.INSTANCE.getConfig().getInt("title-stay");
        this.titleFadeOut = WelcomeTitle.INSTANCE.getConfig().getInt("title-fade-out");
        this.players = WelcomeTitle.INSTANCE.getConfig().getStringList("players");
    }
}
