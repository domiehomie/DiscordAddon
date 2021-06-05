package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds;

public class EmbedField {
    String name;
    String value;
    boolean inline;

    public EmbedField(String name, String value, boolean inline) {
        this.name = name;
        this.value = value;
        this.inline = inline;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public boolean isInline() {
        return inline;
    }

    @Override
    public String toString() {
        return "EmbedField{" + "name='" + name + '\'' + ", value='" + value + '\'' + ", inline=" + inline + '}';
    }
}
