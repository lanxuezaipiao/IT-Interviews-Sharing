import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
	
public class PerformanceLog {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PerformanceLog main = new PerformanceLog();
        while(in.hasNext()) {
        	String num = in.nextLine();
        	int len = Integer.valueOf(num);
        	String logs[] = new String[len];
       /* 	logs[0] = "FuncA 00:00:01 START";
        	logs[1] = "FuncB 00:00:02 START";
        	logs[2] = "FuncC 00:00:03 START";
        	logs[3] = "FuncA 00:00:04 END";
        	logs[4] = "FuncB 00:00:05 END";
        	logs[5] = "FuncD 00:00:06 START";
        	logs[6] = "FuncD 00:00:07 END";
        	logs[7] = "FuncC 00:00:08 END";*/
        	
        	
        	for(int i  = 0; i < len; i++) {
        		logs[i] = in.nextLine();
        	}
        	main.LogAnalysis(logs, len);
        }
    }
    
    String getTime(String t1, String t2) {
    	Date d1 = null; 
	    Date d2 = null; 

	    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); 

	    try{ 
	        d1 = sdf.parse(t1); 
	        d2 = sdf.parse(t2); 
	    } catch (ParseException pe) { 
	        System.out.println("error"); 
	    } 
	    if(d2.getTime() > d1.getTime()) System.out.println("Incorrect performance log"); 
	    Date d = new Date(d1.getTime() - d2.getTime());
	    char strs[] = sdf.format(d).toCharArray();
	    strs[0] = '0';
	    strs[1] = '0';
	    
	    return new String(strs);
    }
    
    void LogAnalysis(String[] logs, int len) {
    	StringTokenizer st;
    	List<Log> logList = new ArrayList<Log>(len);
    	List<Log> results = new ArrayList<Log>(len);
    	boolean flag;
    	for(int i = 0; i < len; i++) {
    		flag = false;
    		st = new StringTokenizer(logs[i], " ");
    		String funcName = st.nextToken();
    		String time = st.nextToken();
    		String action = st.nextToken();
    		Log lg = new Log(funcName, time, action);
   // 		System.out.println(funcName + ":" + time + ":" + action);
    		for(Log log : logList) {
    			if(funcName.equals(log.funcName)) {
    				flag = true;
    				if(funcName.equals(logList.get(logList.size() - 1).funcName)) {
    					if(!action.equals("END") || !logList.get(logList.size() - 1).action.equals("START")) {
    						System.out.println("Incorrect performance log");
            				return;
    					}
    					String t1 = lg.timeStamp;
    					String t2 = logList.get(logList.size() - 1).timeStamp;
    		//			System.out.println("t1: " + t1 + "; t2: " + t2);
    					for(Log l : results) {
    						if(l.funcName.equals(funcName)) {
    							l.result = getTime(t1, t2);
    							break;
    						}
    					}
    			//		System.out.println(funcName + " " + getTime(t1, t2));
    					logList.remove(logList.size() - 1);
    				} else {
        				System.out.println("Incorrect performance log");
        				return;
        			}
    				break;
    			} 
    		}
    		if(!flag) {
    			logList.add(lg);
    			results.add(lg);
    		}
    	}
    	
    	for(Log log : results) {
    		System.out.println(log.funcName + " " + log.result);
    	}
    }
    
    class Log {
    	public String funcName;
    	public String timeStamp;
    	public String action;
    	public String result;
    	
    	public Log(String funcName, String timeStamp, String action) {
    		this.funcName = funcName;
    		this.timeStamp = timeStamp;
    		this.action = action;
    	}
    }
    
}