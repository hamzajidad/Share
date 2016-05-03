import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Dates
{
//	* Choix de la langue francaise
	static Locale locale = Locale.getDefault();
	static Date actuelle = new Date();
	static DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);

//	* Definition du format utilise pour les dates
	static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	static DateFormat heureFormat = new SimpleDateFormat("hh:mm:ss");


//	* Donne la date au format "aaaa-mm-jj"
	public static String date()
	{
		String dat = dateFormat.format(actuelle);
		return dat;
	}
	public static String heure()
	{
		String dat = heureFormat.format(actuelle);
		return dat;
	}
	
	
}