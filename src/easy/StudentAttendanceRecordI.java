package easy;

/**
 * ClassName: StudentAttendanceRecordI.java
 * Author: chenyiAlone
 * Create Time: 2019/11/27 22:34
 * Description: No.551 Student Attendance Record I
 */
public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int cntA = 0, cntL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') cntA++;
            if (s.charAt(i) == 'L') {
                if (cntL == 0 || i > 0 && s.charAt(i - 1) == 'L') 
                    cntL++;
            } else {
                cntL = 0;
            }
            if (cntA > 1 || cntL > 2) return false;
        }
        return true;
    }

}