package me.friwi.jexam;

import me.friwi.jexam.LectureInfoStructs.Day;
import me.friwi.jexam.LectureInfoStructs.LectureType;
import me.friwi.jexam.LectureInfoStructs.Semester;
import me.friwi.jexam.LectureInfoStructs.Slot;
import me.friwi.jexam.LectureInfoStructs.Week;

public class Main {
	public static void main(String[] args){
		JExamBot bot = new JExamBot();
		
		bot.addRegex(Semester.WS17_18.Rechnerarchitektur_I, Day.MO, Slot._2, LectureType.UEBUNG, Week.WEEKLY);
		bot.addRegex(Semester.WS17_18.Formale_Systeme, Day.MO, Slot._3, LectureType.VORLESUNG, Week.WEEKLY);
		bot.addRegex(Semester.WS17_18.INF_120_Mathematische_Methoden_für_Informatiker, Day.MO, Slot._4, LectureType.UEBUNG, Week.WEEKLY);
		
		bot.addRegex(Semester.WS17_18.Technische_Grundlagen_der_Informatik, Day.DI, Slot._2, LectureType.UEBUNG, Week.WEEKLY);
		bot.addRegex(Semester.WS17_18.INF_120_Mathematische_Methoden_für_Informatiker, Day.DI, Slot._3, LectureType.VORLESUNG, Week.FIRST_KW);
		bot.addRegex(Semester.WS17_18.Technische_Grundlagen_der_Informatik, Day.DI, Slot._3, LectureType.VORLESUNG, Week.SECOND_KW);
		bot.addRegex(Semester.WS17_18.Systemorientierte_Informatik_und_Hardware_Software_Codesign, Day.DI, Slot._4, LectureType.VORLESUNG, Week.WEEKLY);
		bot.addRegex(Semester.WS17_18.Rechnerarchitektur_I, Day.DI, Slot._5, LectureType.VORLESUNG, Week.WEEKLY);
		
		bot.addRegex(Semester.WS17_18.Intelligente_Systeme, Day.MI, Slot._2, LectureType.VORLESUNG, Week.WEEKLY);
		bot.addRegex(Semester.WS17_18.Formale_Systeme, Day.MI, Slot._4, LectureType.UEBUNG, Week.WEEKLY);
		bot.addRegex(Semester.WS17_18.Systemorientierte_Informatik_und_Hardware_Software_Codesign, Day.MI, Slot._5, LectureType.UEBUNG, Week.WEEKLY);
		bot.addRegex(Semester.WS17_18.Intelligente_Systeme, Day.MI, Slot._6, LectureType.UEBUNG, Week.WEEKLY);
		
		bot.addRegex(Semester.WS17_18.Technische_Grundlagen_der_Informatik, Day.DO, Slot._2, LectureType.VORLESUNG, Week.WEEKLY);
		bot.addRegex(Semester.WS17_18.INF_120_Mathematische_Methoden_für_Informatiker, Day.DO, Slot._3, LectureType.VORLESUNG, Week.WEEKLY);
		bot.addRegex(Semester.WS17_18.Formale_Systeme, Day.DO, Slot._4, LectureType.VORLESUNG, Week.WEEKLY);
		
		bot.runBot("sNUMMMER", "zensiert");
	}
}
