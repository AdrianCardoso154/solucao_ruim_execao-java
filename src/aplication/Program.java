package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter as number of room: ");
		int num = sc.nextInt();

		System.out.println("Enter as the Date of check-in: (dd/MM/yyyy) ");
		Date dt_ci = sdf1.parse(sc.next());

		System.out.println("Enter as thr Date of check-out: (dd/MM/yyyy) ");
		Date dt_co = sdf1.parse(sc.next());

		if (!dt_co.after(dt_ci)) {// after testa se uma data e depois da outra;
			System.out.println("Error in reservation: check-out date must be after check-in date!!!");
		} else {
			Reservation resev = new Reservation(num, dt_ci, dt_co);
			System.out.println(resev);
			System.out.println("---------------------------------------");
			System.out.println("Enter as the date to update reservetion: ");
			System.out.println("Check-in: ");
			dt_ci = sdf1.parse(sc.next());
			System.out.println("Check-out: ");
			dt_co = sdf1.parse(sc.next());

			Date now = new Date();

			if (dt_ci.after(now) || dt_co.before(now)) {
				System.out.println("Error in reseation: check-out date must be after check-in date!!!");
			} else if (!dt_co.after(dt_ci)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates!!!");
			}else {
				resev.update_dates(dt_ci, dt_co);
				System.out.println(resev);
			}
			
		}

		sc.close();
	}

}
