//Problem: Skiena & Revilla 4.8 http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=32&page=show_problem&problem=1135
//Status: WA

import java.util.*;

public class Main_4_8 {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Main_4_8().run();
	}

	void run() {
		int n = in.nextInt(); in.nextLine();
		for(int i=0; i<n; i++) {
			System.out.println(in.nextLine());

			int t = in.nextInt(); in.nextLine();
			Map<String, Team> teams = new HashMap<String, Team>();
			Team[] teamList = new Team[t];
			for(int j=0; j<t; j++) {
				String str = in.nextLine();
				Team team = new Team(str);
				teams.put(str, team);
				teamList[j] = team; 
			}
			
			int g = in.nextInt(); in.nextLine();
			for(int j=0; j<g; j++) {
				String str = in.nextLine();
				String[] line = str.split("#");
				String[] scores = line[1].split("@");
				
				Team team1 = teams.get(line[0]),
					 team2 = teams.get(line[2]);
				int team1Score = Integer.valueOf(scores[0]),
					team2Score = Integer.valueOf(scores[1]);
				int diff = team1Score - team2Score;
				
				if(diff == 0)
					processTie(team1, team2);
				if(diff > 0)
					processWinner(team1, team2);
				if(diff < 0)
					processWinner(team2, team1);
				
				team1.games_played++;
				team2.games_played++;
				
				team1.goal_scored += team1Score;
				team2.goal_scored += team2Score;
				
				team1.goal_against += team2Score;
				team2.goal_against += team1Score;
			}
			
			Arrays.sort(teamList);
			printTable(teamList);
		}
	}
	
	void processWinner(Team winner, Team loser) {
		winner.points += 3;
		winner.wins++;
		
		loser.losses++;
	}
	
	void processTie(Team team1, Team team2) {
		team1.points++;
		team1.ties++;

		team2.points++;
		team2.ties++;
	}
	
	void printTable(Team[] teams) {
		int counter = 1;
		for (int i=0; i<teams.length; i++) {
			Team team = teams[i];
			System.out.printf("%d) %s %dp, %dg (%d-%d-%d), %dgd (%d-%d)%n",
					counter++, team.name, team.points, team.games_played, team.wins, team.ties, 
					team.losses, team.goal_diff(), team.goal_scored, team.goal_against);
		}
		System.out.println();
	}
}

class Team implements Comparable {
	String name;
	int points, games_played, wins, ties, losses, goal_scored, goal_against;
	public Team(String str) { name = str; }
	int goal_diff() { return goal_scored - goal_against; }
	
	@Override
	public int compareTo(Object o) {
		Team obj = (Team) o;
		
		if(points > obj.points) return -1;
		if(points < obj.points) return 1;
		if(wins > obj.wins) return -1;
		if(wins < obj.wins) return 1;
		if(goal_diff() > obj.goal_diff()) return -1;
		if(goal_diff() < obj.goal_diff()) return 1;
		if(goal_scored > obj.goal_scored) return -1;
		if(goal_scored < obj.goal_scored) return 1;
		if(games_played < obj.games_played) return -1;
		if(games_played > obj.games_played) return 1;
		
		return name.compareTo(obj.name) * -1;
	}
}
