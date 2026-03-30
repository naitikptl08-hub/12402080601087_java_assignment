// Program 5: Inheritance-based Cricket–Match System using Command Line Arguments
// Usage: java P5_CricketMatch <Team1> <Team2> <Overs> <Score1> <Score2>
// Example: java P5_CricketMatch India Australia 20 186 175

public class CricketMatch {

    // Base class
    static class Player {
        String name;
        String team;

        Player(String name, String team) {
            this.name = name;
            this.team = team;
        }

        public void display() {
            System.out.println("Player: " + name + " | Team: " + team);
        }
    }

    // Batsman extends Player
    static class Batsman extends Player {
        int runs;
        int ballsFaced;

        Batsman(String name, String team, int runs, int ballsFaced) {
            super(name, team);
            this.runs = runs;
            this.ballsFaced = ballsFaced;
        }

        public double strikeRate() {
            return (runs * 100.0) / ballsFaced;
        }

        @Override
        public void display() {
            System.out.printf("  Batsman  : %-15s | Team: %-10s | Runs: %3d | SR: %.2f%n",
                    name, team, runs, strikeRate());
        }
    }

    // Bowler extends Player
    static class Bowler extends Player {
        int wickets;
        double oversBowled;
        int runsConceded;

        Bowler(String name, String team, int wickets, double oversBowled, int runsConceded) {
            super(name, team);
            this.wickets = wickets;
            this.oversBowled = oversBowled;
            this.runsConceded = runsConceded;
        }

        public double economy() {
            return runsConceded / oversBowled;
        }

        @Override
        public void display() {
            System.out.printf("  Bowler   : %-15s | Team: %-10s | Wkts: %d | Eco: %.2f%n",
                    name, team, wickets, economy());
        }
    }

    // Match class
    static class Match {
        String team1, team2;
        int overs, score1, score2;

        Match(String team1, String team2, int overs, int score1, int score2) {
            this.team1  = team1;
            this.team2  = team2;
            this.overs  = overs;
            this.score1 = score1;
            this.score2 = score2;
        }

        public void displayScorecard() {
            System.out.println("\n========= SCORECARD =========");
            System.out.printf("  %s  vs  %s%n", team1, team2);
            System.out.println("  Format: T" + overs);
            System.out.printf("  %-15s : %d runs%n", team1, score1);
            System.out.printf("  %-15s : %d runs%n", team2, score2);
        }

        public void declareResult() {
            System.out.println("\n========= RESULT ============");
            if (score1 > score2)
                System.out.printf("  🏆 %s wins by %d runs!%n", team1, score1 - score2);
            else if (score2 > score1)
                System.out.printf("  🏆 %s wins by %d runs!%n", team2, score2 - score1);
            else
                System.out.println("  🤝 It's a tie!");
        }
    }

    public static void main(String[] args) {
        // Validate command line arguments
        if (args.length < 5) {
            System.out.println("Usage: java P5_CricketMatch <Team1> <Team2> <Overs> <Score1> <Score2>");
            System.out.println("Example: java P5_CricketMatch India Australia 20 186 175");
            return;
        }

        String team1  = args[0];
        String team2  = args[1];
        int overs     = Integer.parseInt(args[2]);
        int score1    = Integer.parseInt(args[3]);
        int score2    = Integer.parseInt(args[4]);

        Match match = new Match(team1, team2, overs, score1, score2);
        match.displayScorecard();
        match.declareResult();

        // Sample players
        System.out.println("\n========= PLAYERS ===========");
        Batsman b1 = new Batsman("Virat Kohli",   team1, 82, 55);
        Batsman b2 = new Batsman("David Warner",  team2, 63, 45);
        Bowler  w1 = new Bowler ("Bumrah",        team1, 3, 4.0, 28);
        Bowler  w2 = new Bowler ("Pat Cummins",   team2, 2, 4.0, 35);

        b1.display();
        b2.display();
        w1.display();
        w2.display();
    }
}