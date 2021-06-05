package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.util.Arrays;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.ApplicationFlags;

public class Application {
    String id;
    String name;
    String icon;
    String description;
    String[] rpc_orgins;
    boolean bot_public;
    boolean bot_require_code_grant;
    String terms_of_service_url;
    String privacy_policy_url;
    User owner;
    String summary;
    String verify_key;
    Team team;
    String guild_id;
    String primary_sku_id;
    String slug;
    String cover_image;
    ApplicationFlags flags;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public String[] getRpc_orgins() {
        return rpc_orgins;
    }

    public boolean isBot_public() {
        return bot_public;
    }

    public boolean isBot_require_code_grant() {
        return bot_require_code_grant;
    }

    public String getTerms_of_service_url() {
        return terms_of_service_url;
    }

    public String getPrivacy_policy_url() {
        return privacy_policy_url;
    }

    public User getOwner() {
        return owner;
    }

    public String getSummary() {
        return summary;
    }

    public String getVerify_key() {
        return verify_key;
    }

    public Team getTeam() {
        return team;
    }

    public String getGuild_id() {
        return guild_id;
    }

    public String getPrimary_sku_id() {
        return primary_sku_id;
    }

    public String getSlug() {
        return slug;
    }

    public String getCover_image() {
        return cover_image;
    }

    public ApplicationFlags getFlags() {
        return flags;
    }

    @Override
    public String toString() {
        return "Application{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", icon='" + icon + '\''
                + ", description='" + description + '\'' + ", rpc_orgins=" + Arrays.toString(rpc_orgins)
                + ", bot_public=" + bot_public + ", bot_require_code_grant=" + bot_require_code_grant
                + ", terms_of_service_url='" + terms_of_service_url + '\'' + ", privacy_policy_url='"
                + privacy_policy_url + '\'' + ", owner=" + owner + ", summary='" + summary + '\'' + ", verify_key='"
                + verify_key + '\'' + ", team=" + team + ", guild_id='" + guild_id + '\'' + ", primary_sku_id='"
                + primary_sku_id + '\'' + ", slug='" + slug + '\'' + ", cover_image='" + cover_image + '\'' + ", flags="
                + flags + '}';
    }
}
