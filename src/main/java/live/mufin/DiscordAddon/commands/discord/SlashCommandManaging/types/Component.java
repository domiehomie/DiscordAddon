package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.ButtonStyle;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.ComponentType;

public class Component {
    ComponentType type;
    ButtonStyle style;
    String label;
    Emoji emoji;
    String custom_id;
    String url;
    boolean disabled;

    public ComponentType getType() {
        return type;
    }

    public ButtonStyle getStyle() {
        return style;
    }

    public String getLabel() {
        return label;
    }

    public Emoji getEmoji() {
        return emoji;
    }

    public String getCustom_id() {
        return custom_id;
    }

    public String getUrl() {
        return url;
    }

    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public String toString() {
        return "Component{" + "type=" + type + ", style=" + style + ", label='" + label + '\'' + ", emoji=" + emoji
                + ", custom_id='" + custom_id + '\'' + ", url='" + url + '\'' + ", disabled=" + disabled + '}';
    }
}
