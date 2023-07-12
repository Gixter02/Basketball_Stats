# Basketball Stats 
This is an application which lets you record a basketball game's live stats.

Each stat you insert is an event composed of:
* Type (shot, rebound, assist, block, foul, steal, turnover)
* Player number
* Quarter (of the game)
* Position (only for shots)

For shots, we implemented an **interactive court**: depending on where you click, the shot will be counted as a two pointer or a three pointer, plus the player number will be shown in green if the shot is made, red otherwise.

#### Useful features
* Import and export team in .json
* Import and export game stats in .json and .csv (for Excel usage)
* Undo button