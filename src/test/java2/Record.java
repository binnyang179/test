import java.text.Collator;
import java.util.Locale;

public class Record implements Comparable<Record> {

    private int id;
    private String name;
    private String phone;

    public Record(String sss, String s) {
    }


    public Record(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Record record) {
        return Collator.getInstance(Locale.CHINESE).compare(this.name, record.getName());
    }

    @Override
    public String toString(){
        return name+":"+phone+" ";
    }

}
