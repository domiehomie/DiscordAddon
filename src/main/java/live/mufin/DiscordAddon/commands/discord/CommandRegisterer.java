package live.mufin.DiscordAddon.commands.discord;

import java.util.ArrayList;
import java.util.List;

import live.mufin.DiscordAddon.Main;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.SlashCommandHandler;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.SlashCommandHandler.*;

public class CommandRegisterer {

        public static void registerCommands() {
                registerMessageCommand();
                registerInfoCommands();
                registerHelpCommand();
                registerSACCommand();
                registerListCommand();
        }

        public static void registerMessageCommand() {
                // Message Command
                OptionBuilder playerBuilder = new OptionBuilder().setName("player").setType(OptionType.STRING)
                                .setDescription("The player you want to" + "message.").setRequired(true);
                OptionBuilder messageBuilder = new OptionBuilder().setName("message").setType(OptionType.STRING)
                                .setRequired(true).setDescription("The message you want to send.");

                List<Option> options = new ArrayList<Option>();
                options.add(playerBuilder.build());
                options.add(messageBuilder.build());

                CommandBuilder msgBuilder = new CommandBuilder().setName("message")
                                .setDescription("Send a direct message to a player on the server!").setOptions(options);

                if (!SlashCommandHandler.commandExists("message", Main.botKey, Main.jda.getSelfUser().getId()))
                        SlashCommandHandler.registerCommand(msgBuilder.build(), Main.botKey,
                                        Main.jda.getSelfUser().getId());
        }

        public static void registerInfoCommands() {
                List<Option> options = new ArrayList<Option>();

                options.add(new OptionBuilder().setName("player").setType(OptionType.SUB_COMMAND)
                                .setDescription("Info about a player.")
                                .addOption(new OptionBuilder().setName("player").setType(OptionType.STRING)
                                                .setDescription("The target player.").build())
                                .build());

                options.add(new OptionBuilder().setName("plugin").setType(OptionType.SUB_COMMAND)
                                .setDescription("Info about the plugin.").build());
                options.add(new OptionBuilder().setName("bot").setType(OptionType.SUB_COMMAND)
                                .setDescription("Info about the bot.").build());

                Command cmd = new CommandBuilder().setName("info")
                                .setDescription("Information about a multitude of things.").setOptions(options).build();

                if (!SlashCommandHandler.commandExists("info", Main.botKey, Main.jda.getSelfUser().getId()))
                        SlashCommandHandler.registerCommand(cmd, Main.botKey, Main.jda.getSelfUser().getId());
        }

        public static void registerSACCommand() {
                List<Option> options = new ArrayList<Option>();
                options.add(new OptionBuilder().setName("command").setDescription("The command you want to dispatch.")
                                .setType(OptionType.STRING).build());

                Command cmd = new CommandBuilder().setName("sendasconsole")
                                .setDescription("Send a command as the console.").setOptions(options).build();

                if (!SlashCommandHandler.commandExists("sendasconsole", Main.botKey, Main.jda.getSelfUser().getId()))
                        SlashCommandHandler.registerCommand(cmd, Main.botKey, Main.jda.getSelfUser().getId());
        }

        public static void registerHelpCommand() {
                List<Option> options = new ArrayList<Option>();
                options.add(new OptionBuilder().setName("command").setDescription("The command you want help about")
                                .setRequired(false).setType(OptionType.STRING).build());

                Command cmd = new CommandBuilder().setName("help").setDescription("Help command for DiscordAddon")
                                .setOptions(options).build();

                if (!SlashCommandHandler.commandExists("help", Main.botKey, Main.jda.getSelfUser().getId()))
                        SlashCommandHandler.registerCommand(cmd, Main.botKey, Main.jda.getSelfUser().getId());
        }

        public static void registerListCommand() {
                Command cmd = new CommandBuilder().setName("list")
                                .setDescription("Show a list of all players, with some information!").build();

                if (!SlashCommandHandler.commandExists("list", Main.botKey, Main.jda.getSelfUser().getId()))
                        SlashCommandHandler.registerCommand(cmd, Main.botKey, Main.jda.getSelfUser().getId());
        }

}
