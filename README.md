# faister-hardcore
A Hardcore challenge plugin for [Faister](https://twitch.tv/faisterino)
<br>Command Usage syntax: `/command <Required> [Optional]`
 
**Contents:**
* Week 1 ([Details](#week-1))
  * Armor Equip = -1 Heart permanently
  * /maxhealth Command  
* Week 2 ([Details](#week-2))
  * Added bossmobs, that have increased stats
  * /summonbossmob Command  
* Week 3 ([Details](#week-3))
  * Every time a person consumes food, they get a random effect. Effects stack with a higher amplifier
  * /randomeffect command
  * /cleareffects command


 # <a name="downloads"></a> Downloads
 ⚠ You should only use one file, since newer downloads include the older weeks
 * [Week 1](https://github.com/brentspine/faister-hardcore/blob/main/out/faisterhardcore-1.0-SNAPSHOT.jar?raw=true)
 * [Week 2](https://github.com/brentspine/faister-hardcore/blob/main/out/faisterhardcore-2.0-SNAPSHOT.jar?raw=true)
 * [Week 3](https://github.com/brentspine/faister-hardcore/blob/main/out/faisterhardcore-3.0-SNAPSHOT.jar?raw=true)
<br>

# <a name="week-1"></a> Week 1
Every time you equip armor in any way you will loose one heart permanently that you can't regenerate.
![faister-hardcore-week1-explanati](https://user-images.githubusercontent.com/55391576/162583791-8bcefafb-b4ea-4ea8-8c56-34e3d1f5007f.gif)

Added the /maxhealth command
It allows you to set the maximum health of any given player or for yourself
<br>Usage: &nbsp; &nbsp; &nbsp; &nbsp; `/maxhealth <Health> [Player]` 
<br>Permission: &nbsp;`hardcore.health`
<br>Example 1: &nbsp; /maxhealth 20
<br>Example 2: &nbsp; /maxhealth 42 Brentspine

# <a name="week-2"></a> Week 2

### Stats
Added bossmobs that spawn instead of normal mobs and have boosted stats (Health and Strength) like following: <br>
 
 | Level   | Probability    | Health     | Strength    |
 | ------- | -------------- | ---------- | ----------- |
 | 1       | 90%            | 20 ❤      | none        |
 | 2       | 9%             | 30 ❤      | 1 ⚔         |
 | 3       | 0.9%           | 45 ❤      | 2 ⚔         |
 | 4       | 0.09%          | 67.5 ❤    | 3 ⚔         |
 | 5       | 0.01%          | 101.25 ❤  | 4 ⚔         |
 
 ![dflgjnsldfkjgnlsjkdfgnlskjdfgnsdfg](https://user-images.githubusercontent.com/55391576/162584688-1f070797-1035-4c72-b71f-695bf71a80e8.JPG)
 <br>A warning message appears for monsters with Level 4 or higher: <br>
![dfgjsdfngljknsdflgjnsdlfkjgnsldfkjgnsldfjkg](https://user-images.githubusercontent.com/55391576/162584815-16576dc5-8871-4d4a-be49-df9f79e1ccb3.JPG)

### Summon Bossmobs
The /summonbossmob Command allows you to summon mobs with a specific level
<br>Usage: `/summonbossmob <Mob> <Level>` 
<br>Permission: `hardcore.summon`
<br>Example: `/smb Zombie 5`

# <a name="week-3"></a> Week 3
Everytime a player consumes an edible item, they get a random effect. If they already have an active effect that was given by the plugin, that effect will stack with a higher amplifier. 

### Commands
The /randomeffect Command gives you a random effect like when consuming an item
<br>Usage: `/randomeffect` 
<br>Permission: `hardcore.effect`

The /cleareffects command is a shortcut for /effects clear @s
<br>Usage: `/randomeffect` 
<br>Permission: `hardcore.effect`
