package tw.ch1ck3n.welcometitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tw.ch1ck3n.welcometitle.PluginSettings;
import tw.ch1ck3n.welcometitle.WelcomeTitle;

public class WTReloadCommand implements CommandExecutor {

    public final String message = WelcomeTitle.INSTANCE.prefix + " Config reloaded!";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        WelcomeTitle PWT = WelcomeTitle.INSTANCE;
        if (args.length == 0) {
            PWT.reloadConfig();
            PWT.settings = new PluginSettings();
            if (sender instanceof Player) {
                sender.sendMessage(message);
            } else {
                Bukkit.getConsoleSender().sendMessage(message);
            }
        }

        return true;
    }
}
