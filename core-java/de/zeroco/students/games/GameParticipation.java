package de.zeroco.students.games;

/**
 * The GameParticipation class is designed to determine and display the games that each student in a group participates in.
 * It processes data about students and their participation in cricket, badminton, and carroms, ensuring that every student
 * is listed as participating in essay writing by default. The class provides methods to identify games for each student
 * and generate a detailed report.
 * 
 * @since 22-01-2025
 * @author Tejaswini.S
 * @reviewed by Praveen.D, Hari Krishna.k
 */
public class GameParticipation {
    
	/**
	 *This method processes all students and returns a formatted string with the games each student plays.
     * It checks for each student whether they are part of the cricket, badminton, or carrom teams 
     * and appends the respective games to the result string. In addition to the sports, it also adds 
     * "essay writing" as a default activity for every student.
	 * 
	 * @since 22-01-2025
	 * @author Tejaswini.S
	 * @param int array of allStudents
	 * @param int array of cricketPlayers
	 * @param int array of badmintonPlayers
	 * @param int array of carromPlayers
	 * @return String, a formatted string containing each student ID along with the games they play
	 * @reviewed by Praveen.D, Hari Krishna.k
	 */
    public static String getStudentGameList(int[] studentsId, int[] cricket, int[] badminton, int[] carrom) {
        String res = ""; 
        for (int i = 0; i < studentsId.length; i++) {
            String games = "";
            if (isStudentInGame(carrom, studentsId[i])) {
            	games += "carroms, ";
            }
            if (isStudentInGame(cricket, studentsId[i])) {
                games += "cricket, ";
            }
            if (isStudentInGame(badminton, studentsId[i])) {
                games += "badminton, ";
            }
            res += studentsId[i] + "plays: " + games + " " + "essay writing" + "\n";
        }
        return res;
    }  
    
    /**
	 *This method checks if a given student ID exists in the array.
	 * 
	 * @since 22-01-2025
	 * @author Tejaswini.S
	 * @param int array of sports
	 * @param int studentId
	 * @return true if the student ID is found in the array, false otherwise.
	 * @reviewed by Praveen.D, Hari Krishna.k
	 */
    public static boolean isStudentInGame(int[] sports, int studentId) {
        for (int i = 0; i < sports.length; i++) {
            if (sports[i] == studentId) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
//        int[] studentsId = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
//        int[] carromTeam = {2, 5, 6, 13};
//        int[] cricketTeam = {12, 1, 20, 7, 8, 2, 5, 6, 13, 11, 9, 3, 19};
//        int[] badmintonTeam = {4, 10, 14, 15};    
//        System.out.println(getStudentGameList(studentsId, cricketTeam, badmintonTeam, carromTeam));
    }
}
