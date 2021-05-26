import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agenda {
    private String name;
    private String date;
    private String time;
    private Date dateObj = new Date();

    public Agenda(String name, String date, String time){
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }

    public String timeInHours () throws ParseException {
        String text = "";
        SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        String eventDateText = date+" "+time;
        Long currentDate = dateObj.getTime();

        Date eventDate = DF.parse(eventDateText);


        int hours = (int)(eventDate.getTime()-currentDate)/(60*60*1000);
        if(hours < 24){
            text ="Event is vandaag";

        } if((24 <= hours)&&(hours <=48)){
            text ="Event is morgen";

        }if(hours >48){
            text ="Event is overmorgen of later";

        }
        return text;

    }

    public boolean rejectEvent(){
        return ((getName().isEmpty()) || (getDate().isEmpty()) || (getTime().isEmpty()));
    }
}
