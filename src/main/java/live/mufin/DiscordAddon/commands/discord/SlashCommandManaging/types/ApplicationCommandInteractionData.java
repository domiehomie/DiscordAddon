package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.util.Arrays;

public class ApplicationCommandInteractionData {
    String id;
    String name;
    ApplicationCommandInteractionDataResolved resolved;
    ApplicationCommandInteractionDataOption[] options;
    String custom_id;
    int component_type;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ApplicationCommandInteractionDataResolved getResolved() {
        return resolved;
    }

    public ApplicationCommandInteractionDataOption[] getOptions() {
        return options;
    }

    public String getCustom_id() {
        return custom_id;
    }

    public int getComponent_type() {
        return component_type;
    }

    @Override
    public String toString() {
        return "ApplicationCommandInteractionData{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", resolved="
                + resolved + ", options=" + Arrays.toString(options) + ", custom_id='" + custom_id + '\''
                + ", component_type=" + component_type + '}';
    }
}
