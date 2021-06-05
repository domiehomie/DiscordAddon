package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.util.Arrays;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.MessageFlags;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.MessageType;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.Embed;

public class Message {
    String id;
    String channel_id;
    String guild_id;
    User author;
    Member member;
    String content;
    String timestamp;
    String edited_timestamp;
    boolean tts;
    boolean mention_everyone;
    User[] mentions;
    String[] mention_roles;
    ChannelMention[] mention_channels;
    Attachment[] attachments;
    Embed[] embeds;
    Reaction[] reactions;
    String nonce;
    boolean pinned;
    String webhook_id;
    MessageType type;
    MessageActivity activity;
    Application application;
    String application_id;
    MessageReference reference;
    MessageFlags flags;
    Sticker[] stickers;
    Message referenced_message;
    MessageInteraction interaction;
    Channel thread;
    Component components;

    public String getId() {
        return id;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public String getGuild_id() {
        return guild_id;
    }

    public User getAuthor() {
        return author;
    }

    public Member getMember() {
        return member;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getEdited_timestamp() {
        return edited_timestamp;
    }

    public boolean isTts() {
        return tts;
    }

    public boolean isMention_everyone() {
        return mention_everyone;
    }

    public User[] getMentions() {
        return mentions;
    }

    public String[] getMention_roles() {
        return mention_roles;
    }

    public ChannelMention[] getMention_channels() {
        return mention_channels;
    }

    public Attachment[] getAttachments() {
        return attachments;
    }

    public Embed[] getEmbeds() {
        return embeds;
    }

    public Reaction[] getReactions() {
        return reactions;
    }

    public String getNonce() {
        return nonce;
    }

    public boolean isPinned() {
        return pinned;
    }

    public String getWebhook_id() {
        return webhook_id;
    }

    public MessageType getType() {
        return type;
    }

    public MessageActivity getActivity() {
        return activity;
    }

    public Application getApplication() {
        return application;
    }

    public String getApplication_id() {
        return application_id;
    }

    public MessageReference getReference() {
        return reference;
    }

    public MessageFlags getFlags() {
        return flags;
    }

    public Sticker[] getStickers() {
        return stickers;
    }

    public Message getReferenced_message() {
        return referenced_message;
    }

    public MessageInteraction getInteraction() {
        return interaction;
    }

    public Channel getThread() {
        return thread;
    }

    public Component getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return "Message{" + "id='" + id + '\'' + ", channel_id='" + channel_id + '\'' + ", guild_id='" + guild_id + '\''
                + ", author=" + author + ", member=" + member + ", content='" + content + '\'' + ", timestamp='"
                + timestamp + '\'' + ", edited_timestamp='" + edited_timestamp + '\'' + ", tts=" + tts
                + ", mention_everyone=" + mention_everyone + ", mentions=" + Arrays.toString(mentions)
                + ", mention_roles=" + Arrays.toString(mention_roles) + ", mention_channels="
                + Arrays.toString(mention_channels) + ", attachments=" + Arrays.toString(attachments) + ", embeds="
                + Arrays.toString(embeds) + ", reactions=" + Arrays.toString(reactions) + ", nonce='" + nonce + '\''
                + ", pinned=" + pinned + ", webhook_id='" + webhook_id + '\'' + ", type=" + type + ", activity="
                + activity + ", application=" + application + ", application_id='" + application_id + '\''
                + ", reference=" + reference + ", flags=" + flags + ", stickers=" + Arrays.toString(stickers)
                + ", referenced_message=" + referenced_message + ", interaction=" + interaction + ", thread=" + thread
                + ", components=" + components + '}';
    }
}
