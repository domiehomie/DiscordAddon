package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.util.Arrays;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.SlashCommandHandler.OptionType;

public class ApplicationCommandInteractionDataOption {
    String name;
    OptionType type;
    ApplicationCommandInteractionDataOption[] options;
    Object value;

    public String getName() {
        return name;
    }

    public OptionType getType() {
        return type;
    }

    public ApplicationCommandInteractionDataOption[] getOptions() {
        return options;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ApplicationCommandInteractionDataOption{" + "name='" + name + '\'' + ", type=" + type + ", options="
                + Arrays.toString(options) + ", value=" + value + '}';
    }
}
