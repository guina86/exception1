package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyy): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), format);
			System.out.print("Check-out date (dd/MM/yyy): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), format);
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyy): ");
			checkIn = LocalDate.parse(sc.next(), format);
			System.out.print("Check-out date (dd/MM/yyy): ");
			checkOut = LocalDate.parse(sc.next(), format);
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Updated reservation: " + reservation);
		} catch (DateTimeParseException e) {
			System.out.println("invalid date format");
		} catch ( DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();

	}

}
