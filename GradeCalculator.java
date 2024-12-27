
/*
* GradeCalculator.java
* Author: Maryanne Momeh
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from anywhere other than the authorized
* sources. I recognize that any unauthorized sharing, assistance,
* or plagiarism will be handled in accordance with both the
* University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based on
* an assignment created by the School of Computing
* at the University of Georgia. Any publishing or posting
* of source code at any time for this project is prohibited.
*/
import java.util.Scanner;

public class GradeCalculator {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Grading Scale: \nA\t90-100 \nB\t80-89 \nC\t70-79 \nD\t60-69 \nF\tbelow 60");

		System.out.printf("What letter grade do you want to achieve for this course?");
		// user inputs appropriate desired letter grade
		char desiredFinalLetterGrade;
		desiredFinalLetterGrade = keyboard.next().charAt(0);
		if (desiredFinalLetterGrade != 'A' && desiredFinalLetterGrade != 'B' && desiredFinalLetterGrade != 'C'
				&& desiredFinalLetterGrade != 'D' && desiredFinalLetterGrade != 'F') {
			System.out.println("The input is invalid.");
			System.exit(0);
		}

		System.out.println("Enter the percentage weights below.");
		
		// user inputs percentage weights
		System.out.print("Exam 1:\t\t");
		double weightExamOne = keyboard.nextDouble();
		System.out.print("Exam 2:\t\t");
		double weightExamTwo = keyboard.nextDouble();
		System.out.print("Final Exam:\t");
		double weightFinalExam = keyboard.nextDouble();
		System.out.print("Labs:\t\t");
		double weightLabs = keyboard.nextDouble();
		System.out.print("Projects:\t");
		double weightProjects = keyboard.nextDouble();
		System.out.print("Participation:\t");
		double weightParticipation = keyboard.nextDouble();
		System.out.print("Quizzes:\t");
		double weightQuizzes = keyboard.nextDouble();

		// grade weights must equal 100
		double totalGradeWeight = weightExamOne + weightExamTwo + weightFinalExam + weightLabs + weightProjects
				+ weightParticipation + weightQuizzes;
		if (totalGradeWeight != 100) {
			System.out.println("Weights don't add up to 100, program exiting...");
			System.exit(0);
		}

		double currentTotal = 0;
		double knownWeight = 0;

		// user can type in exam 1 score if known
		System.out.print("Do you know your exam 1 score?");
		String answerExamOne;
		answerExamOne = keyboard.next();

		// tests to see if user knows exam 2 score, and final exam
		if (answerExamOne.equalsIgnoreCase("y") || answerExamOne.equalsIgnoreCase("yes")) {
			System.out.print("Score recieved on exam 1:");
			double scoreExamOne = keyboard.nextDouble();
			currentTotal += weightExamOne * scoreExamOne;
			knownWeight += weightExamOne;
			if (scoreExamOne >= 0) {
				System.out.print("Do you know your exam 2 score?");
				String answerExamTwo;
				answerExamTwo = keyboard.next();
				if (answerExamTwo.equalsIgnoreCase("y") || answerExamTwo.equalsIgnoreCase("yes")) {
					System.out.print("Score recieved on exam 2:");
					double scoreExamTwo = keyboard.nextDouble();
					currentTotal += weightExamTwo * scoreExamTwo;
					knownWeight += weightExamTwo;
					if (scoreExamTwo >= 0) {
						System.out.print("Do you know your final exam score?");
						String answerFinalExam;
						answerFinalExam = keyboard.next();
						if (answerFinalExam.equalsIgnoreCase("y") || answerFinalExam.equalsIgnoreCase("yes")) {
							System.out.print("Score recieved on final exam:");
							double scoreFinalExam = keyboard.nextDouble();
							currentTotal += weightFinalExam * scoreFinalExam;
							knownWeight += weightFinalExam;
						}
					}
				}
			}
		}
		
		System.out.print("Do you know your lab average?");
		String answerLabAverage;
		answerLabAverage = keyboard.next();
		if (answerLabAverage.equalsIgnoreCase("yes") || answerLabAverage.equalsIgnoreCase("y")) {
			System.out.print("Average lab grade:");
			double averageLabGrade = keyboard.nextDouble();
			currentTotal += weightLabs * averageLabGrade;
			knownWeight += weightLabs;
		}

		System.out.print("Do you know you project average?");
		String answerProjectAverage;
		answerProjectAverage = keyboard.next();
		if (answerProjectAverage.equalsIgnoreCase("yes") || answerProjectAverage.equalsIgnoreCase("y")) {
			System.out.print("Average project grade:");
			double averageProjectGrade = keyboard.nextDouble();
			currentTotal += weightProjects * averageProjectGrade;
			knownWeight += weightProjects;
		}

		System.out.print("Do you know your participation average?");
		String answerParticipationAverage;
		answerParticipationAverage = keyboard.next();
		if (answerParticipationAverage.equalsIgnoreCase("yes") || answerParticipationAverage.equalsIgnoreCase("y")) {
			System.out.print("Average participation grade:");
			double averageParticipationGrade = keyboard.nextDouble();
			currentTotal += weightParticipation * averageParticipationGrade;
			knownWeight += weightParticipation;
		}

		System.out.print("Do you know your quiz average?");
		String answerQuizAverage;
		answerQuizAverage = keyboard.next();
		if (answerQuizAverage.equalsIgnoreCase("yes") || answerQuizAverage.equalsIgnoreCase("y")) {
			System.out.print("Average quiz grade:");
			double averageQuizGrade = keyboard.nextDouble();
			currentTotal += weightQuizzes * averageQuizGrade;
			knownWeight += weightQuizzes;
		}

		// calculates users current grade score
		double currentGradeScore = currentTotal / knownWeight;
		System.out.printf("Current grade score:%.2f\n", currentGradeScore);
		
		//determines least minimum score user needs to have to get the desired final letter grade
		double finalOverallScore = 0;
		if (desiredFinalLetterGrade == 'A') {
			finalOverallScore = 90;
		} else if (desiredFinalLetterGrade == 'B') {
			finalOverallScore = 80;
		} else if (desiredFinalLetterGrade == 'C') {
			finalOverallScore = 70;
		} else if (desiredFinalLetterGrade == 'D') {
			finalOverallScore = 70;
		} else if (desiredFinalLetterGrade == 'F') {
			finalOverallScore = 60;
		}
		// determines users current letter grade based on users current grade score
		char currentLetterGrade = ' ';
		if (currentGradeScore >= 90) {
			System.out.println("Your current letter grade:A");
			currentLetterGrade = 'A';
		} else if (currentGradeScore >= 80 && currentGradeScore < 90) {
			currentLetterGrade = 'B';
			System.out.println("Your current letter grade:B");
		} else if (currentGradeScore >= 70 && currentGradeScore < 80) {
			System.out.println("Your current letter grade:C");
			currentLetterGrade = 'C';
		} else if (currentGradeScore >= 60 && currentGradeScore < 70) {
			System.out.println("Your current letter grade:D");
			currentLetterGrade = 'D';
		} else if (currentGradeScore < 60) {
			System.out.println("Your current letter grade:F");
			currentLetterGrade = 'F';

		}
		
		// determines the averages needed for user to get their desired letter grade
		double avgToFinalLetterGrade = ((100 * finalOverallScore) - (currentTotal)) / (100 - knownWeight);
		
		// determines if the users desired score is attainable, if score is attainable, congratulates user 
		if (currentLetterGrade == desiredFinalLetterGrade) {
			System.out.println("Congratulations! You recieved the " + desiredFinalLetterGrade + " that you wanted!");
		} else if (avgToFinalLetterGrade <= 0) {
			System.out.printf("You will recieve at least a grade of %c.", desiredFinalLetterGrade);
		} else if (avgToFinalLetterGrade > 100) {
			System.out.println("Unfortunately, a grade of " + desiredFinalLetterGrade + " is not possible.");
		} else if (avgToFinalLetterGrade < 100) {
			System.out.printf(
					"In order to recieve a grade of %c,  \nyou need to score an average greater than \nor equal to %.2f in the rest of the grade items.",
					desiredFinalLetterGrade, avgToFinalLetterGrade);
		}

		keyboard.close();
	}
}
