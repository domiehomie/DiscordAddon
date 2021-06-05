package live.mufin.DiscordAddon;

import club.minnced.discord.webhook.WebhookClient;
import live.mufin.DiscordAddon.commands.discord.*;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Initiater;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.SlashCommandHandler;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.SlashCommandHandler.CommandBuilder;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.SlashCommandHandler.Option;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.SlashCommandHandler.OptionBuilder;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.SlashCommandHandler.OptionType;
import live.mufin.DiscordAddon.commands.spigot.*;
import live.mufin.DiscordAddon.events.discord.DiscordMessageEvent;
import live.mufin.DiscordAddon.events.spigot.*;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

public class Main extends JavaPlugin {

    public static JDABuilder builder;
    public static JDA jda;
    public static Initiater initiater;
    public static WebhookClient client;
    public static String botKey;

    public static String prefix;
    public static String mufinurl = null;
    public static String errorurl = "https://discordemoji.com/assets/emoji/5316_Error_512x512_by_DW.png";

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        botKey = this.getConfig().getString("bot.token");
        prefix = this.getConfig().getString("bot.prefix");
        client = WebhookClient.withUrl(this.getConfig().getString("bot.webhook-url"));
        initiater = new Initiater();

        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&8[&9DA&8] =============================================="));
        sender.sendMessage(
                ChatColor.translateAlternateColorCodes('&', "&8[&9DA&8] &9DiscordAddons &7v&91.0 &7by &9muffintwt&7."));
        if (this.createBot())
            sender.sendMessage(
                    ChatColor.translateAlternateColorCodes('&', "&8[&9DA&8] &9Discord &7connection &aSUCCESS&7."));
        else
            sender.sendMessage(
                    ChatColor.translateAlternateColorCodes('&', "&8[&9DA&8] &9Discord &7connection &cFAILED&7."));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&8[&9DA&8] =============================================="));

        this.registerEvents();
        this.registerCommands();

    }

    @Override
    public void onDisable() {
        if (this.getConfig().getBoolean("features.server-stop"))
            this.sendStopMessage();
        if (client != null)
            client.close();
        jda.shutdown();
    }

    public boolean createBot() {
        builder = JDABuilder.createDefault(botKey);
        String ip = this.getServer().getIp();
        builder.setActivity(Activity.watching(ip.isEmpty() ? "Your server!" : ip));
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        builder.setRawEventsEnabled(true);
        try {
            jda = builder.build();
            jda.awaitReady();
            if (this.getConfig().getBoolean("features.server-start"))
                this.sendStartMessage();
            CommandRegisterer.registerCommands();
            return true;
        } catch (LoginException | InterruptedException e) {
            return false;
        }
    }

    public void registerEvents() {
        jda.addEventListener(new DiscordMessageEvent(this));
        jda.addEventListener(new Initiater());

        Bukkit.getPluginManager().registerEvents(new SpigotMessageEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new DeathEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new LeaveEvent(this), this);
    }

    public void registerCommands() {
        this.getCommand("togglediscord").setExecutor(new ToggleDiscordCommand(this));
        this.getCommand("discordreload").setExecutor(new DiscordReloadCommand(this));
        this.getCommand("discorddm").setExecutor(new DiscordDMCommand(this));
        this.getCommand("discorddm").setTabCompleter(new DiscordDMTabComplete());

        initiater.registerListener(new MessageCommand(this));
        initiater.registerListener(new InfoCommand());
        initiater.registerListener(new SendAsConsoleCommand(this));
        initiater.registerListener(new HelpCommand());
        initiater.registerListener(new ListCommand());
    }

    public void sendStartMessage() {
        TextChannel channel = jda.getTextChannelById(this.getConfig().getString("bot.channel"));
        EmbedBuilder online = new EmbedBuilder().setTitle("✅ Server online.")
                .setDescription("IP: ```java\n" + Bukkit.getServer().getIp() + "```").setColor(0x009432)
                .setFooter("mufin.live", mufinurl);

        channel.sendMessage(online.build()).complete();
    }

    public void sendStopMessage() {
        TextChannel channel = jda.getTextChannelById(this.getConfig().getString("bot.channel"));
        EmbedBuilder offline = new EmbedBuilder().setTitle("❎ Server offline.").setColor(0xEA2027)
                .setFooter("mufin.live", mufinurl);
        channel.sendMessage(offline.build()).complete();
    }

}
