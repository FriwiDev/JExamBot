package me.friwi.jexam;

public class LectureInfoStructs {
	public enum EnrollmentStatus{
		FREE,
		PASSED,
		ENROLLED,
		INQUEUE,
		CLOSED,
		FIXED_ENROLLED;
		public static EnrollmentStatus get(String s){
			for(EnrollmentStatus type : values())if(type.name().equalsIgnoreCase(s))return type;
			return null;
		}
	}
	public enum LectureType{
		UEBUNG("CL"),
		COLLOQUIUM("C"),
		PRAKTIKUM("P"),
		VORLESUNG("L"),
		SEMINAR("S"),
		PROSEMINAR("PS"),
		HAUPTSEMINAR("MS"),
		EXKURSION("EX"),
		SEMINARGRUPPE("SG");
		String s;
		private LectureType(String s){
			this.s = s;
		}
		public static LectureType get(String s){
			for(LectureType type : values())if(type.s.equalsIgnoreCase(s))return type;
			return null;
		}
	}
	public enum Day{
		SO, MO, DI, MI, DO, FR, SA;
		public static Day get(int i){
			return values()[i];
		}
	}
	public enum Week{
		WEEKLY, FIRST_KW, SECOND_KW, MONTHLY;
		public static Week get(int i){
			return values()[i];
		}
	}
	public enum Slot{
		_1, _2, _3, _4, _5, _6;
		public static Slot get(int i){
			return values()[i-1];
		}
	}
	public static class Building{
		public static final String HSZ = "HSZ";
		public static final String WIL = "WIL";
		public static final String APB = "APB";
	}
	public static class APBRooms{
		public static String getRoom(char floor, int number){
			String n = number+"";
			while(n.length()<3)n = "0" + n;
			return (floor+"").toUpperCase() + n;
		}
	}
	public static class WILRooms{
		public static String getRoom(char block, int number){
			String n = number+"";
			while(n.length()<3)n = "0" + n;
			return (block+"").toUpperCase() + n;
		}
	}
	public static class HSZRooms{
		public static final String BUNKER = "0002/H";
		public static final String AUDIMAX = "0001/H"; //?
		public static final String H0003 = "0003/H";
		public static final String H0004 = "0004/H";
	}
	public static class Semester{
		public static class WS17_18{
			public static final int Algorithmen_und_Datenstrukturen = 3178139;
			public static final int Application_Development_for_Mobile_and_Ubiquitous_Computing_in_engl = 3178224;
			public static final int Betriebssysteme_und_Sicherheit = 3178271;
			public static final int Compiler_Construction = 3178288;
			public static final int Computergraphik_I = 3178316;
			public static final int Computer__und_robotergestütze_Chirurgie = 3203527;
			public static final int Computer_Vision_1 = 3178354;
			public static final int Datenbankadministration = 3178367;
			public static final int Datenbanken___Übung_zur_Vorlesung = 3178390;
			public static final int Description_Logic = 3178412;
			public static final int Distributed_Systems_Verteilte_Systeme = 3178437;
			public static final int Effiziente_parallele_Algorithmen = 3178474;
			public static final int Einführung_in_die_Medieninformatik = 3178491;
			public static final int Einführungspraktikum_RoboLab = 3178528;
			public static final int Engineering_industrieller_Kommunikationssysteme = 3178549;
			public static final int Formale_Systeme = 3178572;
			public static final int Formale_Übersetzungsmodelle = 3178588;
			public static final int Forschungskolleg_Datenbanken___Bachelor = 3178596;
			public static final int Grundlagenpraktikum_Computer_Vision = 3178714;
			public static final int Hauptseminar_Current_Topics_in_Compiler_Construction = 3178746;
			public static final int Hauptseminar_Mobile_and_Ubiquitous_Computing = 3178782;
			public static final int Hauptseminar_Technische_Informationssysteme = 3178849;
			public static final int Hochleistungsrechner_und_ihre_Programmierung_I = 3178884;
			public static final int Hochparallele_Simulationsrechnungen_mit_CUDA_und_OpenCL = 3178896;
			public static final int INF_110_Einführung_in_die_Mathematik_für_Informatiker___DS = 3201511;
			public static final int INF_110___Einführung_in_die_Mathematik_für_Informatiker___LA = 3201523;
			public static final int INF_120_Mathematische_Methoden_für_Informatiker = 3201535;
			public static final int Information_Retrieval = 3178942;
			public static final int Intelligente_Systeme = 3178960;
			public static final int Internetanwendungen_in_industriellen_Kommunikationssystemen = 3178988;
			public static final int iOS_Programmierung_Englisch = 3179010;
			public static final int Kanalkodierung = 3179026;
			public static final int Komplexpraktikum_Computer__und_robotergestütze_Chirurgie = 3203541;
			public static final int Konzepte_der_parallelen_Programmierung = 3179061;
			public static final int KP_Audio = 3203094;
			public static final int KP_Computergraphik_und_Visualisierung = 3179082;
			public static final int KP_Datenschutz_in_der_Anwendungsentwicklung = 3179108;
			public static final int KP_Interaktive_Multimediale_Technologien = 3179134;
			public static final int KP_Kryptographie_und_Datensicherheit = 3179153;
			public static final int KP_Mensch_Computer_Interaktion = 3179175;
			public static final int KP_Mobile_and_Ubiquitous_Computing = 3179190;
			public static final int KP_Paralleles_Rechnen = 3179227;
			public static final int KP_Rechnernetze = 3179256;
			public static final int KP_Service_and_Cloud_Computing = 3179268;
			public static final int KP_Software_Engineering_Ubiquitärer_Systeme = 3179280;
			public static final int KP_Softwaretechnologie = 3179314;
			public static final int KP_Technische_Informationssysteme = 3179333;
			public static final int Lab_rotation_Computational_Biology = 3179383;
			public static final int Leistungsanalyse_von_Rechnersystemen = 3179392;
			public static final int Maschinelles_Übersetzen_natürlicher_Sprachen = 3179427;
			public static final int Mensch_Computer_Interaktion = 3179461;
			public static final int Mobile_Communication_and_Mobile_Computing_Mobile_Kommunikation_und_Mobile_Computing = 3179501;
			public static final int Model_Checking = 3179522;
			public static final int Model_Driven_Web_Engineering_I = 3179528;
			public static final int Netzwerkmanagement_in_industriellen_Anwendungen = 3179533;
			public static final int Praktikum_Introduction_to_Computer_Vision = 3179559;
			public static final int Praktikum_Softwaretechnologie = 3179584;
			public static final int Praktikum_Technische_Informationssysteme = 3179604;
			public static final int Prediction_and_Estimation_Techniques = 3179614;
			public static final int Programmierung_von_Mikrokontrollern = 3179645;
			public static final int Proseminar_Audio = 3203101;
			public static final int Proseminar_Ausgewählte_Themen_der_Theoretischen_Informatik = 3179682;
			public static final int Proseminar_Datenbanken = 3179690;
			public static final int Proseminar_Datenschutz_in_der_Anwendungsentwicklung = 3179699;
			public static final int Proseminar_Mobile_and_Ubiquitous_Computing = 3179707;
			public static final int Proseminar_Natural_Language_Processing = 3179713;
			public static final int Proseminar_Rechnerarchitektur = 3179721;
			public static final int Proseminar_Service_and_Cloud_Computing = 3179727;
			public static final int Proseminar_Technische_Informatik = 3179737;
			public static final int Proseminar_Technische_Informationssysteme = 3179743;
			public static final int Proseminar_Theoretische_Informatik = 3179749;
			public static final int Rechnerarchitektur_I = 3179779;
			public static final int Rechnernetzpraxis = 3179800;
			public static final int Requirements_Engineering_und_Testen = 3179833;
			public static final int Security_and_Cryptography_I = 3179855;
			public static final int Seminar_Barrierefreie_Literaturerstellung = 3179898;
			public static final int Seminargruppen_Bachelor_Medien_Informatik = 3179917;
			public static final int Seminar_Interaktive_Multimediale_Technologien = 3179924;
			public static final int Seminar_Visual_Analytics = 3179957;
			public static final int Service_and_Cloud_Computing = 3179967;
			public static final int Softwareentwicklung_für_Echtzeitsteuerungen_I = 3180008;
			public static final int Softwareentwicklung_in_der_industriellen_Praxis = 3180021;
			public static final int Softwaretechnologie_II = 3180035;
			public static final int Systemorientierte_Informatik_und_Hardware_Software_Codesign = 3180050;
			public static final int Systems_Engineering_I = 3180061;
			public static final int Technische_Grundlagen_der_Informatik = 3180091;
			public static final int Test_von_Anwendungssystemen = 3180111;
			public static final int User_Interface_Engineering = 3180134;
			public static final int Web__und_Multimedia_Engineering = 3180154;
			public static final int Wissenschaftliche_Visualisierung = 3180172;
		}
	}
}
