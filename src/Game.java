public class Game {
    private String resultOfGame = "";
    public String gameOfTwoUp(Boolean coin1, Boolean coin2, String radioSelection, String playerName){
        if (radioSelection.equals("HEADS_HEADS")) {
            if (coin1 && coin2) {
                resultOfGame = "Victory";
                WriteFile.writeFileScores(playerName + " : " + resultOfGame);
            }
            else if (!coin1 && !coin2) {
                resultOfGame = "You Lose";
                WriteFile.writeFileScores(playerName + " : " + resultOfGame);
            }
            else {
                resultOfGame = "Roll Again";
            }
        } else if (radioSelection.equals("TAILS_TAILS")) {
            if (!coin1 && !coin2) {
                resultOfGame = "Victory";
                WriteFile.writeFileScores(playerName + " : " + resultOfGame);
            }
            else if (coin1 && coin2) {
                resultOfGame = "You Lose";
                WriteFile.writeFileScores(playerName + " : " + resultOfGame);
            }
            else {
                resultOfGame = "Roll Again";
            }
        }
    return resultOfGame;
    }
}
