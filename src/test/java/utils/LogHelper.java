package utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class LogHelper extends Formatter
{
    // ANSI escape code
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Here you can configure the format of the output and
    // its color by using the ANSI escape codes defined above.

    // format is called for every console log message
    @Override
    public String format(LogRecord record)
    {
        // This example will print date/time, class, and log level in yellow,
        // followed by the log message and it's parameters in white .
        StringBuilder builder = new StringBuilder();

        switch (record.getLevel().getName()){
            case "SEVERE":
                builder.append(ANSI_RED);
                break;
            case "WARNING":
                builder.append(ANSI_YELLOW);
                break;
            case "INFO":
                builder.append(ANSI_BLACK);
                break;
            case "CONFIG":
                builder.append(ANSI_CYAN);
                break;
            default:
                builder.append(ANSI_GREEN);
                break;
        }

        builder.append("[");
        builder.append(calcDate(record.getMillis()));
        builder.append("]");

        builder.append(" [");
        builder.append(record.getSourceClassName());
        builder.append("]");

        builder.append(" [");
        builder.append(record.getLevel().getName());
        builder.append("]");

        builder.append(ANSI_WHITE);
        builder.append(" - ");
        builder.append(record.getMessage());

        Object[] params = record.getParameters();

        if (params != null)
        {
            builder.append("\t");
            for (int i = 0; i < params.length; i++)
            {
                builder.append(params[i]);
                if (i < params.length - 1)
                    builder.append(", ");
            }
        }

        builder.append(ANSI_RESET);
        builder.append("\n");
        return builder.toString();
    }

    private String calcDate(long millisecs) {
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultdate = new Date(millisecs);
        return date_format.format(resultdate);
    }

    public static Logger getLogger(Class<?> clazz){
        final Logger LOGGER = Logger.getLogger(clazz.getName());
        LOGGER.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        LogHelper formatter = new LogHelper();
        handler.setFormatter(formatter);
        LOGGER.addHandler(handler);
        return LOGGER;
    }
}