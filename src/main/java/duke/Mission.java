package duke;
public class Mission {
    enum MissionType {
        T, D, E;
    }
    String content;
    String state;
    String time;
    String atby;
    MissionType type;
    Time realtime;
    public Mission(String content, String type) {
        this.time = null;
        this.content = content;
        this.state = "✗";
        if(type.contentEquals("todo") || type.contentEquals("T")) {
            this.type = MissionType.T;
        } else if(type.contentEquals("deadline") || type.contentEquals("D")) {
            this.type = MissionType.D;
        } else if(type.contentEquals("event") || type.contentEquals("E")) {
            this.type = MissionType.E;
        }
    }
    public Mission(String content, String type, String state) {
        this.time = null;
        this.content = content;
        this.state = state;
        if(type.contentEquals("todo") || type.contentEquals("T")) {
            this.type = MissionType.T;
        } else if(type.contentEquals("deadline") || type.contentEquals("D")) {
            this.type = MissionType.D;
        } else if(type.contentEquals("event") || type.contentEquals("E")) {
            this.type = MissionType.E;
        }
    }
    public Mission(String content, String type, String state, String time, String atby) {
        this.time = null;
        this.content = content;
        this.state = state;
        this.time = time;
        this.atby = atby;
        if(type.contentEquals("todo") || type.contentEquals("T")) {
            this.type = MissionType.T;
        } else if(type.contentEquals("deadline") || type.contentEquals("D")) {
            this.type = MissionType.D;
        } else if(type.contentEquals("event") || type.contentEquals("E")) {
            this.type = MissionType.E;
        }
    }
    public Mission(String content, String type, String time, String atby) {
        this.time = time;
        realtime = new Time(time);
        this.content = content;
        this.state = "✗";
        this.atby = atby;
        if(type.contentEquals("todo") || type.contentEquals("T")) {
            this.type = MissionType.T;
        } else if(type.contentEquals("deadline") || type.contentEquals("D")) {
            this.type = MissionType.D;
        } else if(type.contentEquals("event") || type.contentEquals("E")) {
            this.type = MissionType.E;
        }
    }


    public void changeState() {
        if(this.state.contentEquals("✗")) {
            this.state = "✓";
        }
    }

    public String printMission() {
        if(time != null) {
            return "[" + type + "][" + state + "] " + content + " (" + atby + ":" + time + ")\n";
        } else {
            return "[" + type + "][" + state + "] " + content + "\n";
        }
    }


    public String getState() {
        return state;
    }

    public static Mission newMission(String str) {
        //System.out.println("*******" + str);
        String[] s = str.split("\\|");
        String MissionType = s[0];
        System.out.println("MissionType = " + MissionType);
        String state = (s[1].contentEquals("0")) ? "✗" : "✓";
        String content = s[2];
        Mission m;
        if(s.length == 4) {
            String time = s[3].replaceFirst("\\(by: ", "").replaceFirst("\\)", "");
            time = time.replaceFirst("\\(at: ", "").replaceFirst("\\)", "");
            m = new Mission(content, MissionType, state, time, "by");
        } else {
            m = new Mission(content, MissionType, state);
        }
        return m;
    }
}
