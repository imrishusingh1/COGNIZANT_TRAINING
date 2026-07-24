public class Logger{
    private static Logger obj;
    private Logger(){

    }

    public static synchronized Logger getInstance(){
        if(obj==null){
            obj=new Logger();
        }

        return obj;
    }
};