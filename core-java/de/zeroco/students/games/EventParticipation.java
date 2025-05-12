package de.zeroco.students.games;

import java.util.Arrays;

import de.zeroco.main.Utility;

/**
 * EventParticipation class is designed to determine and display the games that each student participates in.
 * It processes data about students and their participation in cricket, badminton, and carroms, ensuring that every student
 * is listed as participating in essay writing by default. The class provides methods to identify games for each student
 * and generate a detailed report.
 * 
 * @since 24-01-2025
 * @author Tejaswini.S
 * @reviewed by 		
 */
public class EventParticipation {
	
	public static void main(String[] args) {
        int[] studentsId = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] carromTeam = {2, 5, 6, 14};
        int[] cricketTeam = {12, 1, 20, 7, 8, 2, 5, 6, 13, 11, 9, 3, 19};
        int[] badmintonTeam = {4, 10};
        try {
            int[][] playList = getStudentParticipationList(studentsId, cricketTeam, badmintonTeam, carromTeam, 20, 5);
            System.out.println("Students | Cricket | Badminton | Carrom | Essay Writing");
            for (int i = 0; i < playList.length; i++) {
                for (int j = 0; j < playList[0].length; j++) {
                    System.out.print(playList[i][j] + "          ");
                }
                System.out.println("\n"); 
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
	
	/**
	 * getStudentGameList method is designed to process student participation in different games.
	 * It iterates through a list of students and checks if they are part of the cricket, badminton, or carrom teams.
	 * The method returns a 2D array where each row represents a student, and the columns indicate their participation
	 * in cricket, badminton, carrom, and essay writing.
	 * 
	 * @param studentsId integer array
	 * @param cricket integer array
	 * @param badminton integer array
	 * @param carrom integer array
	 * @return A 2D array where each row contains the student's ID and their participation in each game.
	 * @since 24-01-2025
	 * @author Tejaswini.S
	 * @reviewed by 
	 */
	public static int[][] getStudentParticipationList(int[] studentsId, int[] cricket, int[] badminton, int[] carrom, int rows, int coloumns) {
		sportsValidation("carroms", carrom, 4);
		sportsValidation("Cricket", cricket, 13);
		sportsValidation("Badminton", badminton, 2);
		int[][] playList = new int[rows][coloumns];
		for (int i = 0; i < studentsId.length; i++) {
			playList[i][0] = studentsId[i];
			playList[i][1] = (isStudentInGame(studentsId[i], cricket)) ? 1 : 0;
			playList[i][2] = (isStudentInGame(studentsId[i], badminton)) ? 1 : 0;
			playList[i][3] = (isStudentInGame(studentsId[i], carrom)) ? 1 : 0;
			playList[i][4] = 1;
	    }
		return playList;
    }
	
	/**
	 * isStudentInGame method checks if a student is part of a given game array.
	 * If the student's ID is found, it returns true, indicating that the student participates in the game. Otherwise, it returns false.
	 * 
	 * @param studentId
	 * @param games integer array.
	 * @return A boolean value, true if the student is found in the game, false otherwise.
	 * @since 24-01-2025
	 * @author Tejaswini.S
	 * @reviewed by 
	 */
	public static boolean isStudentInGame(int studentId, int[] games) {
		if (Utility.isBlank(games) || Utility.isBlank(studentId)) return false;
        Arrays.sort(games);
        return Arrays.binarySearch(games, studentId) >= 0;
    }
	
	public static void sportsValidation(String sportsName, int[] sports, int size) {
		if (Utility.isBlank(sportsName)) return;
		if (Utility.isBlank(sports)) return;
		if (sports.length < size || sports.length > size || sports.length == 0) return;
		for (int i = 0; i < sports.length; i++) {
			for (int j = i + 1; j < sports.length; j++) {
				if (sports[i] == sports[j]) {
					throw new IllegalArgumentException(sportsName + " :team contains duplicate student ID: " + sports[i]);
				}
			}
		}
	}
	
}
	

