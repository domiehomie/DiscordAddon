package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.util.Arrays;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.ChannelType;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.VideoQualityMode;

public class Channel {
    String id;
    ChannelType type;
    String guild_id;
    int position;
    Overwrite[] permission_overwrites;
    String name;
    String topic;
    boolean nsfw;
    String last_message_id;
    int bitrate;
    int user_limit;
    int rate_limit_per_user;
    User[] recipients;
    String icon;
    String owner_id;
    String application_id;
    String parent_id;
    String last_pin_timestamp;
    String rtc_region;
    VideoQualityMode video_quality_mode;
    int message_count;
    int member_count;
    ThreadMetadata thread_metadata;
    ThreadMember thread_member;

    public String getId() {
        return id;
    }

    public ChannelType getType() {
        return type;
    }

    public String getGuild_id() {
        return guild_id;
    }

    public int getPosition() {
        return position;
    }

    public Overwrite[] getPermission_overwrites() {
        return permission_overwrites;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public String getLast_message_id() {
        return last_message_id;
    }

    public int getBitrate() {
        return bitrate;
    }

    public int getUser_limit() {
        return user_limit;
    }

    public int getRate_limit_per_user() {
        return rate_limit_per_user;
    }

    public User[] getRecipients() {
        return recipients;
    }

    public String getIcon() {
        return icon;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public String getApplication_id() {
        return application_id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public String getLast_pin_timestamp() {
        return last_pin_timestamp;
    }

    public String getRtc_region() {
        return rtc_region;
    }

    public VideoQualityMode getVideo_quality_mode() {
        return video_quality_mode;
    }

    public int getMessage_count() {
        return message_count;
    }

    public int getMember_count() {
        return member_count;
    }

    public ThreadMetadata getThread_metadata() {
        return thread_metadata;
    }

    public ThreadMember getThread_member() {
        return thread_member;
    }

    @Override
    public String toString() {
        return "Channel{" + "id='" + id + '\'' + ", type=" + type + ", guild_id='" + guild_id + '\'' + ", position="
                + position + ", permission_overwrites=" + Arrays.toString(permission_overwrites) + ", name='" + name
                + '\'' + ", topic='" + topic + '\'' + ", nsfw=" + nsfw + ", last_message_id='" + last_message_id + '\''
                + ", bitrate=" + bitrate + ", user_limit=" + user_limit + ", rate_limit_per_user=" + rate_limit_per_user
                + ", recipients=" + Arrays.toString(recipients) + ", icon='" + icon + '\'' + ", owner_id='" + owner_id
                + '\'' + ", application_id='" + application_id + '\'' + ", parent_id='" + parent_id + '\''
                + ", last_pin_timestamp='" + last_pin_timestamp + '\'' + ", rtc_region='" + rtc_region + '\''
                + ", video_quality_mode=" + video_quality_mode + ", message_count=" + message_count + ", member_count="
                + member_count + ", thread_metadata=" + thread_metadata + ", thread_member=" + thread_member + '}';
    }
}
