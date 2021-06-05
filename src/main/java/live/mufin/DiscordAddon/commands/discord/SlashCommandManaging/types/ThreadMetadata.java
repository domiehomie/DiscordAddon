package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

public class ThreadMetadata {
    boolean archived;
    String archiver_id;
    int auto_archive_duration;
    String archive_timestamp;
    boolean locked;

    public boolean isArchived() {
        return archived;
    }

    public String getArchiver_id() {
        return archiver_id;
    }

    public int getAuto_archive_duration() {
        return auto_archive_duration;
    }

    public String getArchive_timestamp() {
        return archive_timestamp;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String toString() {
        return "ThreadMetadata{" + "archived=" + archived + ", archiver_id='" + archiver_id + '\''
                + ", auto_archive_duration=" + auto_archive_duration + ", archive_timestamp='" + archive_timestamp
                + '\'' + ", locked=" + locked + '}';
    }
}
