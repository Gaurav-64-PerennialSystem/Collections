package com.company;

public class Main {
     private static Logger logger=myLoggerClass.getLOGGER();
    public static void main(String[] args) {
	    
	    Theatre theatre = new Theatre("Olympian", 8, 12);
//        theatre.getSeats();
        if(theatre.reserveSeat("H11")) {
		
		logger.log(Level.FINE,"Please pay");
    
        } else {
            logger.log(Level.INFO,"Sorry, seat is taken");
        }
        if(theatre.reserveSeat("H11")) {
            logger.log(Level.FINE,"Please pay");
        } else {
            logger.log(Level.INFO,"Please pay");        }
    }
}



package com.company;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class myLoggerClass {
        private static Logger logger = Logger.getLogger(myLoggerClass.class.getName());



        public static Logger getLOGGER() {
            Handler fileHandler  =null;
            try {
                fileHandler = new FileHandler("./log.txt");
                logger.addHandler(fileHandler);
                fileHandler.setLevel(Level.ALL);
                logger.setLevel(Level.ALL);

            }catch(IOException ex){
                logger.log(Level.WARNING, "Error occur in FileHandler.", ex);
            }


            return logger;
        }
    }

