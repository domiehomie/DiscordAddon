package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.StickerFormatType;

public class Sticker {
    String id;
    String pack_id;
    String name;
    String description;
    String tags;
    String asset;
    StickerFormatType format_type;

    public String getId() {
        return id;
    }

    public String getPack_id() {
        return pack_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTags() {
        return tags;
    }

    public String getAsset() {
        return asset;
    }

    public StickerFormatType getFormat_type() {
        return format_type;
    }

    @Override
    public String toString() {
        return "Sticker{" + "id='" + id + '\'' + ", pack_id='" + pack_id + '\'' + ", name='" + name + '\''
                + ", description='" + description + '\'' + ", tags='" + tags + '\'' + ", asset='" + asset + '\''
                + ", format_type=" + format_type + '}';
    }
}
