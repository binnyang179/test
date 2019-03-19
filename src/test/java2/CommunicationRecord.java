import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommunicationRecord {
    private int size = 0;
    private List<Record> list = new ArrayList<Record>();
    public CommunicationRecord() {

    }

    public int getSize() {
        return size;
    }

    public void add(Record record) {
        if (record != null) {
            list.add(record);
            Collections.sort(list);
        }
    }
    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        CommunicationRecord communicationRecord = new CommunicationRecord();
        communicationRecord.add(new Record("sss", "213"));
        System.out.println(communicationRecord);
    }
}
