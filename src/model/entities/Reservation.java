package model.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.exceptions.Domain_exeption;

public class Reservation {
	private int room_number;
	private Date cheking;
	private Date chekout;

	public static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(int room_number, Date cheking, Date chekout) {
		if (!chekout.after(cheking)) {
			throw new Domain_exeption("check-out date must be after check-in date!!!");
		}
		this.room_number = room_number;
		this.cheking = cheking;
		this.chekout = chekout;
	}

	public Reservation() {
		super();
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}

	public Date getCheking() {
		return cheking;
	}

	public Date getChekout() {
		return chekout;
	}

	public int duration() {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.setTime(this.getCheking());
		cal2.setTime(this.getChekout());
		return cal2.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
	}

	public void update_dates(Date chekin, Date chekout1){
		Date now = new Date();

		if (chekin.before(now) || chekout1.before(now)) {
			throw new Domain_exeption("reservation dates for update must be future dates!!!");// lança uma
																										// exeção para
																										// ser tratada
		} else if (!chekout1.after(cheking)) {
			throw new Domain_exeption("check-out date must be after check-in date!!!");
		}

		this.cheking = chekin;
		this.chekout = chekout1;
	}

	@Override
	public String toString() {
		return "Reservetion: Room " + this.getRoom_number() + ", check-in: " + sdf1.format(cheking) + ", check-out: "
				+ sdf1.format(chekout) + ", " + this.duration() + " nigths";
	}
}
