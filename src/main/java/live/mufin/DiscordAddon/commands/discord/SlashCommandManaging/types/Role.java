package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

public class Role {
    String id;
    String name;
    int color;
    boolean hoist;
    int position;
    String permissions;
    boolean managed;
    boolean mentionable;
    RoleTags tags;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    public boolean isHoist() {
        return hoist;
    }

    public int getPosition() {
        return position;
    }

    public String getPermissions() {
        return permissions;
    }

    public boolean isManaged() {
        return managed;
    }

    public boolean isMentionable() {
        return mentionable;
    }

    public RoleTags getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Role{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", color=" + color + ", hoist=" + hoist
                + ", position=" + position + ", permissions='" + permissions + '\'' + ", managed=" + managed
                + ", mentionable=" + mentionable + ", tags=" + tags + '}';
    }
}
