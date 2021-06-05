# DiscordAddon
 A spigot plugin allowing you to connect your server with Discord using powerful slash commands!



## IMPORTANT:

### Adding the bot

To add the bot to your server, go to [the discord developer portal](https://discord.com/developers/) and create an application. Call it whatever you want and give it whatever icon you want. Go to the "bot" tab and build the bot. Copy the token and put it in the config.yml. Then go back to the General Information tab and copy the Application Id. Then use this link to add the bot to your Discord server, replacing the fences with your application id.

```
https://discord.com/api/oauth2/authorize?client_id=<YOUR-ID-HERE>&permissions=8&scope=bot%20applications.commands
```

### Setting the channels

If you do not have Discord developer mode enabled, go to the settings > advanced > Developer mode, and turn it on. Then right click on the channel you want the messages to be sent in, and click `Copy id`. Put this id in the config file.

### Registering the webhook

To make the player messages appear, the bot uses webhooks. To create one, go to the channel you want them to be sent in, right click > edit channel. Then go to integrations > view webhooks. Click `New Webhook` and select the channel. (Name and icon doesn't matter, since the bot overrides them.) Copy the webhook URL and paste it in your config file. 