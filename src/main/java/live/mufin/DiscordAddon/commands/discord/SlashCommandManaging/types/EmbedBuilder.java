package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.util.List;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.EmbedType;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.*;

public class EmbedBuilder {

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

    public EmbedBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public EmbedBuilder setType(EmbedType type) {
        this.type = type;
        return this;
    }

    public EmbedBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public EmbedBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public EmbedBuilder setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public EmbedBuilder setColor(int color) {
        this.color = color;
        return this;
    }

    public EmbedBuilder setFooter(EmbedFooter footer) {
        this.footer = footer;
        return this;
    }

    public EmbedBuilder setImage(EmbedImage image) {
        this.image = image;
        return this;
    }

    public EmbedBuilder setThumbnail(EmbedThumbnail thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public EmbedBuilder setVideo(EmbedVideo video) {
        this.video = video;
        return this;
    }

    public EmbedBuilder setProvider(EmbedProvider provider) {
        this.provider = provider;
        return this;
    }

    public EmbedBuilder setAuthor(EmbedAuthor author) {
        this.author = author;
        return this;
    }

    public EmbedBuilder setFields(EmbedField[] fields) {
        this.fields = fields;
        return this;
    }

    public Embed build() {
        return new Embed(title, type, description, url, timestamp, color, footer, image, thumbnail, video, provider,
                author, fields);
    }
}
