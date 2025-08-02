# EliteBazaarDiscordWebhooks
An addon to receive webhooks on discord when an order is placed of filled on [EliteBazaar](https://builtbybit.com/resources/elitebazaar-supply-and-demand-market.57715/)

[Download from Spigot](https://www.spigotmc.org/resources/elitebazaardiscordwebhooks.127476/)

# CONFIG:
```YAML
webhook-url: "https://discord.com/api/webhooks/your-webhook-url"
buy-order-placed:
    enabled: true
    title: "A buy order was placed by {player}!"
    description: "A buy order was placed for x{amount} {itemName} at ${price} each on the bazaar."
    footer: "EliteBazaar - Buy Order Placed"
    color: "#0000FF"
buy-order-filled:
  enabled: true
  title: "A buy order was filled for {player}!"
  description: "A buy order was filled for x{amount} {itemName} at ${price} each on the bazaar."
  footer: "EliteBazaar - Buy Order Filled"
  color: "#00FF00"
sell-order-placed:
    enabled: true
    title: "A sell order was placed by {player}!"
    description: "A sell order was placed for x{amount} {itemName} at ${price} each on the bazaar."
    footer: "EliteBazaar - Sell Order Placed"
    color: "#FF0000"
sell-order-filled:
    enabled: true
    title: "A sell order was filled for {player}!"
    description: "A sell order was filled for x{amount} {itemName} at ${price} each for a total of ${total} on the bazaar."
    footer: "EliteBazaar - Sell Order Filled"
    color: "#FFFF00"
```
