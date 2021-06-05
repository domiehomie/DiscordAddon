package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.util.Map;

public class ApplicationCommandInteractionDataResolved {
    Map<String, User> users;
    Map<String, Member> members;
    Map<String, Role> roles;
    Map<String, Channel> channels;

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Member> getMembers() {
        return members;
    }

    public Map<String, Role> getRoles() {
        return roles;
    }

    public Map<String, Channel> getChannels() {
        return channels;
    }

    @Override
    public String toString() {
        return "ApplicationCommandInteractionDataResolved{" + "users=" + users + ", members=" + members + ", roles="
                + roles + ", channels=" + channels + '}';
    }
}
