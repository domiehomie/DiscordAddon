package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds;

import java.util.Arrays;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.EmbedType;

public class Embed {
    String title;
    EmbedType type;
    String description;
    String url;
    String timestamp;
    int color;
    EmbedFooter footer;
    EmbedImage image;
    EmbedThumbnail thumbnail;
    EmbedVideo video;
    EmbedProvider provider;
    EmbedAuthor author;
    EmbedField[] fields;

    public Embed(String title, EmbedType type, String description, String url, String timestamp, int color,
            EmbedFooter footer, EmbedImage image, EmbedThumbnail thumbnail, EmbedVideo video, EmbedProvider provider,
            EmbedAuthor author, EmbedField[] fields) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.url = url;
        this.timestamp = timestamp;
        this.color = color;
        this.footer = footer;
        this.image = image;
        this.thumbnail = thumbnail;
        this.video = video;
        this.provider = provider;
        this.author = author;
        this.fields = fields;
    }

    public String getTitle() {
        return title;
    }

    public EmbedType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getColor() {
        return color;
    }

    public EmbedFooter getFooter() {
        return footer;
    }

    public EmbedImage getImage() {
        return image;
    }

    public EmbedThumbnail getThumbnail() {
        return thumbnail;
    }

    public EmbedVideo getVideo() {
        return video;
    }

    public EmbedProvider getProvider() {
        return provider;
    }

    public EmbedAuthor getAuthor() {
        return author;
    }

    public EmbedField[] getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "Embed{" + "title='" + title + '\'' + ", type=" + type + ", description='" + description + '\''
                + ", url='" + url + '\'' + ", timestamp='" + timestamp + '\'' + ", color=" + color + ", footer="
                + footer + ", image=" + image + ", thumbnail=" + thumbnail + ", video=" + video + ", provider="
                + provider + ", author=" + author + ", fields=" + Arrays.toString(fields) + '}';
    }
}
